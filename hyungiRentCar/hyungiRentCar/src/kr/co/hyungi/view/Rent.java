package kr.co.hyungi.view;


import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.CarData;
import kr.co.hyungi.domain.UserData;

public class Rent {

	public void phone_add() { 
		System.out.println("핸드폰번호를 입력해주세요.");
		String phoneno = null;
		phoneno = new CommonMethod().inputMsg();
		int i_phoneno = Integer.parseInt(phoneno);
		UsageHistoryBean ub = null;
		ub = (UsageHistoryBean) new UserData().getphone(i_phoneno);
		new SearchUser().phone_view(ub);
	}

	public void user_add() {
				System.out.println("운전면허 번호를 입력하세요.");
		String licenseno = new CommonMethod().inputMsg();
		
		UserData ud = new UserData();

	int cnt = ud.ins_licenseno(Integer.parseInt(licenseno));
	System.out.println("입력되었습니다.");	
	
	
	}

	public void rent_time() {
	
		System.out.println("대여 시간을 입력하세요. ex)09-01-03 09월01일03시");
		String startdata = new CommonMethod().inputMsg();
		System.out.println("반납 시간을 입력하세요. ex)09-02-03 09월02일03시");
		String enddata = new CommonMethod().inputMsg();
		UserData ud = new UserData();
		int cnt = ud.ins_data(startdata,enddata);
		System.out.println("입력완료");
		car_choice();
	}
	public void car_choice() {
		System.out.println("원하시는 차량을 선택하세요.");
		SearchCar shc = new SearchCar();
		shc.all_View(new CarData().def_data());
		    
	}
	
	public void rent_cancle() {
		System.out.println("핸드폰번호를 입력해주세요.");
		String phoneno = null;
		phoneno = new CommonMethod().inputMsg();
		int i_phoneno = Integer.parseInt(phoneno);
		UsageHistoryBean uh = null;
		uh = (UsageHistoryBean) new UserData().getphone(i_phoneno);
		new SearchHistory().mem_view(uh);
	
	}
	

//	public void test_all() { // 전체 rent_member 조회
//		SearchHistory shr = new SearchHistory();
//		shr.all_view(new UserData().def_data());
//	}
}
