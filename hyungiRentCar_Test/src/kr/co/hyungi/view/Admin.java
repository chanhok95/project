package kr.co.hyungi.view;

public class Admin extends CommonMethod {
	public void adminMenu() {

		boolean adBool = true;
		while (adBool) {

			System.out.println();
			System.out.println("======================");
			System.out.println("===1. ȸ������==========");
			System.out.println("===2. ��������==========");
			System.out.println("===3. �̿볻��==========");
			System.out.println("---x. �� �ܰ�-----------");
			System.out.println("======================");

			String selAd = inputMsg();

			if (selAd.equals("1")) {
				 new AdminMember().member();
			} else if (selAd.equals("2")) {
				 new AdminCar().car();
			} else if (selAd.equals("3")) {
				 new AdminHistory().history();
			} else if (selAd.equals("x")) {
				System.out.println("�� �ܰ�� �̵��մϴ�");
				adBool = false;
			}

		}
		System.out.println();
	}

}
