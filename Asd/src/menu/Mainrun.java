package menu;

import java.util.Map;

import domain.EmpBean;
import domain.EmpData;
import view.Hash;
import view.Login;
import view.Menu;

public class Mainrun {
	int test = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Menu 객체를 통해 아까 만든 메뉴 실행시키기
		
				//Oracle Driver 등록
		
		
//		Hash hs = new Hash();
//		hs.main(null);
//		oracle 드라이버 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 로그인 기능
				// admin 배열에 들어간 사람은 별도의 관리자 권한을 줌
				int[] admin = {7839, 7566};
				
				Login login = new Login();
				EmpBean eb = login.login();
				EmpData ed = new EmpData();
				int login_code = ed.loginEmp(eb.getEmpno(), eb.getEname());
				if(login_code == 1) {
					// 로그인 성공 시
					// 권한 주기
					int admin_code = -1;
					if(eb.getEmpno() == admin[0] || eb.getEmpno() == admin[1]) {
						// 관리자 권한을 실행할 수 있도록 구성
						admin_code = 99; // 관리자 사용자
					} else {
						admin_code = 1; //일반 사용자
					}
					Menu mn = new Menu(admin_code);
					mn.main_menu();
				} else {
					System.out.println("확인 후 로그인 다시 해주세요.");
				}
				

			}

		}
