package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.DeptData;
import domain.DeptBean;
import domain.EmpBean;
import domain.EmpData;

public class SearchHR extends Commenmethod {
	// 사원 조회를 위한 view 객체
	// 사원의 정보를 가져다가 구상함
	public void all_View(EmpBean[] ar_eb) {

		System.out.println("조회된 사원결과");
		System.out.println("=============");
		System.out.println(ar_eb.length);
		for (int i = 0; i < ar_eb.length; i++) {
			System.out.println((i + 1) + "번째 사원정보");
			System.out.println("사원번호:" + "+" + ar_eb[i].getEmpno());
			System.out.println("사원이름:" + "+" + ar_eb[i].getEname());
			System.out.println("사원번호:" + "+" + ar_eb[i].getDeptno());

		}

	}

	public String emp_view(EmpBean eb) {
//		EmpBean eb = new EmpBean();
		if (eb == null) {
			System.out.println("조회된  값이 없습니다.");
			System.out.println("다시값을 입력해주시기 바랍니다");

		} else {
			System.out.println("조회된 사원의 정보는 아래와 같습니다.");
			System.out.println("사원번호:" + eb.getEmpno());
			System.out.println("사원이름:" + eb.getEname());
		}
		System.out.println("게속 검색하시겠습니까?");
		String code = super.input_msg(); // 부모로 부터 받고 자체에 똑같은 메소드가 있지만 부모에있는 메소드를 사용할때 super
		return code;
	}

	public void all_Vieww(DeptBean[] ar_db) {
		System.out.println("조회된 부서결과");
		System.out.println("=============");
		System.out.println(ar_db.length);
		for (int i = 0; i < ar_db.length; i++) {
			System.out.println((i + 1) + "번째 부서정보");
			System.out.println("부서번호:" +  ar_db[i].getDeptno());
			System.out.println("부서이름:"  + ar_db[i].getDname());
			System.out.println("부서위치:"  + ar_db[i].getLoc());

		}
	}

	public String dept_View(DeptBean db) {
		// TODO Auto-generated method stub
		if (db == null) {
			System.out.println("조회된  값이 없습니다.");
			System.out.println("다시값을 입력해주시기 바랍니다");

		} else  {
			System.out.println("조회된 부서의 정보는 아래와 같습니다.");
			System.out.println("부서번호:" + db.getDeptno());
			System.out.println("부서이름:" + db.getDname());
			System.out.println("부서위치:" + db.getLoc());
		}
		System.out.println("게속 검색하시겠습니까?");
		String code = super.input_msg(); // 부모로 부터 받고 자체에 똑같은 메소드가 있지만 부모에있는 메소드를 사용할때 super
		return code;
	}

}

//	@Override
//	public String input_msg(){
//		System.out.println("test");
//		return null;
//	}
