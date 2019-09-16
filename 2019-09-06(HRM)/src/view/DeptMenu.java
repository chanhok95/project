package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.DeptBean;
import domain.DeptData;
import domain.EmpBean;
import domain.EmpData;

public class DeptMenu extends Commenmethod {
	DeptBean[] ar_db = null; // �μ���ü���� ��¾ȵǴ������� all_vieww ar_db���� null����������

	public void five_menu() {
		ar_db = new DeptData().def2_data(); // �μ���ü���� ��¾ȵǴ����� �ڼ���
		// 5�� �μ����� ��ȸ �� �������� ���� ȭ������ �Ѿ 1. �μ�������ȸ 2. �μ��߰� 3. �μ����� 4. �μ����� Ŭ���� �̺�Ʈ
		System.out.println("1.�μ�������ȸ");
		System.out.println("2.�μ��߰�");
		System.out.println("3.�μ�����");
		System.out.println("4.�μ�����");
		System.out.println("exit �Է�");
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
		} finally { // finally = try������ ����ǰ� exception�� �߻��� �ϵ���ϵ� try����ÿ� ����Ǵ� ��ɶ���
		}
		if (menu.equals("1")) {
			one_menu();
//		}else if (menu.equals("2")) {
//			two_menu();

		}

	}


	public void one_menu() {
		boolean top_menu = true;
		while (top_menu) {
			System.out.println("//////////////////////////////////////");
			System.out.println("/////////�μ� ���� ��ȸ �޴�///////////");
			System.out.println("//////////////////////////////////////");
			System.out.println("���� �����ϰ����ϴ� �޴���ȣ�� ��������");
			System.out.println("a:��ü�μ���ȸ");
			System.out.println("b:���úμ���ȸ");
			System.out.println("exit ����");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null; // ��������
			try { // try ~ catch ��
				menu = br.readLine(); // String ��ü ,������Ÿ��x
			} catch (IOException ioe) {
				// IO���� ��Ȳ�� �߻��ϸ� ������ ó���� �Ҽ��ֵ�����
				menu = "";
			} catch (NullPointerException npe) {
				System.out.println("null,������");
			} finally { // finally = try������ ����ǰ� exception�� �߻��� �ϵ���ϵ� try����ÿ� ����Ǵ� ��ɶ���

			}
			System.out.println("�Է��ϽŰ��� " + menu + "�Դϴ�");
			if (menu.equals("exit")) {
				System.out.println("exit ���õ�");
				top_menu = false;
			} else if (menu.equals("a")) {
				SearchHR sh = new SearchHR();
				sh.all_Vieww(ar_db);
			} else if (menu.equals("b")) {
				boolean code = true;
				while (code) {
					System.out.println("�μ���ȣ�� �Է��ϼ��� =>");
					String deptno = null;

					try {
						deptno = br.readLine();
					} catch (IOException e) {

						e.printStackTrace();
					}
					int i_deptno = Integer.parseInt(deptno); // intŸ������ ��ȯ�ؼ� �����ش�
					DeptBean db = null;
					db = new DeptData().getEmp2(i_deptno, ar_db); // String empno -> int
					new SearchHR().dept_View(db);
					String s_code = new SearchHR().dept_View(db);
					if (s_code.equals("n")) {
						code = false;
					}
				}

			}
			// ��ü�μ� �� ������ Ŭ����
		}

//	}
//	private void two_menu() {
//		System.out.println("�߰��ϰ��� �ϴ� �μ���ȣ �� �Է��ϼ���.");
//		String deptno = input_msg();
//		System.out.println("�߰��ϰ��� �ϴ� �μ��̸� �� �Է��ϼ���.");
//		String dname = input_msg();
//
//		DeptData ed = new DeptData();
//
//		ar_db = ed.ins_emp(deptno, dname, ar_db);	//ids_emp �ٲ�ߵ� ������� ������
//		SearchHR shr = new SearchHR();
//		shr.all_Vieww(ar_db);
//	}

	}	


}
