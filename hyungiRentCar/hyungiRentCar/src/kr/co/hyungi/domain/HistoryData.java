package kr.co.hyungi.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.view.CommonMethod;
import kr.co.hyungi.view.Rent;

public class HistoryData {
	public List<UsageHistoryBean> def_data(String phoneno) {

		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		List<UsageHistoryBean> list = new ArrayList<UsageHistoryBean>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM rent_history WHERE state ='예약중' and phoneno ='" + phoneno + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt(1));
				ub.setCarNo(rs.getInt(2));
				ub.setPhoneNo(rs.getNString(3));
				ub.setLicenseNo(rs.getString(4));
				ub.setRentStartDate(rs.getString(5));
				ub.setRentEndDate(rs.getString(6));
				ub.setState(rs.getString(7));
				list.add(ub);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

	public List<UsageHistoryBean> state() { // 현재 이용중인지 예약중인지 확인

		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		List<UsageHistoryBean> list = new ArrayList<UsageHistoryBean>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM rent_history where state= '예약중' or state= '이용중'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UsageHistoryBean ub = new UsageHistoryBean();
				ub.setRentNo(rs.getInt(1));
				ub.setCarNo(rs.getInt(2));
				ub.setPhoneNo(rs.getNString(3));
				ub.setLicenseNo(rs.getString(4));
				ub.setRentStartDate(rs.getString(5));
				ub.setRentEndDate(rs.getString(6));
				ub.setState(rs.getString(7));
				list.add(ub);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

	public void ins(String carNo, String phoneNo, String licenseno, String startenddate) {
		Connection con = new CommonMethod().dbCon();
		String rentStartDate = startenddate.split("-")[0];
		String rentEndDate = startenddate.split("-")[1];
		
		String sql = "INSERT INTO RENT_HISTORY(rentno,carno,phoneno,licenseno,rentStartDate,rentEndDate)";
		String sql2 = "VALUES(rent_history_seq.nextval,?,?,?,to_date(?,'mmddhh24'),to_date(?,'mmddhh24'))";
		
//		String sql = "INSERT INTO RENT_HISTORY(rentno,carno,phoneno,licenseno,rentStartDate,rentEndDate)";
//		String sql2 = "VALUES(rent_history_seq.nextval,?,?,?,to_date(?,'mmddhh24'),to_date(?,'mmddhh24'))";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql + sql2);
			pstmt.setString(1, carNo);
			pstmt.setString(2, phoneNo);
			pstmt.setString(3, licenseno);
			pstmt.setString(4, rentStartDate);
			pstmt.setString(5, rentEndDate);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void delHistory(int rentno) {
		Connection con = new CommonMethod().dbCon();
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {
			String sql = "DELETE FROM rent_history WHERE rentno =?";
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, rentno);

			cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("대여 취소하셨습니다.");
				new Rent().rent();
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("비정상 종료:rollback 실행");
				con.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					System.out.println("AutoCommit Setting true");
					con.setAutoCommit(true);
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	
}
