package view;

import domain.EmpBean;

public class Login extends Commenmethod {

	// �α��� �� �� �ֵ��� ����
	public EmpBean login() {
		System.out.println("�����ȣ �Է��ϼ���.");
		String empno = input_msg();
		System.out.println("����̸� �Է��ϼ���.");
		String ename = input_msg();

		EmpBean eb = new EmpBean();
		eb.setEmpno(Integer.parseInt(empno));
		eb.setEname(ename);

		return eb;
	}

}
