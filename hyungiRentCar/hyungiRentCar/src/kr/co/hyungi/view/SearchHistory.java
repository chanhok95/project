package kr.co.hyungi.view;

import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.UserData;

public class SearchHistory extends CommonMethod {

	public void mem_view(UsageHistoryBean ub) {
		if (ub == null) {
			System.out.println("��ȸ��  ���� �����ϴ�.");
			System.out.println("�ٽð��� �Է����ֽñ� �ٶ��ϴ�");

		} else {
			System.out.println("��ȸ�� ����� ������ �Ʒ��� �����ϴ�.");
			System.out.println("����ȣ:" + ub.getCarNo());
			System.out.println("�����ȣ:" + ub.getLicenseNo());
			System.out.println("����ȣ:" + ub.getPhoneNo());
			System.out.println("�뿩��¥:" + ub.getRentStartDate());
			System.out.println("�ݳ���¥:" + ub.getRentEndDate());
			del_view();
		}

	}
	public void del_view() {
	System.out.println("�뿩��� �Ͻðڽ��ϱ�? ");
	System.out.println("�뿩 ��� �Ͻ÷��� �Է��Ͻ� ����ȣ�� �Է��ϼ���. ");
	UserData ud =new UserData();
	String idx = new CommonMethod().inputMsg();
	int cnt = ud.del_mem(Integer.parseInt(idx));
	}
}
