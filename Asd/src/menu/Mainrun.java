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
		// Menu ��ü�� ���� �Ʊ� ���� �޴� �����Ű��
		
				//Oracle Driver ���
		
		
//		Hash hs = new Hash();
//		hs.main(null);
//		oracle ����̹� ���
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// �α��� ���
				// admin �迭�� �� ����� ������ ������ ������ ��
				int[] admin = {7839, 7566};
				
				Login login = new Login();
				EmpBean eb = login.login();
				EmpData ed = new EmpData();
				int login_code = ed.loginEmp(eb.getEmpno(), eb.getEname());
				if(login_code == 1) {
					// �α��� ���� ��
					// ���� �ֱ�
					int admin_code = -1;
					if(eb.getEmpno() == admin[0] || eb.getEmpno() == admin[1]) {
						// ������ ������ ������ �� �ֵ��� ����
						admin_code = 99; // ������ �����
					} else {
						admin_code = 1; //�Ϲ� �����
					}
					Menu mn = new Menu(admin_code);
					mn.main_menu();
				} else {
					System.out.println("Ȯ�� �� �α��� �ٽ� ���ּ���.");
				}
				

			}

		}
