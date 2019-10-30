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
			System.out.println("   [ 1 ] 이용 내역 전체 조회");
			System.out.println("   [ 2 ] 폰번호 별 내역 조회");
			System.out.println("   [ 3 ] 기간 조회(대여 시작일 기준)");
			System.out.println("   [ x ] 전 단계");
			System.out.println();

			String sel = inputMsg();

			if (sel.equals("1")) {
				arUhb = hd.allData();
				sh.historyView(arUhb);
			} else if (sel.equals("2")) {
				String phoneNo = phoneNoInput();
				//010으로 시작하는 11자리 숫자인지 확인
				arUhb = hd.historyPhoneNo(phoneNo);

				if (arUhb.isEmpty()) {
					System.out.println("해당 사용자의 이용내역이 없습니다");
				} else {
					sh.historyView(arUhb);
				}

			} else if (sel.equals("3")) {
				String dateInput = dateInputInput();
				if(dateInput.equals("x"))
					break;
				//날짜가 xxxxxx-xxxxxx 월일시, 형식으로 입력되었는지 확인 월1~12,일1~30or1~31,시00~<24
				arUhb = hd.historyDate(dateInput);
				sh.historyView(arUhb);
			} else if (sel.equals("x")) {
				System.out.println("전 단계로 이동합니다");
				adBool = false;
			}
		}
		System.out.println();

	}

	public String dateInputInput() {

		System.out.println("기간을 입력하세요 (대여시작일 기준)");
		System.out.println("ex) 010102-010103 (월일시-월일시)");	
		String dateInput = inputMsg();

		return dateInput;

	}

}
