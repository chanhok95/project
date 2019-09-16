package domain;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import view.ExcelPrint;

public class EmpData {
	// 기초 데이터 세팅

	public List<EmpBean> def_data() { // int 형 // 메소드와 = return 타입이 같아야함 // EmpBean[] = 반환형
		// empno,ename,mgr,job,salary,comm,hiredate,deptno
		// 각각의 사원들에 대한 정보 입력
//		EmpBean eb = new EmpBean();
//		EmpBean eb2 = new EmpBean();
//		EmpBean eb3 = new EmpBean();
//		EmpBean eb4 = new EmpBean();
//
//		eb.setEmpno(9999);
//		eb.setEname("Smith");
//		eb.setMgr(1111);
//		eb.setJob("IT");
//		eb.setSal(9800);
//		eb.setComm(9800);
//		eb.setHiredate("2019/09/03");
//		eb.setDeptno(10);
//
//		eb2.setEmpno(9998);
//		eb2.setEname("john");
//		eb2.setMgr(1110);
//		eb2.setJob("game");
//		eb2.setSal(9500);
//		eb2.setComm(9500);
//		eb2.setDeptno(10);
//
//		eb3.setEmpno(9997);
//		eb3.setEname("hoo");
//		eb3.setMgr(1109);
//		eb3.setJob("com");
//		eb3.setSal(9000);
//		eb3.setComm(9000);
//		eb3.setDeptno(10);
//
//		List<EmpBean> eb_list = new ArrayList<EmpBean>(); // arraylist list<empbean> 인터페이스
//		eb_list.add(eb);
//		eb_list.add(eb2);
//		eb_list.add(eb3);
//		eb_list.add(eb4);
//		
//		
//		/*
//		 * eb4.setEmpno(9996); ar_eb = { eb, eb2, eb3, eb4 }; //
//		 * eb,eb2,eb3,eb4 의 값들을 배열(그룹핑) 묶음 = (ar_eb) 로 객체 생성 값이 할당됨
//		 * 
//		 * // EmpBean[] ar_eb2 = null; // 보여줄려고 한거고 // ar_eb2 = new EmpBean[]
//		 * {eb,eb2,eb3}; //값이 할당됨
//		 * 
//		 * EmpBean[] ar_eb3 = new EmpBean[4]; // 세번째가 제일많이쓰임 어떤값이 들어갈진모르지만 세칸만큼공간할당 저위에
//		 * 설명한것과 같음 방식만 다를뿐 ar_eb3[0] = eb; ar_eb3[1] = eb2; ar_eb3[2] = eb3; ar_eb3[3]
//		 * = eb4;
//		 * 
//		 * // ar_eb2 = ar_eb3; // 다른방식
//		 * 
//		 * return ar_eb3; // return 하나의 값만 반환가능 그러므로 그룹핑해야됨
//		 */
		// oracle db 에서 값을 받아온후 List에 추가하기
		// connetion 생성
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//		String user = "scott";
//		String password = "tiger";
//		Connection con = null;
//				
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}					// connetion까지 묶이게되므로 con 만 따로 빼내어서 묶음
//		
		Connection con = dbcon();

		System.out.println("conn 객체:" + con);
		// 쿼리문 실행시킬수 있도록 구조만들기
		Statement stmt = null;
		// db결과값 저장객체를 선언하여 가져오기
		ResultSet rs = null;
		List<EmpBean> list = new ArrayList<EmpBean>();

		try {
			stmt = con.createStatement();
			// select 실행시
			String sql = "SELECT empno,ename,mgr,job,hiredate,sal,comm,deptno FROM emp";

			rs = stmt.executeQuery(sql);
			// insert,update,delete 실행시
//			stmt.executeUpdate("");

			// resultset 내에서부터 값을 조회해보기 iteratior방식
			int cnt = 0;

			while (rs.next()) {
				EmpBean eb = new EmpBean();
				eb.setEmpno(rs.getInt(1));
				eb.setEname(rs.getString(2));
				eb.setMgr(rs.getInt(3));
				eb.setJob(rs.getString(4));
				eb.setHiredate(rs.getString(5));
				eb.setSal(rs.getDouble(6));
				eb.setComm(rs.getDouble(7));
				eb.setDeptno(rs.getInt(8));
				list.add(eb);
//			System.out.println(++cnt);
//				System.out.println(rs.getInt(1));				// 두가지형태의 값으로 가져올수있음  인덱스 첫번째empno를 가져옴
//				System.out.println(rs.getString(2));
//			//				rs.getInt("empno");

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close(); // 닫는것도 순서대로
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}

	// def_data()
	// 특정 사원 정보조회후 값세팅하기 (def_data()에 갖고있는 초기화)
	public Object getEmp(int empno) {
		Connection con = dbcon();
		Statement stmt = null;
		ResultSet rs = null;
		EmpBean eb = null;
		String sql = "SELECT empno,ename FROM emp WHERE empno = " + empno;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // 순서가 바뀌면 nullpointerexcetion

			if (rs.next()) {

			} // 값이 검색이 되었을시
			eb = new EmpBean();
			eb.setEmpno(rs.getInt(1));
			eb.setEname(rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

//		for (int i = 0; i < ar_eb.size(); i++) {
//			if (ar_eb.get(i).getEmpno() == empno) {
//				return ar_eb.get(i);
//			}
//		}

		return eb;

	}

	public int ins_emp(String empno, String ename, int mgr, double sal) { // 사원추가

		Connection con = dbcon();
		String sql = "INSERT INTO emp(empno,ename,mgr,sal) "; // values 때문에 " 한칸띄우고
		String sql2 = "VALUES(?,?,?,?)";
		int cnt = 0; // insert가 제대로 되었는지 확인하기위해
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql + sql2);
			pstmt.setInt(1, Integer.parseInt(empno));
			pstmt.setString(2, ename);
			pstmt.setInt(3, mgr);
			pstmt.setDouble(4, sal);
			// insert문 실행
			cnt = pstmt.executeUpdate(); // 프리페어드스테이먼트는 매개값을 주지않고
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 먼저 연거 나중
		}

//		EmpBean[] old_ar_eb = ar_eb; // 배열공간 = 4 , 배열공간 확보
//		EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length + 1];
//		for (int i = 0; i < old_ar_eb.length; i++) {
//			EmpBean eb = new EmpBean();
//
//			eb.setEmpno(old_ar_eb[i].getEmpno());
//			eb.setEname(old_ar_eb[i].getEname());
//		}
//		System.arraycopy(old_ar_eb, 0, new_ar_eb, 0, old_ar_eb.length); // 위 알고리즘을 arraycopy를 이용해 구현할수있음

//		EmpBean n_eb = new EmpBean(); // ★
//		n_eb.setEmpno(Integer.parseInt(empno));
//		n_eb.setEname(ename);
//		ar_eb.add(n_eb);
		// new_ar_eb[new_ar_eb.length - 1] = n_eb;

		return cnt;
	}

