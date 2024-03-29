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
	// 사원 조회를 위한 view 객체
	// 사원의 정보를 가져다가 구상함
	private static SearchHR shr = new SearchHR();

	static SearchHR getInstance() {
		return shr;
	}

	public void all_View(List<EmpBean> ar_eb) {

		System.out.println("조회된 사원결과");
		System.out.println("=============");
		System.out.println(ar_eb.size()); // 배열에서 length 와 같음 = size
		for (int i = 0; i < ar_eb.size(); i++) {
			System.out.println((i + 1) + "번째 사원정보");
			System.out.println("사원번호:" + "+" + ar_eb.get(i).getEmpno()); // get(i) 로 받아옴
			System.out.println("사원이름:" + "+" + ar_eb.get(i).getEname());
			System.out.println("사원번호:" + "+" + ar_eb.get(i).getDeptno());

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
//				System.out.println("게속 검색하시겠습니까?");
//				String code = super.input_msg(); // 부모로 부터 받고 자체에 똑같은 메소드가 있지만 부모에있는 메소드를 사용할때 super
		System.out.println("계속 검색 하시겠습니까?(Y,N)");
		String code = super.input_msg(); // Y 다시 검색 하는 메뉴 실행, N 프로세스 종료

		return code;
	}

	public void all_Vieww(List<DeptBean> ar_db) {
		System.out.println("조회된 부서결과");
		System.out.println("=============");
		System.out.println(ar_db.size());
		for (int i = 0; i < ar_db.size(); i++) {
			System.out.println((i + 1) + "번째 부서정보");
			System.out.println("부서번호:" + ar_db.get(i).getDeptno());
			System.out.println("부서이름:" + ar_db.get(i).getDname());
			System.out.println("부서위치:" + ar_db.get(i).getLoc());

		}
	}

	@SuppressWarnings("unused")
	public List<DeptBean> dept_View(List<DeptBean> db) {
		// TODO Auto-generated method stub
		for (int i = 0; i < db.size(); i++) {
			if (db == null) {
				System.out.println("조회된  값이 없습니다.");
				System.out.println("다시값을 입력해주시기 바랍니다");

			} else {
				System.out.println("조회된 부서의 정보는 아래와 같습니다.");
				System.out.println("부서번호:" + db.get(i).getDeptno());
				System.out.println("부서이름:" + db.get(i).getDname());
				System.out.println("부서위치:" + db.get(i).getLoc());
			}
			System.out.println("게속 검색하시겠습니까?");
			String code = super.input_msg(); // 부모로 부터 받고 자체에 똑같은 메소드가 있지만 부모에있는 메소드를 사용할때 super

		}
		return db;
	}
}

//	@Override
//	public String input_msg(){
//		System.out.println("test");
//		return null;
//	}
