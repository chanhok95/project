package kr.co.hyungi.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.view.CommonMethod;

public class MemberData extends CommonMethod {

	public boolean isMember(String phoneNo) {
		Connection con = new CommonMethod().dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT phoneNo FROM RENT_MEMBER WHERE phoneNo = '" + phoneNo + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return true;
			} else
				return false;

		} catch (SQLException e) {
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
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void deleteMember(String phoneNo) {

		Connection con = dbCon();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM rent_member WHERE phoneno = ?";
		int cnt = 0;

		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNo);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				System.out.println(cnt + "건 삭제");
				System.out.println("AutoCommit Setting True");
				con.setAutoCommit(true);
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public MemberBean getOneMember(String phoneNo) {
		
		MemberBean mb = null;
		
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM rent_member WHERE phoneno = '" + phoneNo+"'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				mb = new MemberBean();
				mb.setPhoneNo(rs.getString("phoneNo"));
				mb.setLicenseNo(rs.getString("licenseNo"));
				mb.setMemName(rs.getString("memName"));
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
		return mb;
	}

	public String getLicenseNo(String phoneNo) {

		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT licenseNo FROM rent_member WHERE phoneno = '" + phoneNo+"'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getString("licenseNo");
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

	public ArrayList<MemberBean> allData() {
		ArrayList<MemberBean> arMb = new ArrayList<MemberBean>();
		Connection conn = dbCon();
		Statement stmt = null;
		ResultSet rs= null;
		String sql = "select * from rent_Member";
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				MemberBean mb =new MemberBean();
				mb.setPhoneNo(rs.getString("phoneno"));
				mb.setMemName(rs.getString("memname"));
				mb.setLicenseNo(rs.getString("licenseno"));
				arMb.add(mb);
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
		
		return arMb;
	}
	
	public void insertMember(String phoneNo, String memName, String licenseNo) {

		Connection con = dbCon();
		String sql1 = "INSERT INTO rent_member(phoneno, memname, licenseno) ";
		String sql2 = "VALUES(?,?,?)";
		int cnt = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql1 + sql2);
			pstmt.setString(1, phoneNo);
			pstmt.setString(2, memName);
			pstmt.setString(3, licenseNo);

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
		System.out.println(cnt + " 개의 회원 데이터 입력");
	}

	public void modifyMember(String phoneNo, String mPhoneNo, String memName, String licenseNo) {

		Connection con = dbCon();
		String sql = "UPDATE rent_member SET phoneNo=?, memname = ?, licenseno = ? WHERE phoneno = ?";
		int cnt = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mPhoneNo);
			pstmt.setString(2, memName);
			pstmt.setString(3, licenseNo);
			pstmt.setString(4, phoneNo);

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 면허번호는 이미 등록되어 있습니다");
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
		System.out.println(cnt + " 개의 회원 데이터 수정");
	}
}
