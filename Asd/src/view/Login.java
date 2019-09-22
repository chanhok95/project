package view;

import domain.EmpBean;

public class Login extends Commenmethod {

	// 로그인 할 수 있도록 구성
	public EmpBean login() {
		System.out.println("사원번호 입력하세요.");
		String empno = input_msg();
		System.out.println("사원이름 입력하세요.");
		String ename = input_msg();

		EmpBean eb = new EmpBean();
		eb.setEmpno(Integer.parseInt(empno));
		eb.setEname(ename);

		return eb;
	}

}
