package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import domain.EmpBean;
import domain.EmpData;
import ex.CodeValueNotFoundException;
import ex.RunException;

public class Menu extends Commenmethod {
//	List<EmpBean> ar_eb = null; // 전체 사원 정보값
	private int admin_code;

	public Menu(int admin_code) {
		this.admin_code = admin_code;
	}

	public void main_menu() {
		// 데이터값 초기화

		// 메뉴 반복값 추가
		boolean top_menu_bool = true;
		while (top_menu_bool) {
			if (admin_code == 99) {
				System.out.println("관리자 권한으로 실행하셨습니다.");
			} else if (admin_code == 1) {
				System.out.println("일반 사용자 권한으로 실행하셨습니다.");
			}
//			ar_eb = new EmpData().def_data();
			System.out.println("KITRI HUMAN RESORCE MANAGEMANT 에 오신것을 환영합니다.");
			System.out.println("다음 수행할 번호를 누르세요");
			System.out.println("1.사원정보조회");
			System.out.println("2.사원추가");
			if (admin_code == 99) {
				System.out.println("3.사원수정");
				System.out.println("4.사원삭제");
			}
			System.out.println("3.사원수정");
			System.out.println("4.사원삭제");
			System.out.println("5.부서정보조회");
			System.out.println("6.종료");
			System.out.print("=> 값을 입력하세요");
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

			System.out.println("입력하신값은" + menu);
			if (menu.equals("6")) {

				System.out.println("시스템꺼짐");
				top_menu_bool = false;
			} // if문 종료
			else if (menu.equals("1")) {
				frist_menu(); // ★
				// 1번 세부메뉴 메소드 실행시킬수있도록 구상하기

			} else if (menu.equals("2")) {
				second_menu();

			} else if (menu.equals("3") && admin_code == 99) {		// admin만 접근가능
				third_menu();

			} else if (menu.equals("4") && admin_code == 99) {
				four_menu();

			} else if (menu.equals("5")) {
				DeptMenu dm = new DeptMenu();
				dm.five_menu();

			} else {

				try {
					new RunException().runException();// 나머지 키값 번호를 입력했을시 사용자 정의 예외 처리를 할수 있도록 구성 예외객체는
														// CodeValueNotFoundException
				} catch (CodeValueNotFoundException asd) {
					System.out.println("관리자만 접근가능");
				}

			}
		}
	}
	// 1번메뉴 발생시킬수있도록

	// while문 종료

	public void frist_menu() {
		boolean top_menu_bool = true;
		while (top_menu_bool) {
			System.out.println("//////////////////////////////////////");
			System.out.println("/////////사원 정보 조회 메뉴///////////");
			System.out.println("//////////////////////////////////////");
			System.out.println("다음 수행하고자하는 메뉴번호를 누르세요");
			System.out.println("a:전체사원조회");
			System.out.println("b:선택사원조회");
			System.out.println("c:전체사원 엑셀 파일로 생성");
			System.out.println("exit 종료");

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

			System.out.println("입력하신값은" + menu + "입니다");
			if (menu.equals("exit")) {

				System.out.println("exit 선택됨");
				top_menu_bool = false;
			} // if문 종료
			else if (menu.equals("a")) {
				SearchHR shr = new SearchHR();
				shr.all_View(new EmpData().def_data());

			} else if (menu.equals("c")) {
				// c를 입력했을때 객체 생성
				ExcelPrint ep = new ExcelPrint();
				ep.setXls(new EmpData().def_data());
		//	
			} else if (menu.equals("b")) {
				boolean code = true;
				while (code) {
					System.out.println("사원번호를 입력하세요 =>");
					String empno = null;

					try {
						empno = br.readLine();
					} catch (IOException e) {

						e.printStackTrace();
					}

					int i_empno = Integer.parseInt(empno); // int타입으로 변환해서 보여준다
					EmpBean eb = null;
					eb = (EmpBean) new EmpData().getEmp(i_empno); // String empno -> int
					new SearchHR().emp_view(eb);
					String s_code = SearchHR.getInstance().emp_view(eb);
					if (s_code.equals("N")) {
						code = false;
					}
				}
				try {
					new RunException().runException();
				} catch (CodeValueNotFoundException cvnfe) {
					System.out.println("잘못된 코드값을 입력하셨습니다. 다시 확인해주시기 바랍니다.");

				}
			}

		}

		// 1번 세부메뉴 메소드 실행시킬수있도록 구상하기

		// 1번메뉴 발생시킬수있도록
	} // while문 종료

	// firstmenu문 종료

	public void second_menu() {
		System.out.println("추가하고자 하는 사원번호 를 입력하세요.");
		String empno = input_msg();
		System.out.println("추가하고자 하는 사원이름 을 입력하세요.");
		String ename = input_msg();
		System.out.println("추가하고자하는 매니저 번호를 입력하세요");
		String mgr = input_msg();
		System.out.println("추가하고자하는사원의 급여를 입력하세요");
		String sal = input_msg();

		EmpData ed = new EmpData();

		int cnt = ed.ins_emp(empno, ename, Integer.parseInt(mgr), Double.parseDouble(sal));
		System.out.println(cnt + "명의 사원이 입력되었습니다.");
		SearchHR shr = new SearchHR();  
//		shr.all_View(ar_eb);
	}

	private void third_menu() {
		// 사원정보 수정 실행
		System.out.println("수정 메뉴를 선택하셨습니다.");
		System.out.println("수정하고자 하는 사원 리스트 번호를 선택하세요."); // 출력문
		new SearchHR().all_View(new EmpData().def_data()); // SearchHR클래스에 있는 all.view 메소드 불러오기

		String empno = input_msg(); // input_msg()에있는 버퍼리더 사용
		System.out.println("수정하고자하는 사원 번호를 입력하세요.");
		String m_empno = input_msg();
		System.out.println("수정하고자하는  사원 이름을 입력하세요.");
		String m_ename = input_msg();

		EmpData ed = new EmpData();
		int cnt = ed.mod_emp(m_empno, m_ename, empno);

		System.out.println(cnt + "명의 인원을 수정하였습니다.");
//		ar_eb = ed.mod_emp(ar_eb, m_empno, m_ename, idx);

	}

	public void four_menu() {
		// 삭제메뉴출력
		System.out.println("삭제메뉴를 선택하셨습니다");
		System.out.println("원하는 사람의 empno를 입력하시기 바랍니다");
		// 전체리스트출력
		SearchHR sh = new SearchHR();
		new SearchHR().all_View(new EmpData().def_data());
		String idx = input_msg();
		EmpData ed = new EmpData();
//		ed.del_emp(ar_eb, idx);
		int cnt = ed.del_emp(idx);
		System.out.println(cnt + "명의 인원을 삭제하였습니다");
	}

}
