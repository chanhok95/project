package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import domain.DeptData;
import domain.DeptBean;
import domain.EmpBean;
import domain.EmpData;

public class SearchHR extends Commenmethod {
	// ��� ��ȸ�� ���� view ��ü
	// ����� ������ �����ٰ� ������
private static SearchHR shr = new SearchHR();
	
	static SearchHR getInstance() {
		return shr;
	}
	public void all_View(List<EmpBean> ar_eb) {

		System.out.println("��ȸ�� ������");
		System.out.println("=============");
		System.out.println(ar_eb.size()); // �迭���� length �� ���� = size
		for (int i = 0; i < ar_eb.size(); i++) {
			System.out.println((i + 1) + "��° �������");
			System.out.println("�����ȣ:" + "+" + ar_eb.get(i).getEmpno()); // get(i) �� �޾ƿ�
			System.out.println("����̸�:" + "+" + ar_eb.get(i).getEname());
			System.out.println("�����ȣ:" + "+" + ar_eb.get(i).getDeptno());

		}

	}

	@SuppressWarnings("unused")
	public String emp_view(List<EmpBean> ar_eb) {
//		EmpBean eb = new EmpBean();
		for (int i = 0; i < ar_eb.size(); i++) {
			if (ar_eb == null) {
				System.out.println("��ȸ��  ���� �����ϴ�.");
				System.out.println("�ٽð��� �Է����ֽñ� �ٶ��ϴ�");

			} else {
				System.out.println("��ȸ�� ����� ������ �Ʒ��� �����ϴ�.");
				System.out.println("�����ȣ:" + ar_eb.get(i).getEmpno());
				System.out.println("����̸�:" + ar_eb.get(i).getEname());

				System.out.println("�Լ� �˻��Ͻðڽ��ϱ�?");
				String code = super.input_msg(); // �θ�� ���� �ް� ��ü�� �Ȱ��� �޼ҵ尡 ������ �θ��ִ� �޼ҵ带 ����Ҷ� super
			}
		}
		return null;
	}

	public void all_Vieww(List<DeptBean> ar_db) {
		System.out.println("��ȸ�� �μ����");
		System.out.println("=============");
		System.out.println(ar_db.size());
		for (int i = 0; i < ar_db.size(); i++) {
			System.out.println((i + 1) + "��° �μ�����");
			System.out.println("�μ���ȣ:" + ar_db.get(i).getDeptno());
			System.out.println("�μ��̸�:" + ar_db.get(i).getDname());
			System.out.println("�μ���ġ:" + ar_db.get(i).getLoc());

		}
	}

	@SuppressWarnings("unused")
	public List<DeptBean> dept_View(List<DeptBean> db) {
		// TODO Auto-generated method stub
		for(int i=0; i<db.size(); i++) {
		if (db == null) {
			System.out.println("��ȸ��  ���� �����ϴ�.");
			System.out.println("�ٽð��� �Է����ֽñ� �ٶ��ϴ�");

		} else {
			System.out.println("��ȸ�� �μ��� ������ �Ʒ��� �����ϴ�.");
			System.out.println("�μ���ȣ:" + db.get(i).getDeptno());
			System.out.println("�μ��̸�:" + db.get(i).getDname());
			System.out.println("�μ���ġ:" + db.get(i).getLoc());
		}
		System.out.println("�Լ� �˻��Ͻðڽ��ϱ�?");
		String code = super.input_msg(); // �θ�� ���� �ް� ��ü�� �Ȱ��� �޼ҵ尡 ������ �θ��ִ� �޼ҵ带 ����Ҷ� super
		
	}
		return db;
	}
}

//	@Override
//	public String input_msg(){
//		System.out.println("test");
//		return null;
//	}