package kr.co.hyungi.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.view.CommonMethod;

public class CarData extends CommonMethod {
	

	public boolean enterOk(String carNo, String dateInput) {

		String rentStartDate = dateInput.split("-")[0];
		String rentEndDate = dateInput.split("-")[1];

		Connection con = dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT carNo FROM rent_history WHERE carNo = ? AND (state = '예약중' or state='이용중' "
				+ "AND NOT ( to_char ( rentStartDate, 'mmddhh24') > ? "
				+ "OR to_char ( rentEndDate, 'mmddhh24') < ? ))";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carNo);
			pstmt.setString(2, rentEndDate);
			pstmt.setString(3, rentStartDate);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<CarBean> getAvailableCar(String rentNo, String dateInput) {

		String rentStartDate = dateInput.split("-")[0];
		String rentEndDate = dateInput.split("-")[1];

		ArrayList<CarBean> arCb = new ArrayList<CarBean>();
		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql ="select rownum carRowNum, a.* from (select * from (select * from rent_history where rentNo!='"+rentNo+"') where (state='예약중' or state='이용중') and carNo not in(select carNo from rent_history where not ( to_char(rentStartDate,'mmddhh24')>'"+rentEndDate+"' or ( to_char(rentEndDate,'mmddhh24')<'"+rentStartDate+"'))) order by carno) a";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CarBean cb = new CarBean();
				cb.setCarNo(rs.getInt("carNo"));
				cb.setCarColor(rs.getString("carColor"));
				cb.setCarModel(rs.getString("carModel"));
				cb.setCostPerHour(rs.getInt("costPerHour"));
				arCb.add(cb);
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
		return arCb;
	}
	
	public ArrayList<CarBean> modAvailableCar(String rentNo, String dateInput) {

		String rentStartDate = dateInput.split("-")[0];
		String rentEndDate = dateInput.split("-")[1];

		ArrayList<CarBean> arCb = new ArrayList<CarBean>();
		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql ="select * from rent_car where carNo in (select carNo from (select * from (select * from rent_history where rentNo!='"+rentNo+"') where (state='예약중' or state='이용중') and carNo not in(select carNo from rent_history where not ( to_char(rentStartDate,'mmddhh24')>'"+rentEndDate+"' or ( to_char(rentEndDate,'mmddhh24')<'"+rentStartDate+"'))) order by carno) a)";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CarBean cb = new CarBean();
				cb.setCarNo(rs.getInt("carNo"));
				cb.setCarColor(rs.getString("carColor"));
				cb.setCarModel(rs.getString("carModel"));
				cb.setCostPerHour(rs.getInt("costPerHour"));
				arCb.add(cb);
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
		return arCb;
	}
	
	public ArrayList<CarBean> getAvailableCar(String dateInput) {

		String rentStartDate = dateInput.split("-")[0];
		String rentEndDate = dateInput.split("-")[1];

		ArrayList<CarBean> arCb = new ArrayList<CarBean>();
		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql ="select rownum carRowNum, a.* from (select * from rent_car where carNo not in(select carNo from rent_history where  (state='예약중' or state='이용중') and not ( to_char(rentStartDate,'mmddhh24')>'"+rentEndDate+"' or ( to_char(rentEndDate,'mmddhh24')<'"+rentStartDate+"'))) order by carno) a";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CarBean cb = new CarBean();
				cb.setCarNo(rs.getInt("carNo"));
				cb.setCarColor(rs.getString("carColor"));
				cb.setCarModel(rs.getString("carModel"));
				cb.setCostPerHour(rs.getInt("costPerHour"));
				arCb.add(cb);
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
		return arCb;
	}
	
	public CarBean getOneCar(String carNo) {
		CarBean cb = null;
		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql ="select * from rent_car where carNo="+carNo;
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				cb= new CarBean();
				cb.setCarNo(rs.getInt("carNo"));
				cb.setCarColor(rs.getString("carColor"));
				cb.setCarModel(rs.getString("carModel"));
				cb.setCostPerHour(rs.getInt("costPerHour"));
			}
			return cb;
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

	public String getCarNo(String carRowNum, String dateInput) {

		String rentStartDate = dateInput.split("-")[0];
		String rentEndDate = dateInput.split("-")[1];

		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql ="select * from (select rownum carRowNum, a.* from (select * from rent_car where carNo not in(select carNo from rent_history where not ( to_char(rentStartDate,'mmddhh24')>'"+rentEndDate+"' or ( to_char(rentEndDate,'mmddhh24')<'"+rentStartDate+"'))) order by carno) a) where carRowNum='"+carRowNum+"'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return Integer.toString(rs.getInt("carNo"));
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

	public String getCarNo(String carRowNum) {

		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql ="select carNo from (select rownum carRowNum, a.* from (select * from rent_car order by carNo) a) where carRowNum="+carRowNum;
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return Integer.toString(rs.getInt("carNo"));
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

	public void modifyCar(String carNo, String mCarModel, String mCarColor, String mCostPerHour) {
		Connection conn = dbCon();
		PreparedStatement pstmt = null;
		String sql = "update rent_car set carModel=?,carColor=?,costPerHour=? where carNo=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mCarModel);
			pstmt.setString(2, mCarColor);
			pstmt.setInt(3, Integer.parseInt(mCostPerHour));
			pstmt.setInt(4, Integer.parseInt(carNo));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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

	public void insertCar(String carModel, String carColor, String costPerHour) {

		Connection conn = dbCon();
		String sql1 = "INSERT INTO rent_car(carNo, carColor, carModel, costPerHour) ";
		String sql2 = "VALUES(rent_car_seq.nextval,?,?,?)";
		int cnt = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql1 + sql2);
			pstmt.setString(1, carColor);
			pstmt.setString(2, carModel);
			pstmt.setInt(3, Integer.parseInt(costPerHour));

			cnt = pstmt.executeUpdate();
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
		System.out.println(cnt + " 개의 차량이 등록되었습니다");
	}

	public void deleteCar(String carNo) {

			Connection conn = dbCon();
			PreparedStatement pstmt = null;
			String sql = "delete from rent_car where carNo=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(carNo));
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	public ArrayList<CarBean> allData() {
		ArrayList<CarBean> arCb = new ArrayList<CarBean>();
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs= null;
		String sql = "select * from rent_car order by carNo";
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				CarBean cb =new CarBean();
				cb.setCarNo(rs.getInt("carNo"));
				cb.setCarModel(rs.getString("carModel"));
				cb.setCarColor(rs.getString("carColor"));
				cb.setCostPerHour(rs.getInt("costPerHour"));
				arCb.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arCb;
	}
}
