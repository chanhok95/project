package kr.co.hyungi.view;

public class Menu extends CommonMethod {
	Rent r = new Rent();
	Admin a = new Admin();
	public void menu() {

		
		
		boolean menuBool = true;
		while (menuBool) {
			System.out.println("							�����������������������������");
			System.out.println("                  				        ��                          ��  ");
			System.out.println("                  					��	         ��Ʈī                         ��  ");
			System.out.println("                  					��	     �뿩 ���α׷�                   ��  ");
			System.out.println("                  	              �������������������      		            �������������������  ");
			System.out.println("                                      ��		  1. �뿩      2. �뿩����     3.�뿩�ݳ�    4.�뿩���  5. ������                  ��  ");
			System.out.println("                                      ��		                  System out                         ��  ");
			System.out.println("                                      ��		                                                     ��  ");
			System.out.println("                                      ��		                                                     ��  ");			
			System.out.println("                                      ����������������������������������������������������������������� ");
			System.out.println("                                                  ��         ��                        ��        ��                    ");
			System.out.println("                                                 ��           ��                      ��          ��                    ");
			System.out.println("                                                 ��           ��                      ��          ��                    ");
			System.out.println("                                                  �ܡۡۡۡۡۡۡۡۡۡ�                        �ܡۡۡۡۡۡۡۡۡ�                     ");
			
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
