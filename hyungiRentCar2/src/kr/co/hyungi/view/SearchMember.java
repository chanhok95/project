package kr.co.hyungi.view;

import kr.co.hyungi.beans.UsageHistoryBean;


public class SearchMember {
	public void phone_view(UsageHistoryBean ub) {

		if (ub == null) {

			new Rent().user_add(); // ���� �������� ������ �����ȣ â����
		} else {
			new Rent().rent_time(); // ���� �����ϸ� ����������������
		}
	}

}
