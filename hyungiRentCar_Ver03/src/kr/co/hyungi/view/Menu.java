package kr.co.hyungi.view;

public class Menu extends CommonMethod {
	Rent r = new Rent();
	Admin a = new Admin();
	public void menu() {

		
		
		boolean menuBool = true;
		while (menuBool) {

			System.out.println("************************************************************");
			System.out.println("*****1.�뿩*****2.�뿩����*****3.�뿩���*****4.�ݳ�*****5.������*****");
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
				System.out.println("�ý����� �����մϴ�");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�");
			}

		}
	}
}
