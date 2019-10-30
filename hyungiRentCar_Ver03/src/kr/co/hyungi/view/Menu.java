package kr.co.hyungi.view;

public class Menu extends CommonMethod {
	Rent r = new Rent();
	Admin a = new Admin();
	public void menu() {

		
		
		boolean menuBool = true;
		while (menuBool) {

			System.out.println("************************************************************");
			System.out.println("*****1.대여*****2.대여수정*****3.대여취소*****4.반납*****5.관리자*****");
			System.out.println("************************************************************");

			String input = inputMsg();

			if (input.equals("1")) {
				r.rent();
			} else if (input.equals("2")) {
				r.rentModify();
			} else if (input.equals("3")) {
				 r.rentCancel();
			} else if (input.equals("4")) {
				 r.rentReturn();
			} else if (input.equals("5")) {
				a.adminMenu();
			} else if (input.equals("x")) {
				System.out.println("시스템을 종료합니다");
				break;
			} else {
				System.out.println("잘못된 입력입니다");
			}

		}
	}
}
