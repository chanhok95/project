package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.DeptBean;
import domain.DeptData;
import domain.EmpBean;
import domain.EmpData;

public class DeptMenu extends Commenmethod {
	DeptBean[] ar_db = null; // 부서전체정보 출력안되는이유★ all_vieww ar_db에서 null값으로인해

	public void five_menu() {
		ar_db = new DeptData().def2_data(); // 부서전체정보 출력안되는이유 ★설정
		// 5번 부서정보 조회 를 눌렀을시 다음 화면으로 넘어갈 1. 부서정보조회 2. 부서추가 3. 부서수정 4. 부서삭제 클릭시 이벤트
		System.out.println("1.부서정보조회");
		System.out.println("2.부서추가");
		System.out.println("3.부서수정");
		System.out.println("4.부서삭제");
		System.out.println("exit 입력");
		// 입력값 받을수있는 기능 수행
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String menu = null; // 전역변수
		try { // try ~ catch 문
			menu = br.readLine(); // String 객체 ,데이터타입x
		} catch (IOException ioe) {
			// IO예외 상황이 발생하면 별도의 처리를 할수있도록함
			menu = "";
		} catch (NullPointerException npe) {
			System.out.println("null,값누락");
		} finally { // finally = try구문이 실행되고 exception이 발생을 하든안하든 try종료시에 실행되는 명령라인
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
			System.out.println("/////////부서 정보 조회 메뉴///////////");
			System.out.println("//////////////////////////////////////");
			System.out.println("다음 수행하고자하는 메뉴번호를 누르세요");
			System.out.println("a:전체부서조회");
			System.out.println("b:선택부서조회");
			System.out.println("exit 종료");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null; // 전역변수
			try { // try ~ catch 문
				menu = br.readLine(); // String 객체 ,데이터타입x
			} catch (IOException ioe) {
				// IO예외 상황이 발생하면 별도의 처리를 할수있도록함
				menu = "";
			} catch (NullPointerException npe) {
				System.out.println("null,값누락");
			} finally { // finally = try구문이 실행되고 exception이 발생을 하든안하든 try종료시에 실행되는 명령라인

			}
			System.out.println("입력하신값은 " + menu + "입니다");
			if (menu.equals("exit")) {
				System.out.println("exit 선택됨");
				top_menu = false;
			} else if (menu.equals("a")) {
				SearchHR sh = new SearchHR();
				sh.all_Vieww(ar_db);
			} else if (menu.equals("b")) {
				boolean code = true;
				while (code) {
					System.out.println("부서번호를 입력하세요 =>");
					String deptno = null;

					try {
						deptno = br.readLine();
					} catch (IOException e) {

						e.printStackTrace();
					}
					int i_deptno = Integer.parseInt(deptno); // int타입으로 변환해서 보여준다
					DeptBean db = null;
					db = new DeptData().getEmp2(i_deptno, ar_db); // String empno -> int
					new SearchHR().dept_View(db);
					String s_code = new SearchHR().dept_View(db);
					if (s_code.equals("n")) {
						code = false;
					}
				}

			}
			// 전체부서 를 보여줄 클래스
		}

//	}
//	private void two_menu() {
//		System.out.println("추가하고자 하는 부서번호 를 입력하세요.");
//		String deptno = input_msg();
//		System.out.println("추가하고자 하는 부서이름 을 입력하세요.");
//		String dname = input_msg();
//
//		DeptData ed = new DeptData();
//
//		ar_db = ed.ins_emp(deptno, dname, ar_db);	//ids_emp 바꿔야됨 여기까지 했음★
//		SearchHR shr = new SearchHR();
//		shr.all_Vieww(ar_db);
//	}

	}	


}
