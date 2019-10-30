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
			System.out.println("======================");
			System.out.println("===1. 이용내역전체조회==========");
			System.out.println("===2. 회원별내역조회==========");
			System.out.println("===3. 기간조회(대여시작일 기준)==========");
			System.out.println("---x. 전 단계-----------");
			System.out.println("======================");

			String sel = inputMsg();

			if (sel.equals("1")) {
				arUhb = hd.allData();
				sh.historyView(arUhb);
			} else if (sel.equals("2")) {
				String phoneNo = phoneNoInput();
		
				arUhb = hd.historyPhoneNo(phoneNo);

				if (arUhb.isEmpty()) {
					System.out.println("해당 사용자의 이용내역이 없습니다");
				} else {
					sh.historyView(arUhb);
				}

			} else if (sel.equals("3")) {
				String dateInput = dateInputInput();
			
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

		System.out.println("기간을 입력하세요 ex) 010102-010103 대여시작일 기준임");
		String dateInput = inputMsg();

		return dateInput;

	}

}