	public int del_emp(String empno) {
		Connection con = dbcon();
		// 트랙젝션관리설정
		// Autocommit 해제
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {
			String sql = "DELETE FROM emp WHERE empno =?";
			System.out.println("AutoCommit Setting false");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empno));
			cnt = pstmt.executeUpdate();
			if(cnt == 1) {
				System.out.println("정상처리:commit 실횅");
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("비정상 종료:rollback 실행");
				con.rollback();
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					System.out.println("AutoCommit Setting true");
					con.setAutoCommit(true);
					if(pstmt != null)
					pstmt.close();
					if(con !=null)
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}

		// 매개변수 -> ar_eb , idx
//		EmpBean[] new_ar_eb = new EmpBean[ar_eb.size() - 1];
//		List<EmpBean> ar_eb_ll = new LinkedList<EmpBean>();
//		ar_eb_ll = ar_eb;
//		int i_idx = Integer.parseInt(idx);
//		int n_idx = 0;
//		ar_eb.remove(i_idx - 1);
//		try {
		/*
		 * for (int i = 0; i < ar_eb.length; i++) { if (i_idx - 1 != i) { EmpBean eb =
		 * new EmpBean(); eb.setEmpno(ar_eb[i].getEmpno());
		 * eb.setEname(ar_eb[i].getEname()); new_ar_eb[n_idx] = eb; n_idx++; // 기본값 실행후
		 * 1증가 // ++n_idx; 실행시 1증가
		 */
//			System.arraycopy(ar_eb, 0, new_ar_eb, 0, new_ar_eb.length); // 원본 ,원본시작 , 타겟 , 타겟시작 , 복사개수

//		} catch (ArrayIndexOutOfBoundsException aiobe) {
//			System.out.println("해당값이 존재하지않습니다.");
//			return ar_eb;
//		}
		return 0;
	}

	public int mod_emp(String m_empno, String m_ename,String empno) {
//		int i_idx = Integer.parseInt(idx); // i_idx를 int로 바꾸기위해 선언
//		if (i_idx > ar_eb.size()) { // i_idx[0~3] 4개의 숫자중에서 없는숫자를 클릭하게되면 잘못된 index 입력
//			System.out.println("잘못된 index번호 입력");
//			return ar_eb;
//		} else {
//			EmpBean eb = new EmpBean();
//			eb.setEmpno(Integer.parseInt(m_empno)); // empno 숫
//			eb.setEname(m_ename);
//			ar_eb.set(i_idx - 1, eb);
//			return ar_eb;
//		}
		Connection con = dbcon();
		PreparedStatement pstmt = null;
		int cnt =0;
		//String SQL = "update customers set pass=?, name=? where id=?";
		try {
			String sql ="UPDATE emp SET empno=?, ename=? WHERE empno=?";	
			System.out.println("AutoCommit Setting false");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(m_empno));
			pstmt.setString(2,m_ename);
			pstmt.setInt(3, Integer.parseInt(empno));
			cnt = pstmt.executeUpdate();
			
			if(cnt ==1) {
				System.out.println("정상처리 :Commit 실행");
				con.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("비정상 종료: rollback실행");
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					System.out.println("AutoCommit Setting true");
					con.setAutoCommit(true);
					if(pstmt != null)
					pstmt.close();
					if(con !=null)
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	
		return cnt;
	}

	// connetion생성 메소드 구성
	public Connection dbcon() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "scott";
		String password = "tiger";

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}