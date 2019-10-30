package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.domain.CarData;

public class AdminCar extends CommonMethod {
	CarBean cb = null;
	ArrayList<CarBean> arCb = null;
	SearchCar sc = new SearchCar();
	CarData cd = new CarData();

	public void car() {

		boolean adBool = true;
		while (adBool) {

			System.out.println();
			System.out.println("   [ 1 ] ���� ��ȸ");
			System.out.println("   [ 2 ] ���� �߰�");
			System.out.println("   [ 3 ] ���� ����");
			System.out.println("   [ 4 ] ���� ����");
			System.out.println("   [ x ] �� �ܰ�");
			System.out.println();

			String sel = inputMsg();

			if (sel.equals("1")) {
				viewCar();
			} else if (sel.equals("2")) {
				insCar();
			} else if (sel.equals("3")) {
				modCar();
			} else if (sel.equals("4")) {
				delCar();
			} else if (sel.equals("x")) {
				System.out.println("�� �ܰ�� �̵��մϴ�");
				adBool = false;
			}
		}
		System.out.println();
	}

	private void viewCar() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		arCb = cd.allData();
		sc.allView(arCb);
	}

	private void delCar() {
		// ��������
		while (true) {
			arCb = cd.allData();
			sc.allView(arCb);

			String carRowNum = dCarRowNumInput();
			if (carRowNum.equals("x"))
				break;
			// carRowNum�� ������������ üũ�ؾ���
			String carNo = cd.getDelCarNo(carRowNum);
			System.out.println(carNo);
			if(carNo==null) {
				System.out.println("*****�߸��� ��ȣ�Դϴ�");
				pause(1.5);
				break;
			}
			if (carNo.equals("x"))
				break;
			
			if (carNo != null) {
				while (true) {
					String delMsg = delMsg();
					if (delMsg.equals("y")) {
						cd.deleteCar(carNo);
						System.out.println("*****������ �Ϸ�Ǿ����ϴ�");
						pause(1.5);
						break;
					} else if (delMsg.equals("n")) {
						System.out.println("*****������ ��ҵǾ����ϴ�");
						pause(1.5);
						break;
					} else {
						System.out.println("�߸��� �Է��Դϴ�");
					}
				}
			}
			break;
		}
	}

	private String delMsg() {
		System.out.println("������������������������������������������������������������������");
		System.out.println("��   ���� ���� �Ͻðڽ��ϱ�? ( y / n ) ");
		System.out.println("������������������������������������������������������������������");

		String delete = inputMsg();
		return delete;
	}

	private void modCar() {
		while (true) {
			// ��� ����� �����ͼ� �����ֱ�
			arCb = cd.allData();
			sc.allView(arCb);

			String carRowNum = mCarRowNumInput();
			if (carRowNum.equals("x"))
				break;
			// carRowNum�������� Ȯ��
			String carNo = cd.getCarNo(carRowNum);
			if (carNo != null) {

				String mCarModel = mCarModelInput();
				if (mCarModel.equals("x"))
					break;
				String mCarColor = mCarColorInput();
				if (mCarColor.equals("x"))
					break;
				String mCostPerHour = mCarCostInput();
				if (mCostPerHour.equals("x"))
					break;
				// costPerHour ������������ Ȯ��

				// enteró��
				cb = cd.getOneCar(carNo);
				if (mCarModel.equals(""))
					mCarModel = cb.getCarModel();
				if (mCarColor.equals(""))
					mCarColor = cb.getCarColor();
				if (mCostPerHour.equals(""))
					mCostPerHour = Integer.toString(cb.getCostPerHour());

				cd.modifyCar(carNo, mCarModel, mCarColor, mCostPerHour);

			} else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� ���ּ���");
			}
		}
	}

	private String mCarCostInput() {
		System.out.println("******������ �ð��簡���� �Է����ּ��� �ȹٲ�� enter*****************************************");
		String carCost = carCostInput();
		return carCost;
	}

	private String mCarColorInput() {
		System.out.println("******������ ������ �Է����ּ��� �ȹٲ�� enter*****************************************");
		String carColor = carColorInput();
		return carColor;
	}

	private String mCarModelInput() {
		System.out.println("******������ �𵨸��� �Է����ּ��� �ȹٲ�� enter*****************************************");
		String carModel = modCarModelInput();
		return carModel;
	}

	private String dCarRowNumInput() {
		System.out.println("******������ ������ ��ȣ�Է����ּ���*****************************************");
		String carRowNum = carRowNumInput();
		return carRowNum;
	}

	private String mCarRowNumInput() {
		System.out.println("******������ ������ ��ȣ�� �Է����ּ���*****************************************");
		String carRowNum = carRowNumInput();
		return carRowNum;
	}


	public void insCar() {
		boolean insCarBool=true;
		while (insCarBool) {
			System.out.println("���� ������ �Է� �޴� �Դϴ�");
			System.out.println("===================");
			System.out.println("���� ��ȣ�� �ڵ�����");

			String carModel = carModelInput();
			if (carModel.equals("x"))
				break;
			String carColor = carColorInput();
			if (carColor.equals("x"))
				break;
			String costPerHour = carCostInput();
			if (costPerHour.equals("x"))
				break;
			// costPerHour�� �������� Ȯ���ؾ���

			cd.insertCar(carModel, carColor, costPerHour);

			// ��� �������� Ȯ��
			while(true) {
			String yesOrNo = returnYesOrNoInput();
			if (yesOrNo.equals("y")) {
				break;
			} else if (yesOrNo.equals("n")) {
				insCarBool=false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�");
			}
			}
		}
	}

	private String returnYesOrNoInput() {
		System.out.println("������������������������������������������������������������������");
		System.out.println("��   ��� �Է� �Ͻðڽ��ϱ�? ( y / n ) ");
		System.out.println("������������������������������������������������������������������");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

}
