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
	//ÀÎÇ²¸Þ½ÃÁö, Á¤±ÔÇ¥Çö½Ä ¸Þ¼Òµå, db¿¬°áÀ» »ç¿ëÇÏ°í ½ÍÀº Å¬·¡½º¿¡¼­ extends ÇÏ±â
	
	// messageÀÔ·Â¹Þ±â
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
		System.out.println("¿¹¾àno(¹øÈ£)¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String historyRowNum = inputMsg();
		while (!rowNumFormatCheck(historyRowNum)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			historyRowNum = inputMsg();
		}
		return historyRowNum;
	}

	public String dateInputInput() {
		System.out.println("±â°£À» ÀÔ·ÂÇÏ¼¼¿ä (´ë¿© ½ÃÀÛÀÏ ±âÁØ)");
		System.out.println("ex) 010102-010103 (¿ùÀÏ½Ã-¿ùÀÏ½Ã)");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String dateInput = inputMsg();
		while (!dateFormatCheck(dateInput)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			dateInput = inputMsg();
		}
		return dateInput;
	}
	
	public String enterDateInput() {
		System.out.println("±â°£À» ÀÔ·ÂÇÏ¼¼¿ä (´ë¿©½ÃÀÛÀÏ ±âÁØ)");
		System.out.println("ex) 010102-010103 (¿ùÀÏ½Ã-¿ùÀÏ½Ã)");
		System.out.println("±âÁ¸ÀÔ·Â enter");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String dateInput = inputMsg();
		while (!enterDateFormatCheck(dateInput)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			dateInput = inputMsg();
		}
		return dateInput;
	}

	// ³¯Â¥ Çü½ÄÈ®ÀÎ
	public boolean enterDateFormatCheck(String date) {
		String regex ="^$|[x]|(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])-(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])";
		return Pattern.matches(regex, date);
	}

	public String carNoInput() {
		System.out.println("No. ÀÔ·Â");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String carNo = inputMsg();
		while (!carNoFormatCheck(carNo)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			carNo = inputMsg();
		}
		return carNo;
	}

	public String carColorInput() {
		System.out.println("Â÷·® »ö»ó ÀÔ·Â");
		System.out.println("¿µ¹®¸¸ °¡´É(10ÀÚ)");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String carColor = inputMsg();
		while (!carColorFormatCheck(carColor)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			carColor = inputMsg();
		}
		return carColor;
	}

	public String carModelInput() {
		System.out.println("Â÷·® ¸ðµ¨ ÀÔ·Â");
		System.out.println("ÇÑ±Û(6ÀÚ) / ¿µ¹®(20ÀÚ) [È¥¿ëºÒ°¡]");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String carModel = inputMsg();
		while (!carModelFormatCheck(carModel)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			carModel = inputMsg();
		}
		return carModel;
	}
	
	
	public String carCostInput() {
		System.out.println("Â÷·® ½Ã°£´ç °¡°Ý ÀÔ·Â");
		System.out.println("¼ýÀÚ(100¾ï ¹Ì¸¸)");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String carCost = inputMsg();
		while (!carCostFormatCheck(carCost)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			carCost = inputMsg();
		}
		return carCost;
	}

	public String carRowNumInput() { // Â÷·®¼±ÅÃ
		System.out.println("-----------------------");
		System.out.println("¿øÇÏ½Ã´Â Â÷·®No¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String carno = inputMsg();
		while (!rowNumFormatCheck(carno)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			carno = inputMsg();
		}
		return carno;
	}

	public String enterCarRowNumInput() { // Â÷·®¼±ÅÃ
		System.out.println("-----------------------");
		System.out.println("¿øÇÏ½Ã´Â Â÷·®No¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		System.out.println("±âÁ¸ÀÔ·Â:enter");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String carno = inputMsg();
		while (!enterRowNumFormatCheck(carno)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			carno = inputMsg();
		}
		return carno;
	}
	
	// ¿­¹øÈ£ Çü½ÄÈ®ÀÎ
	public boolean enterRowNumFormatCheck(String rowNum) {
		String regex ="^$|[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	
	public String licenseNoInput() {
		System.out.println("¸éÇã¹øÈ£ ÀÔ·Â");
		System.out.println("(¼ýÀÚ 10ÀÚ) 1xxxxxxxxx");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String licenseNo = inputMsg();
		while (!licenseNoFormatCheck(licenseNo)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}

	public String memNameInput() {
		System.out.println("ÀÌ¸§ ÀÔ·Â");
		System.out.println("ÇÑ±Û(3ÀÚ) / ¿µ¹®(10ÀÚ) [È¥¿ëºÒ°¡]");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String memName = inputMsg();
		while (!memNameFormatCheck(memName)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			memName = inputMsg();
		}
		return memName;
	}
	
	public String modPhoneNoInput() {
		System.out.println("ÇÚµåÆù¹øÈ£ ÀÔ·Â");
		System.out.println("(¼ýÀÚ 11ÀÚ) 010xxxxxxxx");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String phoneNo = inputMsg();
		while (!modPhoneNoFormatCheck(phoneNo)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}

	

	// ÇÚµåÆù¹øÈ£ Çü½ÄÈ®ÀÎ
	public boolean modPhoneNoFormatCheck(String phoneNo) {
		String regex ="^$|[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	public String modMemNameInput() {
		System.out.println("ÀÌ¸§ ÀÔ·Â(10 Byte)");
		System.out.println("ÇÑ±Û(3ÀÚ) / ¿µ¹®(10ÀÚ) [È¥¿ëºÒ°¡]");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String memName = inputMsg();
		while (!modMemNameFormatCheck(memName)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			memName = inputMsg();
		}
		return memName;
	}

	public String modLicenseNoInput() {
		System.out.println("¸éÇã¹øÈ£ ÀÔ·Â");
		System.out.println("(¼ýÀÚ 10ÀÚ) 1xxxxxxxxx");

		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String licenseNo = inputMsg();
		while (!modLicenseNoFormatCheck(licenseNo)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			licenseNo = inputMsg();
		}
		return licenseNo;
	}
	
	public boolean modLicenseNoFormatCheck(String licenseNo) {
		String regex ="^$|[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	
	
	public boolean modMemNameFormatCheck(String memName) {
		String regex ="^$|[°¡-ÆR]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	
	public String phoneNoInput() {
		System.out.println("ÇÚµåÆù¹øÈ£ ÀÔ·Â");
		System.out.println("(¼ýÀÚ 11ÀÚ) 010xxxxxxxx");
		System.out.println("\tx : ¸ÞÀÎ¸Þ´º");
		String phoneNo = inputMsg();
		while (!phoneNoFormatCheck(phoneNo)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			phoneNo = inputMsg();
		}
		return phoneNo;
	}
	
	

	public String yesOrNoInput() { // °áÁ¦½Ã ÀúÀå
		System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
		System.out.println("¦­   °áÁ¦ ÇÏ½Ã°Ú½À´Ï±î? ( y / n ) ");
		System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
		String yesOrNo = inputMsg();
		while (!yesOrNoFormatCheck(yesOrNo)) {
			System.out.println("Àß¸øµÈ Çü½ÄÀÔ´Ï´Ù");
			yesOrNo = inputMsg();
		}
		return yesOrNo;
	}
	

	// ÇÚµåÆù¹øÈ£ Çü½ÄÈ®ÀÎ
	public boolean phoneNoFormatCheck(String phoneNo) {
		String regex ="[x]|010\\d{8}";
		return Pattern.matches(regex, phoneNo);
	}
	
	// ¸éÇã¹øÈ£ Çü½ÄÈ®ÀÎ
	public boolean licenseNoFormatCheck(String licenseNo) {
		String regex ="[x]|1\\d{9}";
		return Pattern.matches(regex, licenseNo);
	}
	
	// È¸¿øÀÌ¸§ Çü½ÄÈ®ÀÎ
	public boolean memNameFormatCheck(String memName) {
		String regex ="[°¡-ÆR]{1,3}|[a-zA-Z0-9]{1,10}";
		return Pattern.matches(regex, memName);
	}
	
	// ³¯Â¥ Çü½ÄÈ®ÀÎ
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
			System.out.println("¹Ý³³³¯Â¥°¡ ½ÃÀÛ³¯Â¥º¸´Ù ºü¸¨´Ï´Ù");
			return false;
		}if(sDate.getTime()==eDate.getTime()) {
			System.out.println("¹Ý³³³¯Â¥¶û ½ÃÀÛ³¯Â¥°¡ °°½À´Ï´Ù");
			return false;
		}
		return true;
		}
		return false;
	}
	
	// Â÷·®¹øÈ£ Çü½ÄÈ®ÀÎ
	public boolean carNoFormatCheck(String carNo) {
		String regex ="[x]|\\d{1,2}";
		return Pattern.matches(regex, carNo);
	}
	
	// Â÷·®¸ðµ¨ Çü½ÄÈ®ÀÎ
	public boolean carModelFormatCheck(String carModel) {
		String regex ="[°¡-ÆR ]{1,6}|[a-zA-Z0-9 ]{1,20}";
		return Pattern.matches(regex, carModel);
	}
	
	// Â÷·®»ö»ó Çü½ÄÈ®ÀÎ
	public boolean carColorFormatCheck(String carColor) {
		String regex ="[a-zA-Z]{1,10}";
		return Pattern.matches(regex, carColor);
	}
	
	// Â÷·®°¡°Ý Çü½ÄÈ®ÀÎ
	public boolean carCostFormatCheck(String carCost) {
		String regex ="[x]|\\d{1,10}";
		return Pattern.matches(regex, carCost);
	}
	
	// ¿­¹øÈ£ Çü½ÄÈ®ÀÎ
	public boolean rowNumFormatCheck(String rowNum) {
		String regex ="[x]|[0-9]{1,2}";
		return Pattern.matches(regex, rowNum);
	}
	
	// °¡ºÎ Çü½ÄÈ®ÀÎ
	public boolean yesOrNoFormatCheck(String yesNo) {
		String regex ="[ynYN]";
		return Pattern.matches(regex, yesNo);
	}
	
	
	// timeÃÊ¸¸Å­ ¸ØÃß±â
	public void pause(double time) {
		try {
			Thread.sleep((long)time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// DB¿¬°á
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
