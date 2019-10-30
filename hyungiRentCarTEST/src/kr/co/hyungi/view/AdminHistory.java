package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.HistoryData;

public class AdminHistory extends CommonMethod {

	SearchHistory sh = new SearchHistory();
	HistoryData hd = new HistoryData();
	ArrayList<UsageHistoryBean> arUhb =null;
	
	public void history() {
		boolean adBool = true;
		while (adBool) {

			System.out.println();
			System.out.println("   [ 1 ] �̿� ���� ��ü ��ȸ");
			System.out.println("   [ 2 ] ����ȣ �� ���� ��ȸ");
			System.out.println("   [ 3 ] �Ⱓ ��ȸ(�뿩 ������ ����)");
			System.out.println("   [ x ] �� �ܰ�");
			System.out.println();

			String sel = inputMsg();

			if (sel.equals("1")) {
				arUhb = hd.allData();
				sh.historyView(arUhb);
			} else if (sel.equals("2")) {
				String phoneNo = phoneNoInput();
				//010���� �����ϴ� 11�ڸ� �������� Ȯ��
				arUhb = hd.historyPhoneNo(phoneNo);

				if (arUhb.isEmpty()) {
					System.out.println("�ش� ������� �̿볻���� �����ϴ�");
				} else {
					sh.historyView(arUhb);
				}

			} else if (sel.equals("3")) {
				String dateInput = dateInputInput();
				if(dateInput.equals("x"))
					break;
				//��¥�� xxxxxx-xxxxxx ���Ͻ�, �������� �ԷµǾ����� Ȯ�� ��1~12,��1~30or1~31,��00~<24
				arUhb = hd.historyDate(dateInput);
				sh.historyView(arUhb);
			} else if (sel.equals("x")) {
				System.out.println("�� �ܰ�� �̵��մϴ�");
				adBool = false;
			}
		}
		System.out.println();

	}

	public String dateInputInput() {

		System.out.println("�Ⱓ�� �Է��ϼ��� (�뿩������ ����)");
		System.out.println("ex) 010102-010103 (���Ͻ�-���Ͻ�)");	
		String dateInput = inputMsg();

		return dateInput;

	}

}
