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
			System.out.println("   [ 1 ] 차량 조회");
			System.out.println("   [ 2 ] 차량 추가");
			System.out.println("   [ 3 ] 차량 수정");
			System.out.println("   [ 4 ] 차량 삭제");
			System.out.println("   [ x ] 전 단계");
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
				System.out.println("전 단계로 이동합니다");
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
		// 차량삭제
		while (true) {
			arCb = cd.allData();
			sc.allView(arCb);

			String carRowNum = dCarRowNumInput();
			if (carRowNum.equals("x"))
				break;
			// carRowNum이 숫자형식인지 체크해야함
			String carNo = cd.getDelCarNo(carRowNum);
			System.out.println(carNo);
			if(carNo==null) {
				System.out.println("*****잘못된 번호입니다");
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
						System.out.println("*****삭제가 완료되었습니다");
						pause(1.5);
						break;
					} else if (delMsg.equals("n")) {
						System.out.println("*****삭제가 취소되었습니다");
						pause(1.5);
						break;
					} else {
						System.out.println("잘못된 입력입니다");
					}
				}
			}
			break;
		}
	}

	private String delMsg() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   정말 삭제 하시겠습니까? ( y / n ) ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		String delete = inputMsg();
		return delete;
	}

	private void modCar() {
		while (true) {
			// 모든 차목록 가져와서 보여주기
			arCb = cd.allData();
			sc.allView(arCb);

			String carRowNum = mCarRowNumInput();
			if (carRowNum.equals("x"))
				break;
			// carRowNum숫자인지 확인
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
				// costPerHour 숫자형식인지 확인

				// enter처리
				cb = cd.getOneCar(carNo);
				if (mCarModel.equals(""))
					mCarModel = cb.getCarModel();
				if (mCarColor.equals(""))
					mCarColor = cb.getCarColor();
				if (mCostPerHour.equals(""))
					mCostPerHour = Integer.toString(cb.getCostPerHour());

				cd.modifyCar(carNo, mCarModel, mCarColor, mCostPerHour);

			} else {
				System.out.println("잘못된 입력입니다. 다시 해주세요");
			}
		}
	}

	private String mCarCostInput() {
		System.out.println("******변경할 시간당가격을 입력해주세요 안바뀌면 enter*****************************************");
		String carCost = carCostInput();
		return carCost;
	}

	private String mCarColorInput() {
		System.out.println("******변경할 차색깔를 입력해주세요 안바뀌면 enter*****************************************");
		String carColor = carColorInput();
		return carColor;
	}

	private String mCarModelInput() {
		System.out.println("******변경할 모델명을 입력해주세요 안바뀌면 enter*****************************************");
		String carModel = modCarModelInput();
		return carModel;
	}

	private String dCarRowNumInput() {
		System.out.println("******삭제할 차량의 번호입력해주세요*****************************************");
		String carRowNum = carRowNumInput();
		return carRowNum;
	}

	private String mCarRowNumInput() {
		System.out.println("******수정할 차량의 번호를 입력해주세요*****************************************");
		String carRowNum = carRowNumInput();
		return carRowNum;
	}


	public void insCar() {
		boolean insCarBool=true;
		while (insCarBool) {
			System.out.println("차량 데이터 입력 메뉴 입니다");
			System.out.println("===================");
			System.out.println("차량 번호는 자동생성");

			String carModel = carModelInput();
			if (carModel.equals("x"))
				break;
			String carColor = carColorInput();
			if (carColor.equals("x"))
				break;
			String costPerHour = carCostInput();
			if (costPerHour.equals("x"))
				break;
			// costPerHour는 숫자인지 확인해야함

			cd.insertCar(carModel, carColor, costPerHour);

			// 계속 넣을건지 확인
			while(true) {
			String yesOrNo = returnYesOrNoInput();
			if (yesOrNo.equals("y")) {
				break;
			} else if (yesOrNo.equals("n")) {
				insCarBool=false;
				break;
			} else {
				System.out.println("잘못된 입력입니다");
			}
			}
		}
	}

	private String returnYesOrNoInput() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   계속 입력 하시겠습니까? ( y / n ) ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

}
