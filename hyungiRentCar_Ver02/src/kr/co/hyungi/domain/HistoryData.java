package kr.co.hyungi.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.view.CommonMethod;
import kr.co.hyungi.view.Rent;

public class HistoryData extends CommonMethod {

	public ArrayList<UsageHistoryBean> getHistoryReturn(String phoneNo) { // 현재 이용중인지 예약중인지 확인

		ArrayList<UsageHistoryBean> arUhb = new ArrayList<UsageHistoryBean>();

		Connection conn = dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM rent_history where phoneno = ? and (state= '예약중' or state= '사용중')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt("rentNo"));
				ub.setCarNo(rs.getInt("carNo"));
				ub.setPhoneNo(rs.getString("phoneNo"));
				ub.setLicenseNo(rs.getString("licenseNo"));
				ub.setRentStartDate(rs.getString("rentStartDate"));
				ub.setRentEndDate(rs.getString("rentEndDate"));
				ub.setState(rs.getString("state"));
				arUhb.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arUhb;
	}

	public ArrayList<UsageHistoryBean> getCurrentHistory(String phoneNo) {
		ArrayList<UsageHistoryBean> arUhb = new ArrayList<UsageHistoryBean>();

		Connection conn = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM rent_history WHERE state ='예약중' and phoneNo ='" + phoneNo + "' order by rentNo";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt("rentNo"));
				ub.setCarNo(rs.getInt("carNo"));
				ub.setPhoneNo(rs.getString("phoneNo"));
				ub.setLicenseNo(rs.getString("licenseNo"));
				ub.setRentStartDate(rs.getString("rentStartDate"));
				ub.setRentEndDate(rs.getString("rentEndDate"));
				ub.setRentCost(rs.getInt("rentCost"));
				ub.setState(rs.getString("state"));
				arUhb.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arUhb;
	}

	public void payment(String dateInput, CarBean cb, String phoneNo, String licenseNo) {

		String rentStartDate = dateInput.split("-")[0];
		String rentEndDate = dateInput.split("-")[1];

		Connection con = new CommonMethod().dbCon();
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO RENT_HISTORY(rentNo, carNo, phoneNo, licenseNo, rentStartDate, rentEndDate, state, rentCost)"
				+ "VALUES(rent_history_seq.nextval,?,?,?,to_date(?,'mmddhh24'),to_date(?,'mmddhh24'),'예약중',?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cb.getCarNo());
			pstmt.setString(2, phoneNo);
			pstmt.setString(3, licenseNo);
			pstmt.setString(4, rentStartDate);
			pstmt.setString(5, rentEndDate);
			long calHour = new Rent().costCal(dateInput);
			pstmt.setInt(6, (int) (cb.getCostPerHour() * calHour));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getRentNo(String historyRowNum, String phoneNo) {

		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select rentNo from (select rownum historyRowNum, a.* from (SELECT * FROM rent_history WHERE state ='예약중' and phoneNo ='"
					+ phoneNo + "' order by rentNo) a) where historyRowNum='" + historyRowNum + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return Integer.toString(rs.getInt("rentNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getReturnRentNo(String historyRowNum, String phoneNo) {

		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select rentNo from (select rownum historyRowNum, a.* from (SELECT * FROM rent_history WHERE (state='이용중' or state ='예약중') and phoneNo ='"
					+ phoneNo + "' order by rentNo) a) where historyRowNum='" + historyRowNum + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return Integer.toString(rs.getInt("rentNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public UsageHistoryBean getOneHistory(String rentNo) {

		UsageHistoryBean ub = null;

		Connection conn = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM rent_history WHERE rentNo ='" + rentNo + "'";

			rs = stmt.executeQuery(sql);
			rs.next();
			ub = new UsageHistoryBean();
			ub.setRentNo(rs.getInt("rentNo"));
			ub.setCarNo(rs.getInt("carNo"));
			ub.setPhoneNo(rs.getString("phoneNo"));
			ub.setLicenseNo(rs.getString("licenseNo"));
			ub.setRentStartDate(rs.getString("rentStartDate"));
			ub.setRentEndDate(rs.getString("rentEndDate"));
			ub.setRentCost(rs.getInt("rentCost"));
			ub.setState(rs.getString("state"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ub;
	}

	public void delHistory(String rentNo) {
		Connection conn = dbCon();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM rent_history WHERE rentNo =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(rentNo));

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				System.out.println("비정상 종료:rollback 실행");
				conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					System.out.println("AutoCommit Setting true");
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void returnHistory(String rentNo) {
		Connection conn = dbCon();
		PreparedStatement pstmt = null;
		String sql = "UPDATE rent_history SET state = '반납완료'  WHERE rentno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(rentNo));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<UsageHistoryBean> allData() {
		ArrayList<UsageHistoryBean> arUhb = new ArrayList<UsageHistoryBean>();
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from rent_history order by rentNo";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt("rentNo"));
				ub.setPhoneNo(rs.getString("phoneNo"));
				ub.setLicenseNo(rs.getString("licenseNo"));
				ub.setCarNo(rs.getInt("carNo"));
				ub.setRentStartDate(rs.getString("rentStartDate"));
				ub.setRentEndDate(rs.getString("rentEndDate"));
				ub.setRentCost(rs.getInt("rentCost"));
				ub.setState(rs.getString("state"));
				arUhb.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arUhb;
	}

	public ArrayList<UsageHistoryBean> historyPhoneNo(String phoneNo) {

		ArrayList<UsageHistoryBean> arUhb = new ArrayList<UsageHistoryBean>();

		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM rent_history where phoneNo='"+phoneNo+"' order by rentNo";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt("rentNo"));
				ub.setCarNo(rs.getInt("carNo"));
				ub.setPhoneNo(rs.getString("phoneNo"));
				ub.setLicenseNo(rs.getString("licenseNo"));
				ub.setRentStartDate(rs.getString("rentStartDate"));
				ub.setRentEndDate(rs.getString("rentEndDate"));
				ub.setRentCost(rs.getInt("rentCost"));
				ub.setState(rs.getString("state"));
				arUhb.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arUhb;
	}

	public ArrayList<UsageHistoryBean> historyDate(String dateInput) {
		ArrayList<UsageHistoryBean> arUhb = new ArrayList<UsageHistoryBean>();

		String firstD = dateInput.split("-")[0];
		String secondD = dateInput.split("-")[1];
		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM rent_history where rentStartDat>=to_date('"+firstD+"','mmddhh24') and rentEndDate<(to_date('"+secondD+"','mmddhh24')+1) order by rentNo";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt("rentNo"));
				ub.setCarNo(rs.getInt("carNo"));
				ub.setPhoneNo(rs.getString("phoneNo"));
				ub.setLicenseNo(rs.getString("licenseNo"));
				ub.setRentStartDate(rs.getString("rentStartDate"));
				ub.setRentEndDate(rs.getString("rentEndDate"));
				ub.setRentCost(rs.getInt("rentCost"));
				ub.setState(rs.getString("state"));
				arUhb.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arUhb;
	}
}
