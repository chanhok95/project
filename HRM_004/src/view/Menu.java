package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import domain.EmpBean;
import domain.EmpData;

public class Menu extends Commenmethod {
	EmpBean[] ar_eb = null; // ��ü ��� ������

	public void main_menu() {
		// �����Ͱ� �ʱ�ȭ
		ar_eb = new EmpData().def_data();
		// �޴� �ݺ��� �߰�
		boolean top_menu_bool = true;
		while (top_menu_bool) {
			System.out.println("KITRI HUMAN RESORCE MANAGEMANT �� ���Ű��� ȯ���մϴ�.");
			System.out.println("���� ������ ��ȣ�� ��������");
			System.out.println("1.���������ȸ");
			System.out.println("2.����߰�");
			System.out.println("3.�������");
			System.out.println("4.�������");
			System.out.println("5.�μ�������ȸ");
			System.out.println("6.����");
			System.out.print("=> ���� �Է��ϼ���");
			// �Է°� �������ִ� ��� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null; // ��������
			try { // try ~ catch ��
				menu = br.readLine(); // String ��ü ,������Ÿ��x
			} catch (IOException ioe) {
				// IO���� ��Ȳ�� �߻��ϸ� ������ ó���� �Ҽ��ֵ�����
				menu = "";
			} catch (NullPointerException npe) {
				System.out.println("null,������");
			} finally { // finally = try������ ����ǰ� exception�� �߻��� �ϵ���ϵ� try����ÿ� ����Ǵ� ���ɶ���

			}

			System.out.println("�Է��ϽŰ���" + menu);
			if (menu.equals("6")) {

				System.out.println("�ý��۲���");
				top_menu_bool = false;
			} // if�� ����
			else if (menu.equals("1")) {
				frist_menu(); // ��
				// 1�� ���θ޴� �޼ҵ� �����ų���ֵ��� �����ϱ�

			} else if (menu.equals("2")) {
				second_menu();
			} else if (menu.equals("3")) {
				third_menu();

			} else if (menu.equals("4")) {
				four_menu();
			
			} else if (menu.equals("5")) {
				DeptMenu dm = new DeptMenu();
				dm.five_menu();
				
			}

		}
		// 1���޴� �߻���ų���ֵ���

		// while�� ����
	}

	public void frist_menu() {
		boolean top_menu_bool = true;
		while (top_menu_bool) {
			System.out.println("//////////////////////////////////////");
			System.out.println("/////////��� ���� ��ȸ �޴�///////////");
			System.out.println("//////////////////////////////////////");
			System.out.println("���� �����ϰ����ϴ� �޴���ȣ�� ��������");
			System.out.println("a:��ü�����ȸ");
			System.out.println("b:���û����ȸ");
			System.out.println("exit ����");

			// �Է°� �������ִ� ��� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null; // ��������
			try { // try ~ catch ��
				menu = br.readLine(); // String ��ü ,������Ÿ��x
			} catch (IOException ioe) {
				// IO���� ��Ȳ�� �߻��ϸ� ������ ó���� �Ҽ��ֵ�����
				menu = "";
			} catch (NullPointerException npe) {
				System.out.println("null,������");
			} finally { // finally = try������ ����ǰ� exception�� �߻��� �ϵ���ϵ� try����ÿ� ����Ǵ� ���ɶ���

			}

			System.out.println("�Է��ϽŰ���" + menu + "�Դϴ�");
			if (menu.equals("exit")) {

				System.out.println("exit ���õ�");
				top_menu_bool = false;
			} // if�� ����
			else if (menu.equals("a")) {
				SearchHR shr = new SearchHR();
				shr.allview(ar_eb);
			}else if (menu.equals("c")) {
				
				
			} else if (menu.equals("b")) {
				boolean code = true;
				while (code) {
					System.out.println("�����ȣ�� �Է��ϼ��� =>");
					String empno = null;

					try {
						empno = br.readLine();
					} catch (IOException e) {

						e.printStackTrace();
					}
					int i_empno = Integer.parseInt(empno); // intŸ������ ��ȯ�ؼ� �����ش�
					EmpBean eb = null;
					eb = new EmpData().getEmp(i_empno, ar_eb); // String empno -> int
					new SearchHR().emp_view(eb);
					String s_code = new SearchHR().selview(eb);
					if (s_code.equals("n")) {
						code = false;
					}
				}

			}

			// 1�� ���θ޴� �޼ҵ� �����ų���ֵ��� �����ϱ�

			// 1���޴� �߻���ų���ֵ���
		} // while�� ����

	}// firstmenu�� ����

	public void second_menu() {
		System.out.println("�߰��ϰ��� �ϴ� �����ȣ �� �Է��ϼ���.");
		String empno = input_msg();
		System.out.println("�߰��ϰ��� �ϴ� ����̸� �� �Է��ϼ���.");
		String ename = input_msg();

		EmpData ed = new EmpData();

		ar_eb = ed.ins_emp(empno, ename, ar_eb);
		SearchHR shr = new SearchHR();
		shr.all_View(ar_eb);
	}

	private void third_menu() {
		// ������� ���� ����
		System.out.println("���� �޴��� �����ϼ̽��ϴ�.");
		System.out.println("�����ϰ��� �ϴ� ��� ����Ʈ ��ȣ�� �����ϼ���."); // ��¹�
		new SearchHR().all_View(ar_eb); // SearchHRŬ������ �ִ� all.view �޼ҵ� �ҷ�����
		String idx = input_msg(); // input_msg()���ִ� ���۸��� ���
		System.out.println("�����ϰ�������� ��ȣ�� �Է��ϼ���.");
		String m_empno = input_msg();
		System.out.println("�����ϰ����� ��� �̸��� �Է��ϼ���.");
		String m_ename = input_msg();
		EmpData ed = new EmpData();
		ar_eb = ed.mod_emp(ar_eb, m_empno, m_ename, idx);

	}

	public void four_menu() {
		// �����޴����
		System.out.println("�����޴��� �����ϼ̽��ϴ�");
		System.out.println("���ϴ� ����� ����Ʈ�͹�ȣ�� ����");
		// ��ü����Ʈ���
		SearchHR sh = new SearchHR();
		sh.all_View(ar_eb);
		String idx = input_msg();
		EmpData ed = new EmpData();
		ed.del_emp(ar_eb, idx);
		ar_eb = ed.del_emp(ar_eb, idx);
	}

	
}