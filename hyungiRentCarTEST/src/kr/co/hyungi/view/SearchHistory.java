package kr.co.hyungi.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.beans.UsageHistoryBean;

public class SearchHistory extends CommonMethod {

	public void historyView(ArrayList<UsageHistoryBean> arUhb) {

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("■■     조회된 대여 정보 결과         ■■");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		for (int i = 0; i < arUhb.size(); i++) {
			System.out.println("   ┏━━━━━━━━━━━━━━┓");
			System.out.println("   ■ [ 예약 No ] : " + (i+1));
			System.out.println("   ┗━━━━━━━━━━━━━━┛");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("┃ [ 렌트 번호 ] : " +arUhb.get(i).getRentNo());
			System.out.println("┃ [ 차량 번호 ] : " +arUhb.get(i).getCarNo());
			System.out.println("┃ [ 폰 번호 ] : " +arUhb.get(i).getPhoneNo());
			System.out.println("┃ [ 면허 번호 ] : " +arUhb.get(i).getLicenseNo());
			System.out.println("┃ [ 대여 날짜 ] : " +arUhb.get(i).getRentStartDate());
			System.out.println("┃ [ 반납 날짜ㅣ ] : " + arUhb.get(i).getRentEndDate());
			System.out.println("┃ [ 렌트 비용 ] : " +arUhb.get(i).getRentCost());
			System.out.println("┃ [ 대여 상태 ] : " + arUhb.get(i).getState());
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		}
	}

	public void historyView(UsageHistoryBean ub) {

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┃ [ 렌트 번호 ] : " +ub.getRentNo());
		System.out.println("┃ [ 차량 번호 ] : " +ub.getCarNo());
		System.out.println("┃ [ 폰 번호 ] : " +ub.getPhoneNo());
		System.out.println("┃ [ 면허 번호 ] : " +ub.getLicenseNo());
		System.out.println("┃ [ 대여 날짜 ] : " +ub.getRentStartDate());
		System.out.println("┃ [ 반납 날짜ㅣ ] : " +ub.getRentEndDate());
		System.out.println("┃ [ 렌트 비용 ] : " +ub.getRentCost());
		System.out.println("┃ [ 대여 상태 ] : " +ub.getState());
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	}

	public void memHistory() {

		System.out.println("회원 이용내역 조회 입니다");
		System.out.println("===================");
		System.out.println("회원 핸드폰번호 조회(13)");
		String phoneNo = inputMsg();
//		boolean chk = new MemberData().chkMem(phoneNo);
//		if (chk == true) {

		Connection con = dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM rent_history WHERE phoneno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNo);
			rs = pstmt.executeQuery();
			System.out.println(
					"rentNo\tcarNo\tphoneNo\tlicenseNo\trentStart\trentEnd\trentFinal\trentCost\taddCost\tstate");
			System.out.println(
					"================================================================================================");
			if (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print("\t");
				System.out.print(rs.getInt(2));
				System.out.print("\t");
				System.out.print(rs.getInt(3));
				System.out.print("\t");
				System.out.print(rs.getInt(4));
				System.out.print("\t");
				System.out.print(rs.getDate(5));
				System.out.print("\t");
				System.out.print(rs.getDate(6));
				System.out.print("\t");
				System.out.print(rs.getDate(7));
				System.out.print("\t");
				System.out.print(rs.getInt(8));
				System.out.print("\t");
				System.out.print(rs.getInt(9));
				System.out.print("\t");
				System.out.print(rs.getString(10));
				System.out.print("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void paymentView(String dateInput, CarBean cb) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   대여 기간 : "+ dateInput);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		// 선택 차량 정보 보여주기
		new SearchCar().carView(cb, dateInput);

	}

}
