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
	//��ǲ�޽���, ����ǥ���� �޼ҵ�, db������ ����ϰ� ���� Ŭ�������� extends �ϱ�
	
	// message�Է¹ޱ�
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
		System.out.println("�Ⱓ�� �Է��ϼ��� (�뿩 ������ ����)");
		System.out.println("ex) 010102-010103 (���Ͻ�-���Ͻ�)");
		System.out.println("\tx : ���θ޴�");
		String dateInput = inputMsg();
		while (!dateFormatCheck(dateInput)) {
			System.out.println("�߸��� �����Դϴ�");
			dateInput = inputMsg();
		}
		return dateInput;
	}
	
	public String enterDateInput() {
		System.out.println("�Ⱓ�� �Է��ϼ��� (�뿩������ ����)");
		System.out.println("ex) 010102-010103 (���Ͻ�-���Ͻ�)");
		System.out.println("�����Է� enter");
		System.out.println("\tx : ���θ޴�");
		String dateInput = inputMsg();
		while (!enterDateFormatCheck(dateInput)) {
			System.out.println("�߸��� �����Դϴ�");
			dateInput = inputMsg();
		}
		return dateInput;
	}

	// ��¥ ����Ȯ��
	public boolean enterDateFormatCheck(String date) {
		String regex ="^$|[x]|(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])-(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])";
		return Pattern.matches(regex, date);
	}

	public String carNoInput() {
		System.out.println("No. �Է�");
		System.out.println("\tx : ���θ޴�");
		String carNo = inputMsg();
		while (!carNoFormatCheck(carNo)) {
			System.out.println("�߸��� �����Դϴ�");
			carNo = inputMsg();
		}
		return carNo;
	}

	public String carColorInput() {
		System.out.println("���� ���� �Է�");
		System.out.println("������ ����(10��)");
		System.out.println("\tx : ���θ޴�");
		String carColor = inputMsg();
		while (!carColorFormatCheck(carColor)) {
			System.out.println("�߸��� �����Դϴ�");
			carColor = inputMsg();
		}
		return carColor;
	}

	public String carModelInput() {
		System.out.println("���� �� �Է�");
		System.out.println("�ѱ�(6��) / ����(20��) [ȥ��Ұ�]");
		System.out.println("\tx : ���θ޴�");
		String carModel = inputMsg();
		while (!carModelFormatCheck(carModel)) {
			System.out.println("�߸��� �����Դϴ�");
			carModel = inputMsg();
		}
		return carModel;
	}
	
	
	public String carCostInput() {
		System.out.println("���� �ð��� ���� �Է�");
		System.out.println("����(100�� �̸�)");
		System.out.println("\tx : ���θ޴�");
		String carCost = inputMsg();
		while (!carCostFormatCheck(carCost)) {
			System.out.println("�߸��� �����Դϴ�");
			carCost = inputMsg();
		}
		return carCost;
	}

	public String carRowNumInput() { // ��������
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

	public String enterCarRowNumInput() { // ��������
		System.out.println("-----------------------");
		System.out.println("���Ͻô� ����No�� �Է����ּ���.");
		System.out.println("�����Է�:enter");
		System.out.println("\tx : ���θ޴�");
		String carno = inputMsg();
		while (!enterRowNumFormatCheck(carno)) {
			System.out.println("�߸��� �����Դϴ�");
			carno = inputMsg();
		}
		return carno;
	}
	
	// ����ȣ ����Ȯ��
	public boolean enterRowNumFormatCheck(String rowNum) {
		String regex ="^$|[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	
	public String licenseNoInput() {
		System.out.println("�����ȣ �Է�");
		System.out.println("(���� 10��) 1xxxxxxxxx");
		System.out.println("\tx : ���θ޴�");
		String licenseNo = inputMsg();
		while (!licenseNoFormatCheck(licenseNo)) {
			System.out.println("�߸��� �����Դϴ�");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}

	public String memNameInput() {
		System.out.println("�̸� �Է�");
		System.out.println("�ѱ�(3��) / ����(10��) [ȥ��Ұ�]");
		System.out.println("\tx : ���θ޴�");
		String memName = inputMsg();
		while (!memNameFormatCheck(memName)) {
			System.out.println("�߸��� �����Դϴ�");
			memName = inputMsg();
		}
		return memName;
	}
	
	public String modPhoneNoInput() {
		System.out.println("�ڵ�����ȣ �Է�");
		System.out.println("(���� 11��) 010xxxxxxxx");
		System.out.println("\tx : ���θ޴�");
		String phoneNo = inputMsg();
		while (!modPhoneNoFormatCheck(phoneNo)) {
			System.out.println("�߸��� �����Դϴ�");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}

	

	// �ڵ�����ȣ ����Ȯ��
	public boolean modPhoneNoFormatCheck(String phoneNo) {
		String regex ="^$|[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	public String modMemNameInput() {
		System.out.println("�̸� �Է�(10 Byte)");
		System.out.println("�ѱ�(3��) / ����(10��) [ȥ��Ұ�]");
		System.out.println("\tx : ���θ޴�");
		String memName = inputMsg();
		while (!modMemNameFormatCheck(memName)) {
			System.out.println("�߸��� �����Դϴ�");
			memName = inputMsg();
		}
		return memName;
	}

	public String modLicenseNoInput() {
		System.out.println("�����ȣ �Է�");
		System.out.println("(���� 10��) 1xxxxxxxxx");

		System.out.println("\tx : ���θ޴�");
		String licenseNo = inputMsg();
		while (!modLicenseNoFormatCheck(licenseNo)) {
			System.out.println("�߸��� �����Դϴ�");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}
	
	public boolean modLicenseNoFormatCheck(String licenseNo) {
		String regex ="^$|[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	
	
	public boolean modMemNameFormatCheck(String memName) {
		String regex ="^$|[��-�R]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	
	public String phoneNoInput() {
		System.out.println("�ڵ�����ȣ �Է�");
		System.out.println("(���� 11��) 010xxxxxxxx");
		System.out.println("\tx : ���θ޴�");
		String phoneNo = inputMsg();
		while (!phoneNoFormatCheck(phoneNo)) {
			System.out.println("�߸��� �����Դϴ�");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}
	
	

	public String yesOrNoInput() { // ������ ����
		System.out.println("������������������������������������������������������������");
		System.out.println("��   ���� �Ͻðڽ��ϱ�? ( y / n ) ");
		System.out.println("������������������������������������������������������������");
		String yesOrNo = inputMsg();
		while (!yesOrNoFormatCheck(yesOrNo)) {
			System.out.println("�߸��� �����Դϴ�");
			yesOrNo = inputMsg();
		}
		return yesOrNo;
	}
	

	// �ڵ�����ȣ ����Ȯ��
	public boolean phoneNoFormatCheck(String phoneNo) {
		String regex ="[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	
	// �����ȣ ����Ȯ��
	public boolean licenseNoFormatCheck(String licenseNo) {
		String regex ="[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	
	// ȸ���̸� ����Ȯ��
	public boolean memNameFormatCheck(String memName) {
		String regex ="[��-�R]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	
	// ��¥ ����Ȯ��
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
			System.out.println("�ݳ���¥�� ���۳�¥���� �����ϴ�");
			return false;
		}if(sDate.getTime()==eDate.getTime()) {
			System.out.println("�ݳ���¥�� ���۳�¥�� �����ϴ�");
			return false;
		}
		return true;
		}
		return false;
	}
	
	// ������ȣ ����Ȯ��
	public boolean carNoFormatCheck(String carNo) {
		String regex ="[x]|\\d{1,2}";
		return Pattern.matches(regex, carNo);
	}
	
	// ������ ����Ȯ��
	public boolean carModelFormatCheck(String carModel) {
		String regex ="[��-�R ]{1,6}|[a-zA-Z0-9 ]{1,20}";
		return Pattern.matches(regex, carModel);
	}
	
	// �������� ����Ȯ��
	public boolean carColorFormatCheck(String carColor) {
		String regex ="[a-zA-Z]{1,10}";
		return Pattern.matches(regex, carColor);
	}
	
	// �������� ����Ȯ��
	public boolean carCostFormatCheck(String carCost) {
		String regex ="[x]|\\d{1,10}";
		return Pattern.matches(regex, carCost);
	}
	
	// ����ȣ ����Ȯ��
	public boolean rowNumFormatCheck(String rowNum) {
		String regex ="[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	
	// ���� ����Ȯ��
	public boolean yesOrNoFormatCheck(String yesNo) {
		String regex ="[ynYN]";
		return Pattern.matches(regex, yesNo);
	}
	
	
	// time�ʸ�ŭ ���߱�
	public void pause(double time) {
		try {
			Thread.sleep((long)time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// DB����
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
