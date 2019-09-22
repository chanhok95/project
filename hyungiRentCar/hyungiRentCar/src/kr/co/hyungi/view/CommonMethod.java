package kr.co.hyungi.view;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonMethod {
	//인풋메시지, 정규표현식 메소드, db연결을 사용하고 싶은 클래스에서 extends 하기
	
	// message입력받기
	public String inputMsg() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
	
		}
		return input;
	}
	
	// DB연결
	public Connection dbCon() {
		Connection con= null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "scott";
		String password = "tiger";
		
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
