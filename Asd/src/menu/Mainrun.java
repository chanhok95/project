package menu;

import java.util.Map;

import domain.EmpBean;
import view.Hash;
import view.Menu;

public class Mainrun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hash hs = new Hash();
		hs.main(null);
//		oracle 드라이버 등록
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