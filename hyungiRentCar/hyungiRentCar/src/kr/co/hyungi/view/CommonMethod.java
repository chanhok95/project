package kr.co.hyungi.view;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonMethod {
	//��ǲ�޽���, ����ǥ���� �޼ҵ�, db������ ����ϰ� ���� Ŭ�������� extends �ϱ�
	
	// message�Է¹ޱ�
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
	
	// DB����
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
