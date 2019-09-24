package kr.co.hyungi.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.view.CommonMethod;

public class CarData {
	public List<CarBean> def_data() {

		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		List<CarBean> list = new ArrayList<CarBean>();

		try {
			stmt = con.createStatement();
			String sql = "SELECT CARNO,CARCOLOR,CARMODEL,COSTPERHOUR FROM RENT_CAR";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CarBean cb = new CarBean();
				cb.setCarNo(rs.getInt(1));
				cb.setCarColor(rs.getString(2));
				cb.setCarModel(rs.getString(3));
				cb.setCostPerHour(rs.getInt(4));
				list.add(cb);
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
	public int ins_carno(int carno) {
		Connection con = new CommonMethod().dbCon();
		String sql = "INSERT INTO RENT_HISTORY(rentno,carno)";
		String sql2 = "VALUES(rent_history_seq.nextval,?)";
		int cnt = 0;
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql + sql2);
			pstmt.setInt(1, carno);
			cnt = pstmt.executeUpdate();
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

		return cnt;
	}
}
