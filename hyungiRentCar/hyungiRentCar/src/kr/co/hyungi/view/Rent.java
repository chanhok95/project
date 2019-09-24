package kr.co.hyungi.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.CarData;
import kr.co.hyungi.domain.HistoryData;
import kr.co.hyungi.domain.MemberData;
import kr.co.hyungi.domain.MemberData;

public class Rent extends CommonMethod {

	public void historyView(List<UsageHistoryBean> uh) { // 대여취소

		System.out.println("조회된 대여정보는 아래와 같습니다.");
		for (int i = 0; i < uh.size(); i++) {
			System.out.println("예약 No(번호):" + (i + 1));
			System.out.println("렌트번호:" + uh.get(i).getRentNo());
			System.out.println("차번호:" + uh.get(i).getCarNo());
			System.out.println("폰번호:" + uh.get(i).getPhoneNo());
			System.out.println("면허번호:" + uh.get(i).getLicenseNo());
			System.out.println("대여날짜:" + uh.get(i).getRentStartDate());
			System.out.println("반납날짜:" + uh.get(i).getRentEndDate());
			System.out.println("대여상태:" + uh.get(i).getState());
			System.out.println("**********************************");
			System.out.println("**********************************");
			System.out.println("**********************************");

		}
	}

	public String ins_license() {
		String inlicenseno = inputMsg();
		new MemberData().isMember(inlicenseno);
		return inlicenseno;
	}

	public String phoneEqual() { // 대여 핸드폰번호 비교
		System.out.println("--------대여-------");
		System.out.println("핸드폰번호를 입력해주세요.");
		String phoneNo = inputMsg();
		new MemberData().isMember(phoneNo);
		return phoneNo;

	}

	public String equal() { // 대여취소 폰번호입력비교
		System.out.println("핸드폰번호를 입력해주세요.");
		String phoneNo = inputMsg();
		return phoneNo;
	}

	public String licenseNoAdd() { // 면허번호
		System.out.println("운전면허 번호를 입력하세요.");
		String licenseno = inputMsg();

		return licenseno;

	}

	public String rentDate() { // 대여일자 반납일자

		System.out.println("대여,반납시간입력하세요 ex) 010102-010103 대여-반납");
		String inputDate = inputMsg();

		return inputDate;

	}

	public String carAdd() { // 차량선택
		System.out.println("-----------------------");
		System.out.println("원하시는 차량번호를 입력해주세요.");
		String carno = inputMsg();
		return carno;
	}

	public String payMent() { // 결제시 저장
		System.out.println("결제하시겠습니까.y:저장 n:취소");
		String cash = inputMsg();
		return cash;
	}

	public void rent() { // 대여 main?

		String phoneNo = phoneEqual();// 폰번호 비교 값이있는지 확인
		boolean isMember = new MemberData().isMember(phoneNo);// 회원인지 확인하기
		String licenseNo = null;
		String inputDate;
		if (isMember) {
			inputDate = rentDate();
		} else {
			licenseNo = licenseNoAdd();
			inputDate = rentDate();
		}
		List<CarBean> cb = new CarData().def_data();
		new SearchCar().carView(cb);
		String carno = carAdd();

		String select = payMent();
		if (select.equals("y")) {
			System.out.println("결제되셨습니다.");
			rent();
			// 값저장
			new HistoryData().ins(carno, phoneNo, licenseNo, inputDate);
		} else if (select.equals("n")) {
			rent();
		}
	}

	public void rentCancel() { // 대여취소 main?
		String phoneNo = equal();
		List<UsageHistoryBean> uh = new HistoryData().def_data(phoneNo);
		if (uh.isEmpty()) {
			System.out.println("예약내역이 없습니다.");
			System.out.println("다시 입력해주세요.");
			rentCancel();
		} else {
			historyView(uh);
			System.out.println("예약no(번호)를 입력해주세요.");
			String rentNo = inputMsg();
			System.out.println("삭제하시겠습니까? ex) y,n");
			String select = inputMsg();

			if (select.equals("y")) {

				new HistoryData().delHistory(uh.get(Integer.parseInt(rentNo) - 1).getRentNo());
			} else if (select.equals("n")) {
				rent();
			}
		}
	}

	public void searchView() { // 회원조회
		List<MemberBean> mb = new MemberData().def_data();
		new SearchMember().memView(mb);

	}

	public void usedState() {// 현재 (예약중,사용중) 확인
		List<UsageHistoryBean> uh = new HistoryData().state();
		historyView(uh);
	}

	public long dateCal(long calDateDays) { // startdate - enddate 비교
		{
			System.out.println("대여일");
			String strDate = inputMsg();
			System.out.println("반납일");
			String EndDate = inputMsg();

			try { // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서
					// 컴파일을 할 수 없다.
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				// date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
				Date FirstDate = format.parse(strDate);
				Date SecondDate = format.parse(EndDate);

				// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
				// 연산결과 -950400000. long type 으로 return 된다.
				long calDate = FirstDate.getTime() - SecondDate.getTime();

				// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
				// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
				 calDateDays = calDate / (24 * 60 * 60 * 1000);

				calDateDays = Math.abs(calDateDays);

				System.out.println("두 날짜의 날짜 차이: " + calDateDays);
			} catch (ParseException e) {
			
			}
		}
		return calDateDays;
	}

}
