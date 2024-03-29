package kr.co.hyungi.view;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class CommonMethod {
	//인풋메시지, 정규표현식 메소드, db연결을 사용하고 싶은 클래스에서 extends 하기
	
	// message입력받기
	public static String inputMsg() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	
	public String historyRowNumInput() {
		System.out.println("예약no(번호)를 입력해주세요.");
		System.out.println("\tx : 메인메뉴");
		String historyRowNum = inputMsg();
		while (!rowNumFormatCheck(historyRowNum)) {
			System.out.println("잘못된 형식입니다");
			historyRowNum = inputMsg();
		}
		return historyRowNum;
	}

	public String dateInputInput() {
		System.out.println("기간을 입력하세요 (대여 시작일 기준)");
		System.out.println("ex) 010102-010103 (월일시-월일시)");
		System.out.println("\tx : 메인메뉴");
		String dateInput = inputMsg();
		while (!dateFormatCheck(dateInput)) {
			System.out.println("잘못된 형식입니다");
			dateInput = inputMsg();
		}
		return dateInput;
	}
	
	public String enterDateInput() {
		System.out.println("기간을 입력하세요 (대여시작일 기준)");
		System.out.println("ex) 010102-010103 (월일시-월일시)");
		System.out.println("기존입력 enter");
		System.out.println("\tx : 메인메뉴");
		String dateInput = inputMsg();
		while (!enterDateFormatCheck(dateInput)) {
			System.out.println("잘못된 형식입니다");
			dateInput = inputMsg();
		}
		return dateInput;
	}

	// 날짜 형식확인
	public boolean enterDateFormatCheck(String date) {
		String regex ="^$|[x]|(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])-(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])";
		return Pattern.matches(regex, date);
	}

	public String carNoInput() {
		System.out.println("No. 입력");
		System.out.println("\tx : 메인메뉴");
		String carNo = inputMsg();
		while (!carNoFormatCheck(carNo)) {
			System.out.println("잘못된 형식입니다");
			carNo = inputMsg();
		}
		return carNo;
	}

	public String carColorInput() {
		System.out.println("차량 색상 입력");
		System.out.println("영문만 가능(10자)");
		System.out.println("\tx : 메인메뉴");
		String carColor = inputMsg();
		while (!carColorFormatCheck(carColor)) {
			System.out.println("잘못된 형식입니다");
			carColor = inputMsg();
		}
		return carColor;
	}

	public String carModelInput() {
		System.out.println("차량 모델 입력");
		System.out.println("한글(6자) / 영문(20자) [혼용불가]");
		System.out.println("\tx : 메인메뉴");
		String carModel = inputMsg();
		while (!carModelFormatCheck(carModel)) {
			System.out.println("잘못된 형식입니다");
			carModel = inputMsg();
		}
		return carModel;
	}
	
	
	public String carCostInput() {
		System.out.println("차량 시간당 가격 입력");
		System.out.println("숫자(100억 미만)");
		System.out.println("\tx : 메인메뉴");
		String carCost = inputMsg();
		while (!carCostFormatCheck(carCost)) {
			System.out.println("잘못된 형식입니다");
			carCost = inputMsg();
		}
		return carCost;
	}

	public String carRowNumInput() { // 차량선택
		System.out.println("-----------------------");
		System.out.println("원하시는 차량No를 입력해주세요.");
		System.out.println("\tx : 메인메뉴");
		String carno = inputMsg();
		while (!rowNumFormatCheck(carno)) {
			System.out.println("잘못된 형식입니다");
			carno = inputMsg();
		}
		return carno;
	}

	public String enterCarRowNumInput() { // 차량선택
		System.out.println("-----------------------");
		System.out.println("원하시는 차량No를 입력해주세요.");
		System.out.println("기존입력:enter");
		System.out.println("\tx : 메인메뉴");
		String carno = inputMsg();
		while (!enterRowNumFormatCheck(carno)) {
			System.out.println("잘못된 형식입니다");
			carno = inputMsg();
		}
		return carno;
	}
	
	// 열번호 형식확인
	public boolean enterRowNumFormatCheck(String rowNum) {
		String regex ="^$|[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	
	public String licenseNoInput() {
		System.out.println("면허번호 입력");
		System.out.println("(숫자 10자) 1xxxxxxxxx");
		System.out.println("\tx : 메인메뉴");
		String licenseNo = inputMsg();
		while (!licenseNoFormatCheck(licenseNo)) {
			System.out.println("잘못된 형식입니다");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}

	public String memNameInput() {
		System.out.println("이름 입력");
		System.out.println("한글(3자) / 영문(10자) [혼용불가]");
		System.out.println("\tx : 메인메뉴");
		String memName = inputMsg();
		while (!memNameFormatCheck(memName)) {
			System.out.println("잘못된 형식입니다");
			memName = inputMsg();
		}
		return memName;
	}
	
	public String modPhoneNoInput() {
		System.out.println("핸드폰번호 입력");
		System.out.println("(숫자 11자) 010xxxxxxxx");
		System.out.println("\tx : 메인메뉴");
		String phoneNo = inputMsg();
		while (!modPhoneNoFormatCheck(phoneNo)) {
			System.out.println("잘못된 형식입니다");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}

	

	// 핸드폰번호 형식확인
	public boolean modPhoneNoFormatCheck(String phoneNo) {
		String regex ="^$|[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	public String modMemNameInput() {
		System.out.println("이름 입력(10 Byte)");
		System.out.println("한글(3자) / 영문(10자) [혼용불가]");
		System.out.println("\tx : 메인메뉴");
		String memName = inputMsg();
		while (!modMemNameFormatCheck(memName)) {
			System.out.println("잘못된 형식입니다");
			memName = inputMsg();
		}
		return memName;
	}

	public String modLicenseNoInput() {
		System.out.println("면허번호 입력");
		System.out.println("(숫자 10자) 1xxxxxxxxx");

		System.out.println("\tx : 메인메뉴");
		String licenseNo = inputMsg();
		while (!modLicenseNoFormatCheck(licenseNo)) {
			System.out.println("잘못된 형식입니다");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}
	
	public boolean modLicenseNoFormatCheck(String licenseNo) {
		String regex ="^$|[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	
	
	public boolean modMemNameFormatCheck(String memName) {
		String regex ="^$|[가-힣]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	
	public String phoneNoInput() {
		System.out.println("핸드폰번호 입력");
		System.out.println("(숫자 11자) 010xxxxxxxx");
		System.out.println("\tx : 메인메뉴");
		String phoneNo = inputMsg();
		while (!phoneNoFormatCheck(phoneNo)) {
			System.out.println("잘못된 형식입니다");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}
	
	

	public String yesOrNoInput() { // 결제시 저장
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   결제 하시겠습니까? ( y / n ) ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String yesOrNo = inputMsg();
		while (!yesOrNoFormatCheck(yesOrNo)) {
			System.out.println("잘못된 형식입니다");
			yesOrNo = inputMsg();
		}
		return yesOrNo;
	}
	

	// 핸드폰번호 형식확인
	public boolean phoneNoFormatCheck(String phoneNo) {
		String regex ="[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	
	// 면허번호 형식확인
	public boolean licenseNoFormatCheck(String licenseNo) {
		String regex ="[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	
	// 회원이름 형식확인
	public boolean memNameFormatCheck(String memName) {
		String regex ="[가-힣]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	
	// 날짜 형식확인
	public boolean dateFormatCheck(String date) {
		String regex ="[x]|(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])-(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])";
		if(date.equals("x"))
			return true;
		if(Pattern.matches(regex, date)) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHH");
		Date sDate=null;
		Date eDate=null;
		try {
			sDate = sdf.parse(date.split("-")[0]);
			eDate=sdf.parse(date.split("-")[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(sDate.getTime()>eDate.getTime()) {
			System.out.println("반납날짜가 시작날짜보다 빠릅니다");
			return false;
		}if(sDate.getTime()==eDate.getTime()) {
			System.out.println("반납날짜랑 시작날짜가 같습니다");
			return false;
		}
		return true;
		}
		return false;
	}
	
	// 차량번호 형식확인
	public boolean carNoFormatCheck(String carNo) {
		String regex ="[x]|\\d{1,2}";
		return Pattern.matches(regex, carNo);
	}
	
	// 차량모델 형식확인
	public boolean carModelFormatCheck(String carModel) {
		String regex ="[가-힣 ]{1,6}|[a-zA-Z0-9 ]{1,20}";
		return Pattern.matches(regex, carModel);
	}
	
	// 차량색상 형식확인
	public boolean carColorFormatCheck(String carColor) {
		String regex ="[a-zA-Z]{1,10}";
		return Pattern.matches(regex, carColor);
	}
	
	// 차량가격 형식확인
	public boolean carCostFormatCheck(String carCost) {
		String regex ="[x]|\\d{1,10}";
		return Pattern.matches(regex, carCost);
	}
	
	// 열번호 형식확인
	public boolean rowNumFormatCheck(String rowNum) {
		String regex ="[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	
	// 가부 형식확인
	public boolean yesOrNoFormatCheck(String yesNo) {
		String regex ="[ynYN]";
		return Pattern.matches(regex, yesNo);
	}
	
	
	// time초만큼 멈추기
	public void pause(double time) {
		try {
			Thread.sleep((long)time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// DB연결
	public Connection dbCon() {
		String url = "jdbc:oracle:thin:@192.168.14.49:1521:XE";
		String user = "scott";
		String password = "tiger";
		Connection conn= null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
