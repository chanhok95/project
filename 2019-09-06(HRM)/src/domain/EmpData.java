package domain;

public class EmpData {
	// ���� ������ ����

	public EmpBean[] def_data() { // int �� // �޼ҵ�� = return Ÿ���� ���ƾ��� // EmpBean[] = ��ȯ��
		// empno,ename,mgr,job,salary,comm,hiredate,deptno
		// ������ ����鿡 ���� ���� �Է�
		EmpBean eb = new EmpBean();
		EmpBean eb2 = new EmpBean();
		EmpBean eb3 = new EmpBean();
		EmpBean eb4 = new EmpBean();

		eb.setEmpno(9999);
		eb.setEname("Smith");
		eb.setMgr(1111);
		eb.setJob("IT");
		eb.setSal(9800);
		eb.setComm(9800);
		eb.setHiredate("2019/09/03");
		eb.setDeptno(10);

		eb2.setEmpno(9998);
		eb2.setEname("john");
		eb2.setMgr(1110);
		eb2.setJob("game");
		eb2.setSal(9500);
		eb2.setComm(9500);
		eb2.setDeptno(10);

		eb3.setEmpno(9997);
		eb3.setEname("hoo");
		eb3.setMgr(1109);
		eb3.setJob("com");
		eb3.setSal(9000);
		eb3.setComm(9000);
		eb3.setDeptno(10);

		eb4.setEmpno(9996);
		EmpBean[] ar_eb = { eb, eb2, eb3, eb4 }; // eb,eb2,eb3,eb4 �� ������ �迭(�׷���) ���� = (ar_eb) �� ��ü ���� ���� �Ҵ��

//		EmpBean[] ar_eb2 = null; // �����ٷ��� �ѰŰ�
		// ar_eb2 = new EmpBean[] {eb,eb2,eb3}; //���� �Ҵ��

		EmpBean[] ar_eb3 = new EmpBean[4]; // ����°�� ���ϸ��̾��� ����� ���������� ��ĭ��ŭ�����Ҵ� ������ �����ѰͰ� ���� ��ĸ� �ٸ���
		ar_eb3[0] = eb;
		ar_eb3[1] = eb2;
		ar_eb3[2] = eb3;
		ar_eb3[3] = eb4;

//		ar_eb2 = ar_eb3; // �ٸ����

		return ar_eb3; // return �ϳ��� ���� ��ȯ���� �׷��Ƿ� �׷����ؾߵ�

	}

	// def_data()
	// Ư�� ��� ������ȸ�� �������ϱ� (def_data()�� �����ִ� �ʱ�ȭ)
	public EmpBean getEmp(int empno, EmpBean[] ar_eb) {
		if (ar_eb == null) {
			ar_eb = def_data();

		}
		for (int i = 0; i < ar_eb.length; i++) {
			if (ar_eb[i].getEmpno() == empno) {
				return ar_eb[i];
			}
		}

		return null;

	}

	public EmpBean[] ins_emp(String empno, String ename, EmpBean[] ar_eb) { // ����߰�

		EmpBean[] old_ar_eb = ar_eb; // �迭���� = 4 , �迭���� Ȯ��
		EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length + 1];
//		for (int i = 0; i < old_ar_eb.length; i++) {
//			EmpBean eb = new EmpBean();
//
//			eb.setEmpno(old_ar_eb[i].getEmpno());
//			eb.setEname(old_ar_eb[i].getEname());
//		}
		System.arraycopy(old_ar_eb, 0, new_ar_eb, 0, old_ar_eb.length); // �� �˰����� arraycopy�� �̿��� �����Ҽ�����

		EmpBean n_eb = new EmpBean(); // ��
		n_eb.setEmpno(Integer.parseInt(empno));
		n_eb.setEname(ename);
		new_ar_eb[new_ar_eb.length - 1] = n_eb;

		return new_ar_eb;
	}

	public EmpBean[] del_emp(EmpBean[] ar_eb, String idx) {
		// �Ű����� -> ar_eb , idx
		EmpBean[] new_ar_eb = new EmpBean[ar_eb.length - 1];
		int i_idx = Integer.parseInt(idx);
		int n_idx = 0;
		try {
			/*
			 * for (int i = 0; i < ar_eb.length; i++) { if (i_idx - 1 != i) { EmpBean eb =
			 * new EmpBean(); eb.setEmpno(ar_eb[i].getEmpno());
			 * eb.setEname(ar_eb[i].getEname()); new_ar_eb[n_idx] = eb; n_idx++; // �⺻�� ������
			 * 1���� // ++n_idx; ����� 1����
			 */
			System.arraycopy(ar_eb, 0, new_ar_eb, 0, new_ar_eb.length); // ���� ,�������� , Ÿ�� , Ÿ�ٽ��� , ���簳��

		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("�ش簪�� ���������ʽ��ϴ�.");
			return ar_eb;
		}
		return new_ar_eb;
	}

	public EmpBean[] mod_emp(EmpBean[] ar_eb, String m_empno, String m_ename, String idx) {
		int i_idx = Integer.parseInt(idx); // i_idx�� int�� �ٲٱ����� ����
		if (i_idx > ar_eb.length) { // i_idx[0~3] 4���� �����߿��� ���¼��ڸ� Ŭ���ϰԵǸ� �߸��� index �Է�
			System.out.println("�߸��� index��ȣ �Է�");
			return ar_eb;
		} else {
			ar_eb[i_idx - 1].setEmpno(Integer.parseInt(m_empno)); // empno ��
			ar_eb[i_idx - 1].setEname(m_ename);

			return ar_eb;
		}
	}
}