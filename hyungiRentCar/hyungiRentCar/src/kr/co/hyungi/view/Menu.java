package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.MemberBean;

public class Menu extends CommonMethod{
	public void menu() {
		
		boolean menuBool = true;
		while(menuBool) {
			System.out.println("***************************************************************");
			System.out.println("*****1.�뿩*****2.�뿩����*****3.�뿩���*****4.�ݳ�*****5.������*****");
			System.out.println("***************************************************************");
			
			String input = inputMsg();
			
			if(input.equals("1")) {
				//rent();
				Rent re = new Rent();
				re.phone_add(); break;
			}
			else if(input.equals("2")) {
				//modifyRent();
				Rent re = new Rent();
				re.car_choice(); break;
			}
			else if(input.equals("3")) {
				//cancelRent();
				Rent re = new Rent();
				re.rent_cancle(); break;
			}
			else if(input.equals("4")) {
				//return();
			}
			else if(input.equals("5")) {
				//adminMenu();
			}
			else if(input.equals("x")) {
				//systemOut();
			}
			
		}
	}
}
