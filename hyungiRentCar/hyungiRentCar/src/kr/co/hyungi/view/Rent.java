package kr.co.hyungi.view;


import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.CarData;
import kr.co.hyungi.domain.UserData;

public class Rent {

	public void phone_add() { 
		System.out.println("�ڵ�����ȣ�� �Է����ּ���.");
		String phoneno = null;
		phoneno = new CommonMethod().inputMsg();
		int i_phoneno = Integer.parseInt(phoneno);
		UsageHistoryBean ub = null;
		ub = (UsageHistoryBean) new UserData().getphone(i_phoneno);
		new SearchUser().phone_view(ub);
	}

	public void user_add() {
				System.out.println("�������� ��ȣ�� �Է��ϼ���.");
		String licenseno = new CommonMethod().inputMsg();
		
		UserData ud = new UserData();

	int cnt = ud.ins_licenseno(Integer.parseInt(licenseno));
	System.out.println("�ԷµǾ����ϴ�.");	
	
	
	}

	public void rent_time() {
	
		System.out.println("�뿩 �ð��� �Է��ϼ���. ex)09-01-03 09��01��03��");
		String startdata = new CommonMethod().inputMsg();
		System.out.println("�ݳ� �ð��� �Է��ϼ���. ex)09-02-03 09��02��03��");
		String enddata = new CommonMethod().inputMsg();
		UserData ud = new UserData();
		int cnt = ud.ins_data(startdata,enddata);
		System.out.println("�Է¿Ϸ�");
		car_choice();
	}
	public void car_choice() {
		System.out.println("���Ͻô� ������ �����ϼ���.");
		SearchCar shc = new SearchCar();
		shc.all_View(new CarData().def_data());
		    
	}
	
	public void rent_cancle() {
		System.out.println("�ڵ�����ȣ�� �Է����ּ���.");
		String phoneno = null;
		phoneno = new CommonMethod().inputMsg();
		int i_phoneno = Integer.parseInt(phoneno);
		UsageHistoryBean uh = null;
		uh = (UsageHistoryBean) new UserData().getphone(i_phoneno);
		new SearchHistory().mem_view(uh);
	
	}
	

//	public void test_all() { // ��ü rent_member ��ȸ
//		SearchHistory shr = new SearchHistory();
//		shr.all_view(new UserData().def_data());
//	}
}
