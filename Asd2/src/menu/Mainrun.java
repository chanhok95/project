package menu;

import java.util.Map;

import domain.EmpBean;
import view.Menu;

public class Mainrun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//oracle ����̹� ���
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Menu mn = new Menu();
		mn.main_menu();

	}
}