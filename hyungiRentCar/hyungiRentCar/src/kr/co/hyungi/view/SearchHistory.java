package kr.co.hyungi.view;

import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.UserData;

public class SearchHistory extends CommonMethod {

	public void mem_view(UsageHistoryBean ub) {
		if (ub == null) {
			System.out.println("조회된  값이 없습니다.");
			System.out.println("다시값을 입력해주시기 바랍니다");

		} else {
			System.out.println("조회된 사원의 정보는 아래와 같습니다.");
			System.out.println("차번호:" + ub.getCarNo());
			System.out.println("면허번호:" + ub.getLicenseNo());
			System.out.println("폰번호:" + ub.getPhoneNo());
			System.out.println("대여날짜:" + ub.getRentStartDate());
			System.out.println("반납날짜:" + ub.getRentEndDate());
			del_view();
		}

	}
	public void del_view() {
	System.out.println("대여취소 하시겠습니까? ");
	System.out.println("대여 취소 하시려면 입력하신 폰번호를 입력하세요. ");
	UserData ud =new UserData();
	String idx = new CommonMethod().inputMsg();
	int cnt = ud.del_mem(Integer.parseInt(idx));
	}
}
