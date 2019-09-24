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
				ub.setPhoneNo(rs.getInt(1));
				ub.setMemName(rs.getString(2));
				ub.setLicenseNo(rs.getInt(3));

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

	public Object getphone(String phoneno) {
		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		UsageHistoryBean ub = null;
		String sql = "SELECT phoneno FROM RENT_MEMBER WHERE phoneno = " + phoneno;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				ub = new UsageHistoryBean();
				ub.setPhoneNo(rs.getInt(1));
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
		return ub;

	}

//insert into rent_history(rentNo,phoneno) values(rent_history_seq.nextval,1234);
	public int ins_licenseno(int licenseno) {
		Connection con = new CommonMethod().dbCon();
		String sql = "INSERT INTO RENT_HISTORY(rentno,licenseno)";
		String sql2 = "VALUES(rent_history_seq.nextval,?)";
		int cnt = 0;
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql + sql2);
			pstmt.setInt(1, licenseno);
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

	public int ins_data(String rentStartDate, String rentEndDate) {
		Connection con = new CommonMethod().dbCon();
		String sql = "INSERT INTO RENT_HISTORY(rentno,rentStartDate,rentEndDate)";
		String sql2 = "VALUES(rent_history_seq.nextval,?,?)";
		int cnt = 0;
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql + sql2);
			pstmt.setString(1, rentStartDate);
			pstmt.setString(2, rentEndDate);

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
	
	
	public int del_mem(int phoneno) {
		Connection con = new CommonMethod().dbCon();
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {
			String sql = "DELETE FROM rent_history WHERE phoneno =?";
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,phoneno);
			cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("대여 취소하셨습니다.");
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
		return 0;
	}

	public void isMember(String phoneNo) {
		// TODO Auto-generated method stub
		
	}
	
}
