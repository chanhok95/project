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

public class MemberData {
	public List<MemberBean> def_data() {

		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		List<MemberBean> list = new ArrayList<MemberBean>();

		try {
			stmt = con.createStatement();
			String sql = "SELECT phoneno,memname,licenseno FROM rent_member";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberBean ub = new MemberBean();
				ub.setPhoneNo(rs.getString(1));
				ub.setMemName(rs.getString(2));
				ub.setLicenseNo(rs.getNString(3));

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

	public boolean isMember(String phoneno) {
		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT phoneno FROM RENT_MEMBER WHERE phoneno = '" + phoneno+"'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return true;
			}
			else
				return false;

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
		return false;

	}


	
	
	
	
	
}
