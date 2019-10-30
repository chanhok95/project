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

		System.out.println("**********************************");
		System.out.println("��ȸ�� �뿩������ �Ʒ��� �����ϴ�.");
		System.out.println("**********************************");
		for (int i = 0; i < arUhb.size(); i++) {
			System.out.println("���� No(��ȣ):" + (i + 1));
			System.out.println("��Ʈ��ȣ:" + arUhb.get(i).getRentNo());
			System.out.println("����ȣ:" + arUhb.get(i).getCarNo());
			System.out.println("����ȣ:" + arUhb.get(i).getPhoneNo());
			System.out.println("�����ȣ:" + arUhb.get(i).getLicenseNo());
			System.out.println("�뿩��¥:" + arUhb.get(i).getRentStartDate());
			System.out.println("�ݳ���¥:" + arUhb.get(i).getRentEndDate());
			System.out.println("��Ʈ���:" + arUhb.get(i).getRentCost());
			System.out.println("�뿩����:" + arUhb.get(i).getState());
			System.out.println("**********************************");
			System.out.println("**********************************");
			System.out.println("**********************************");

		}
	}

	public void historyView(UsageHistoryBean ub) {

		System.out.println("��Ʈ��ȣ:" + ub.getRentNo());
		System.out.println("����ȣ:" + ub.getCarNo());
		System.out.println("����ȣ:" + ub.getPhoneNo());
		System.out.println("�����ȣ:" + ub.getLicenseNo());
		System.out.println("�뿩��¥:" + ub.getRentStartDate());
		System.out.println("�ݳ���¥:" + ub.getRentEndDate());
		System.out.println("��Ʈ���:" + ub.getRentCost());
		System.out.println("�뿩����:" + ub.getState());
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("**********************************");

	}

	public void memHistory() {

		System.out.println("ȸ�� �̿볻�� ��ȸ �Դϴ�");
		System.out.println("===================");
		System.out.println("ȸ�� �ڵ�����ȣ ��ȸ(13)");
		String phoneNo = inputMsg();

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
	}

	public void paymentView(String dateInput, CarBean cb) {
		System.out.println("************************************************************");
		System.out.println("*********��¥ : " + dateInput + "*********************************");
		new SearchCar().carView(cb, dateInput);

	}

}
