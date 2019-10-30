package kr.co.hyungi.view;

public class Admin extends CommonMethod {
	public void adminMenu() {

		boolean adBool = true;
		while (adBool) {

			System.out.println();
			System.out.println("======================");
			System.out.println("===1. 회원정보==========");
			System.out.println("===2. 차량정보==========");
			System.out.println("===3. 이용내역==========");
			System.out.println("---x. 전 단계-----------");
			System.out.println("======================");

			String selAd = inputMsg();

			if (selAd.equals("1")) {
				 new AdminMember().member();
			} else if (selAd.equals("2")) {
				 new AdminCar().car();
			} else if (selAd.equals("3")) {
				 new AdminHistory().history();
			} else if (selAd.equals("x")) {
				System.out.println("전 단계로 이동합니다");
				adBool = false;
			}

		}
		System.out.println();
	}

}
