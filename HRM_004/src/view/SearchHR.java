package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.DeptData;
import domain.DeptBean;
import domain.EmpBean;
import domain.EmpData;

public class SearchHR extends Search {
	// ��� ��ȸ�� ���� view ��ü
	// ����� ������ �����ٰ� ������
	
	
	public void all_View(EmpBean[] ar_eb) {

		System.out.println("��ȸ�� ������");
		System.out.println("=============");
		System.out.println(ar_eb.length);
		for (int i = 0; i < ar_eb.length; i++) {
			System.out.println((i + 1) + "��° �������");
			System.out.println("�����ȣ:" + "+" + ar_eb[i].getEmpno());
			System.out.println("����̸�:" + "+" + ar_eb[i].getEname());
			System.out.println("�����ȣ:" + "+" + ar_eb[i].getDeptno());

		}

	}

	public String emp_view(EmpBean eb) {
//		EmpBean eb = new EmpBean();
		if (eb == null) {
			System.out.println("��ȸ��  ���� �����ϴ�.");
			System.out.println("�ٽð��� �Է����ֽñ� �ٶ��ϴ�");

		} else {
			System.out.println("��ȸ�� ����� ������ �Ʒ��� �����ϴ�.");
			System.out.println("�����ȣ:" + eb.getEmpno());
			System.out.println("����̸�:" + eb.getEname());
		}
		System.out.println("�Լ� �˻��Ͻðڽ��ϱ�?");
		String code = super.input_msg(); // �θ�� ���� �ް� ��ü�� �Ȱ��� �޼ҵ尡 ������ �θ��ִ� �޼ҵ带 ����Ҷ� super
		return code;
	}

	public void all_Vieww(DeptBean[] ar_db) {
		System.out.println("��ȸ�� �μ����");
		System.out.println("=============");
		System.out.println(ar_db.length);
		for (int i = 0; i < ar_db.length; i++) {
			System.out.println((i + 1) + "��° �μ�����");
			System.out.println("�μ���ȣ:" + "+" + ar_db[i].getDeptno());
			System.out.println("�μ��̸�:" + "+" + ar_db[i].getDname());
			System.out.println("�μ���ġ:" + "+" + ar_db[i].getLoc());

		}
	}

	public String dept_View(DeptBean db) {
		// TODO Auto-generated method stub
		if (db == null) {
			System.out.println("��ȸ��  ���� �����ϴ�.");
			System.out.println("�ٽð��� �Է����ֽñ� �ٶ��ϴ�");

		} else {
			System.out.println("��ȸ�� ����� ������ �Ʒ��� �����ϴ�.");
			System.out.println("�����ȣ:" + db.getDeptno());
			System.out.println("����̸�:" + db.getDname());
		}
		System.out.println("�Լ� �˻��Ͻðڽ��ϱ�?");
		String code = super.input_msg(); // �θ�� ���� �ް� ��ü�� �Ȱ��� �޼ҵ尡 ������ �θ��ִ� �޼ҵ带 ����Ҷ� super
		return code;
	}

	@Override
	public void allview(Object[] ar_ob) {
		// TODO Auto-generated method stub
		all_View((EmpBean[]) ar_ob);
	}

	@Override
	public String selview(Object ob) {
		return emp_view((EmpBean) ob);
	}

}

//	@Override
//	public String input_msg(){
//		System.out.println("test");
//		return null;
//	}
