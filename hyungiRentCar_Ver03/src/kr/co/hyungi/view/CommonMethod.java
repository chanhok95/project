package kr.co.hyungi.view;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		System.out.println("기간을 입력하세요 ex) 010102-010103 대여시작일 기준임");
		System.out.println("\tx : 메인메뉴");
		String dateInput = inputMsg();
		while (!dateFormatCheck(dateInput)) {
			System.out.println("잘못된 형식입니다");
			dateInput = inputMsg();
		}
		return dateInput;
	}
	

	public String carNoInput() {
		System.out.println("차량 번호 입력");
		System.out.println("\tx : 메인메뉴");
		String carNo = inputMsg();
		while (!carNoFormatCheck(carNo)) {
			System.out.println("잘못된 형식입니다");
			carNo = inputMsg();
		}
		return carNo;
	}

	public String carColorInput() {
		System.out.println("차량 색상 입력(10 Byte)");
		System.out.println("\tx : 메인메뉴");
		String carColor = inputMsg();
		while (!carColorFormatCheck(carColor)) {
			System.out.println("잘못된 형식입니다");
			carColor = inputMsg();
		}
		return carColor;
	}

	public String carModelInput() {
		System.out.println("차량 모델 입력(20 Byte)");
		System.out.println("\tx : 메인메뉴");
		String carModel = inputMsg();
		while (!carModelFormatCheck(carModel)) {
			System.out.println("잘못된 형식입니다");
			carModel = inputMsg();
		}
		return carModel;
	}
	
	
	public String carCostInput() {
		System.out.println("차량 시간당 가격 입력(10)");
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

	
	
	
	public String licenseNoInput() {
		System.out.println("면허번호 입력(10 Byte)");
		System.out.println("\tx : 메인메뉴");
		String licenseNo = inputMsg();
		while (!licenseNoFormatCheck(licenseNo)) {
			System.out.println("잘못된 형식입니다");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}

	public String memNameInput() {
		System.out.println("이름 입력(10 Byte)");
		System.out.println("\tx : 메인메뉴");
		String memName = inputMsg();
		while (!memNameFormatCheck(memName)) {
			System.out.println("잘못된 형식입니다");
			memName = inputMsg();
		}
		return memName;
	}

	public String phoneNoInput() {
		System.out.println("핸드폰번호 입력(13 Byte)");
		System.out.println("\tx : 메인메뉴");
		String phoneNo = inputMsg();
		while (!phoneNoFormatCheck(phoneNo)) {
			System.out.println("잘못된 형식입니다");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}
	
	

	public String yesOrNoInput() { // 결제시 저장
		System.out.println("******************결제(y/n)**********************************");
		System.out.println("************************************************************");
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
		return Pattern.matches(regex, phoneNo);   			//  010으로 시작해야되고 {} 8칸의 범위여야 한다.
															// \\d : \를 2개 붙이는 이유는 "\\d" 문자 안에서 \ 다음 \문자가 특수문자라고 알려주는 것과 같습니다. 이 형식을 사용하면 숫자만 true를 반환합니다.


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
		return Pattern.matches(regex, date);
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
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
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
