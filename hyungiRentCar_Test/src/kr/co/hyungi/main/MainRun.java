package kr.co.hyungi.main;

import kr.co.hyungi.view.Menu;

public class MainRun {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		new Menu().menu();
	}
}
