package domain;

public class EmpData {
	// 기초 데이터 세팅

	public EmpBean[] def_data() { // int 형 // 메소드와 = return 타입이 같아야함 // EmpBean[] = 반환형
		// empno,ename,mgr,job,salary,comm,hiredate,deptno
		// 각각의 사원들에 대한 정보 입력
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
		EmpBean[] ar_eb = { eb, eb2, eb3, eb4 }; // eb,eb2,eb3,eb4 의 값들을 배열(그룹핑) 묶음 = (ar_eb) 로 객체 생성 값이 할당됨

//		EmpBean[] ar_eb2 = null; // 보여줄려고 한거고
		// ar_eb2 = new EmpBean[] {eb,eb2,eb3}; //값이 할당됨

		EmpBean[] ar_eb3 = new EmpBean[4]; // 세번째가 제일많이쓰임 어떤값이 들어갈진모르지만 세칸만큼공간할당 저위에 설명한것과 같음 방식만 다를뿐
		ar_eb3[0] = eb;
		ar_eb3[1] = eb2;
		ar_eb3[2] = eb3;
		ar_eb3[3] = eb4;

//		ar_eb2 = ar_eb3; // 다른방식

		return ar_eb3; // return 하나의 값만 반환가능 그러므로 그룹핑해야됨

	}

	// def_data()
	// 특정 사원 정보조회후 값세팅하기 (def_data()에 갖고있는 초기화)
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

	public EmpBean[] ins_emp(String empno, String ename, EmpBean[] ar_eb) { // 사원추가

		EmpBean[] old_ar_eb = ar_eb; // 배열공간 = 4 , 배열공간 확보
		EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length + 1];
//		for (int i = 0; i < old_ar_eb.length; i++) {
//			EmpBean eb = new EmpBean();
//
//			eb.setEmpno(old_ar_eb[i].getEmpno());
//			eb.setEname(old_ar_eb[i].getEname());
//		}
		System.arraycopy(old_ar_eb, 0, new_ar_eb, 0, old_ar_eb.length); // 위 알고리즘을 arraycopy를 이용해 구현할수있음

		EmpBean n_eb = new EmpBean(); // ★
		n_eb.setEmpno(Integer.parseInt(empno));
		n_eb.setEname(ename);
		new_ar_eb[new_ar_eb.length - 1] = n_eb;

		return new_ar_eb;
	}

	public EmpBean[] del_emp(EmpBean[] ar_eb, String idx) {
		// 매개변수 -> ar_eb , idx
		EmpBean[] new_ar_eb = new EmpBean[ar_eb.length - 1];
		int i_idx = Integer.parseInt(idx);
		int n_idx = 0;
		try {
			/*
			 * for (int i = 0; i < ar_eb.length; i++) { if (i_idx - 1 != i) { EmpBean eb =
			 * new EmpBean(); eb.setEmpno(ar_eb[i].getEmpno());
			 * eb.setEname(ar_eb[i].getEname()); new_ar_eb[n_idx] = eb; n_idx++; // 기본값 실행후
			 * 1증가 // ++n_idx; 실행시 1증가
			 */
			System.arraycopy(ar_eb, 0, new_ar_eb, 0, new_ar_eb.length); // 원본 ,원본시작 , 타겟 , 타겟시작 , 복사개수

		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("해당값이 존재하지않습니다.");
			return ar_eb;
		}
		return new_ar_eb;
	}

	public EmpBean[] mod_emp(EmpBean[] ar_eb, String m_empno, String m_ename, String idx) {
		int i_idx = Integer.parseInt(idx); // i_idx를 int로 바꾸기위해 선언
		if (i_idx > ar_eb.length) { // i_idx[0~3] 4개의 숫자중에서 없는숫자를 클릭하게되면 잘못된 index 입력
			System.out.println("잘못된 index번호 입력");
			return ar_eb;
		} else {
			ar_eb[i_idx - 1].setEmpno(Integer.parseInt(m_empno)); // empno 숫
			ar_eb[i_idx - 1].setEname(m_ename);

			return ar_eb;
		}
	}
}