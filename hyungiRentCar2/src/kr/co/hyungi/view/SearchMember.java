package kr.co.hyungi.view;

import kr.co.hyungi.beans.UsageHistoryBean;


public class SearchMember {
	public void phone_view(UsageHistoryBean ub) {

		if (ub == null) {

			new Rent().user_add(); // 값이 존재하지 않으면 면허번호 창으로
		} else {
			new Rent().rent_time(); // 값이 존재하면 차량선택일정으로
		}
	}

}
