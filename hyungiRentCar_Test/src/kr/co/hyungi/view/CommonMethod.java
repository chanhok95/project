package kr.co.hyungi.view;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class CommonMethod {

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
		System.out.println("����no(��ȣ)�� �Է����ּ���.");
		System.out.println("\tx : ���θ޴�");
		String historyRowNum = inputMsg();
		while (!rowNumFormatCheck(historyRowNum)) {
			System.out.println("�߸��� �����Դϴ�");
			historyRowNum = inputMsg();
		}
		return historyRowNum;
	}

	public String dateInputInput() {
		System.out.println("�Ⱓ�� �Է��ϼ��� ex) 010102-010103 �뿩������ ������");
		System.out.println("\tx : ���θ޴�");
		String dateInput = inputMsg();
		while (!dateFormatCheck(dateInput)) {
			System.out.println("�߸��� �����Դϴ�");
			dateInput = inputMsg();
		}
		return dateInput;
	}
	

	public String carNoInput() {
		System.out.println("���� ��ȣ �Է�");
		System.out.println("\tx : ���θ޴�");
		String carNo = inputMsg();
		while (!carNoFormatCheck(carNo)) {
			System.out.println("�߸��� �����Դϴ�");
			carNo = inputMsg();
		}
		return carNo;
	}

	public String carColorInput() {
		System.out.println("���� ���� �Է�(10 Byte)");
		System.out.println("\tx : ���θ޴�");
		String carColor = inputMsg();
		while (!carColorFormatCheck(carColor)) {
			System.out.println("�߸��� �����Դϴ�");
			carColor = inputMsg();
		}
		return carColor;
	}

	public String carModelInput() {
		System.out.println("���� �� �Է�(20 Byte)");
		System.out.println("\tx : ���θ޴�");
		String carModel = inputMsg();
		while (!carModelFormatCheck(carModel)) {
			System.out.println("�߸��� �����Դϴ�");
			carModel = inputMsg();
		}
		return carModel;
	}
	
	
	public String carCostInput() {
		System.out.println("���� �ð��� ���� �Է�(10)");
		System.out.println("\tx : ���θ޴�");
		String carCost = inputMsg();
		while (!carCostFormatCheck(carCost)) {
			System.out.println("�߸��� �����Դϴ�");
			carCost = inputMsg();
		}
		return carCost;
	}

	public String carRowNumInput() { 
		System.out.println("-----------------------");
		System.out.println("���Ͻô� ����No�� �Է����ּ���.");
		System.out.println("\tx : ���θ޴�");
		String carno = inputMsg();
		while (!rowNumFormatCheck(carno)) {
			System.out.println("�߸��� �����Դϴ�");
			carno = inputMsg();
		}
		return carno;
	}

	
	
	
	public String licenseNoInput() {
		System.out.println("�����ȣ �Է�(10 Byte)");
		System.out.println("\tx : ���θ޴�");
		String licenseNo = inputMsg();
		while (!licenseNoFormatCheck(licenseNo)) {
			System.out.println("�߸��� �����Դϴ�");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}

	public String memNameInput() {
		System.out.println("�̸� �Է�(10 Byte)");
		System.out.println("\tx : ���θ޴�");
		String memName = inputMsg();
		while (!memNameFormatCheck(memName)) {
			System.out.println("�߸��� �����Դϴ�");
			memName = inputMsg();
		}
		return memName;
	}

	public String phoneNoInput() {
		System.out.println("�ڵ�����ȣ �Է�(13 Byte)");
		System.out.println("\tx : ���θ޴�");
		String phoneNo = inputMsg();
		while (!phoneNoFormatCheck(phoneNo)) {
			System.out.println("�߸��� �����Դϴ�");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}
	
	

	public String yesOrNoInput() {
		System.out.println("******************����(y/n)**********************************");
		System.out.println("************************************************************");
		String yesOrNo = inputMsg();
		while (!yesOrNoFormatCheck(yesOrNo)) {
			System.out.println("�߸��� �����Դϴ�");
			yesOrNo = inputMsg();
		}
		return yesOrNo;
	}
	


	public boolean phoneNoFormatCheck(String phoneNo) {
		String regex ="[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	

	public boolean licenseNoFormatCheck(String licenseNo) {
		String regex ="[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	

	public boolean memNameFormatCheck(String memName) {
		String regex ="[��-�R]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	

	public boolean dateFormatCheck(String date) {
		String regex ="[x]|(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])-(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])";
		return Pattern.matches(regex, date);
	}
	

	public boolean carNoFormatCheck(String carNo) {
		String regex ="[x]|\\d{1,2}";
		return Pattern.matches(regex, carNo);
	}
	

	public boolean carModelFormatCheck(String carModel) {
		String regex ="[��-�R ]{1,6}|[a-zA-Z0-9 ]{1,20}";
		return Pattern.matches(regex, carModel);
	}
	

	public boolean carColorFormatCheck(String carColor) {
		String regex ="[a-zA-Z]{1,10}";
		return Pattern.matches(regex, carColor);
	}
	

	public boolean carCostFormatCheck(String carCost) {
		String regex ="[x]|\\d{1,10}";
		return Pattern.matches(regex, carCost);
	}
	

	public boolean rowNumFormatCheck(String rowNum) {
		String regex ="[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	

	public boolean yesOrNoFormatCheck(String yesNo) {
		String regex ="[ynYN]";
		return Pattern.matches(regex, yesNo);
	}
	
	
	
	public void pause(double time) {
		try {
			Thread.sleep((long)time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public Connection dbCon() {
		String url = "jdbc:oracle:thin:@192.168.14.49:1521:XE";
		String user = "scott";
		String password = "tiger";
		Connection conn= null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return conn;
	}
	
}
