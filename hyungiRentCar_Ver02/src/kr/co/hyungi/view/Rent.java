package kr.co.hyungi.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.CarData;
import kr.co.hyungi.domain.HistoryData;
import kr.co.hyungi.domain.MemberData;

public class Rent extends CommonMethod {

	MemberData md = new MemberData();
	CarData cd = new CarData();
	HistoryData hd = new HistoryData();
	SearchCar sc = new SearchCar();
	SearchHistory sh = new SearchHistory();
	MemberBean mb = null;
	CarBean cb = null;
	ArrayList<CarBean> arCb = null;
	UsageHistoryBean uhb = null;
	ArrayList<UsageHistoryBean> arUhb = null;

	public void rent() { // 대여

		String phoneNo = phoneNoInput();// 폰번호 입력받기
		boolean isMember = md.isMember(phoneNo);// 회원인지 확인하기

		String licenseNo = null;
		String dateInput = null;
		if (isMember) {
			// 회원이면 날짜입력만
			licenseNo = md.getLicenseNo(phoneNo);
		} else {
			// 비회원이면 면허번호, 날짜입력 둘다
			licenseNo = licenseNoInput();
		}
		dateInput = dateInputInput();

		// 차 목록 보여주기
		arCb = cd.getAvailableCar(dateInput);
		sc.carView(arCb, dateInput);

		// 차고르기
		String carRowNum = carRowNumInput();
		String carNo = cd.getCarNo(carRowNum, dateInput);
		cb = cd.getOneCar(carNo);

		while (true) {
			sh.paymentView(dateInput, cb);
			String yesOrNo = yesOrNoInput(); // 결제하시겠습니까 y/n?

			if (yesOrNo.equals("y")) {
				// 값저장
				hd.payment(dateInput, cb, phoneNo, licenseNo);
				System.out.println("결제되셨습니다.");
				break;
			} else if (yesOrNo.equals("n")) {
				System.out.println("결제를 취소하셨습니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	public long costCal(String inputDate) {

		String strDate = inputDate.split("-")[0];
		String endDate = inputDate.split("-")[1];
		long calHour = 0;
		SimpleDateFormat format = new SimpleDateFormat("MMddHH");
		Date sd = null;
		Date ed = null;
		try {
			sd = format.parse(strDate);
			ed = format.parse(endDate);

			calHour = (ed.getTime() - sd.getTime()) / 1000 / 60 / 60;

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return calHour;
	}

	public void rentReturn() {

		String phoneNo = phoneNoInput();

		arUhb = null;

		arUhb = hd.getHistoryReturn(phoneNo);
		sh.historyView(arUhb);

		String historyRowNum = rHistoryRowNumInput(); // 예약번호 입력
		String rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
		uhb = hd.getOneHistory(rentNo);

		while (true) {
			sh.historyView(uhb);
			String yesOrNo = returnYesOrNoInput(); // 반납하시겠습니까 y/n?

			if (yesOrNo.equals("y")) {
				// 값저장
				hd.returnHistory(rentNo);
				System.out.println("반납되었습니다.");
				break;
			} else if (yesOrNo.equals("n")) {
				System.out.println("반납을 취소하셨습니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	private String rHistoryRowNumInput() {
		System.out.print("반납하고자 하는 ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

	public void rentCancel() {
		String phoneNo = cPhoneNoInput();
		arUhb = hd.getCurrentHistory(phoneNo);

		if (arUhb.isEmpty()) {
			System.out.println("예약내역이 없습니다.");
			System.out.println("다시 입력해주세요.");
		} else {
			sh.historyView(arUhb);
			// 예약번호 선택
			String historyRowNum = historyRowNumInput();
			String rentNo = hd.getRentNo(historyRowNum, phoneNo);
			uhb = hd.getOneHistory(rentNo);

			while (true) {
				sh.historyView(uhb);
				String yesOrNo = delYesOrNoInput(); // 삭제하시겠습니까 y/n?

				if (yesOrNo.equals("y")) {
					hd.delHistory(rentNo);
					System.out.println("대여취소되었습니다.");
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("대여취소를 취소하셨습니다.");
					break;
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
			}
		}
	}

	private String cPhoneNoInput() {
		System.out.println("취소하고자 하는");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private String delYesOrNoInput() {
		System.out.println("******************삭제(y/n)**********************************");
		System.out.println("************************************************************");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	private String returnYesOrNoInput() {
		System.out.println("******************반납(y/n)**********************************");
		System.out.println("************************************************************");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	public void rentModify() {

		// 폰번호입력
		String phoneNo = phoneNoInput();

		// 번호에 맞는 예약목록 가져오기
		arUhb = hd.getHistoryReturn(phoneNo);
		// 예약목록보여주기
		sh.historyView(arUhb);

		// 수정 예약번호 입력받고 해당 목록 갖기
		String historyRowNum = mHistoryRowNumInput(); // 예약번호 입력
		String rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
		uhb = hd.getOneHistory(rentNo);

		// 날짜 입력
		String dateInput = dateInputInput();
		if (dateInput.equals("")) {
			dateInput = uhb.getRentStartDate() + "-" + uhb.getRentEndDate();
		}

		// 수정할 예약의 차 번호 가져오기
		String carNo = Integer.toString(uhb.getCarNo());

		// 차량 보여주기
		arCb = cd.getAvailableCar(rentNo,dateInput);
		sc.carView(arCb, dateInput);

		// 수정 차량 입력
		String carRowNum = carRowNumInput();
		
		if (!carRowNum.equals("")) {
			carNo = cd.getCarNo(carRowNum, dateInput);
			cb = cd.getOneCar(carNo);
		} else {
			cb = cd.getOneCar(carNo);
		}
		//차 입력까지 받았고 기존차인지 새로 선택한건지도 정해졌네
		
		//해야될건 기존차일 경우 가능한지만 비교해줘야함.
		//carNo를 못쓰면 enterOk true
		if(cd.enterOk(carNo, dateInput)) {
			System.out.println("변경할 날짜에는 해당 차를 이용할 수 없습니다");
		}
		else {
			hd.delHistory(rentNo);
			hd.payment(dateInput, cb, phoneNo, uhb.getLicenseNo());
		}
	}

	private String mHistoryRowNumInput() {
		System.out.print("수정하고자 하는 ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

}
