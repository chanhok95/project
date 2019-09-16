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
	// ���� ������ ����

	public List<EmpBean> def_data() { // int �� // �޼ҵ�� = return Ÿ���� ���ƾ��� // EmpBean[] = ��ȯ��
		// empno,ename,mgr,job,salary,comm,hiredate,deptno
		// ������ ����鿡 ���� ���� �Է�
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
//		List<EmpBean> eb_list = new ArrayList<EmpBean>(); // arraylist list<empbean> �������̽�
//		eb_list.add(eb);
//		eb_list.add(eb2);
//		eb_list.add(eb3);
//		eb_list.add(eb4);
//		
//		
//		/*
//		 * eb4.setEmpno(9996); ar_eb = { eb, eb2, eb3, eb4 }; //
//		 * eb,eb2,eb3,eb4 �� ������ �迭(�׷���) ���� = (ar_eb) �� ��ü ���� ���� �Ҵ��
//		 * 
//		 * // EmpBean[] ar_eb2 = null; // �����ٷ��� �ѰŰ� // ar_eb2 = new EmpBean[]
//		 * {eb,eb2,eb3}; //���� �Ҵ��
//		 * 
//		 * EmpBean[] ar_eb3 = new EmpBean[4]; // ����°�� ���ϸ��̾��� ����� ���������� ��ĭ��ŭ�����Ҵ� ������
//		 * �����ѰͰ� ���� ��ĸ� �ٸ��� ar_eb3[0] = eb; ar_eb3[1] = eb2; ar_eb3[2] = eb3; ar_eb3[3]
//		 * = eb4;
//		 * 
//		 * // ar_eb2 = ar_eb3; // �ٸ����
//		 * 
//		 * return ar_eb3; // return �ϳ��� ���� ��ȯ���� �׷��Ƿ� �׷����ؾߵ�
//		 */
		// oracle db ���� ���� �޾ƿ��� List�� �߰��ϱ�
		// connetion ����
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
//		}					// connetion���� ���̰ԵǹǷ� con �� ���� ����� ����
//		
		Connection con = dbcon();

		System.out.println("conn ��ü:" + con);
		// ������ �����ų�� �ֵ��� ���������
		Statement stmt = null;
		// db����� ���尴ü�� �����Ͽ� ��������
		ResultSet rs = null;
		List<EmpBean> list = new ArrayList<EmpBean>();

		try {
			stmt = con.createStatement();
			// select �����
			String sql = "SELECT empno,ename,mgr,job,hiredate,sal,comm,deptno FROM emp";

			rs = stmt.executeQuery(sql);
			// insert,update,delete �����
//			stmt.executeUpdate("");

			// resultset ���������� ���� ��ȸ�غ��� iteratior���
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
//				System.out.println(rs.getInt(1));				// �ΰ��������� ������ �����ü�����  �ε��� ù��°empno�� ������
//				System.out.println(rs.getString(2));
//			//				rs.getInt("empno");

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close(); // �ݴ°͵� �������
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
	// Ư�� ��� ������ȸ�� �������ϱ� (def_data()�� �����ִ� �ʱ�ȭ)
	public Object getEmp(int empno) {
		Connection con = dbcon();
		Statement stmt = null;
		ResultSet rs = null;
		EmpBean eb = null;
		String sql = "SELECT empno,ename FROM emp WHERE empno = " + empno;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // ������ �ٲ�� nullpointerexcetion

			if (rs.next()) {

			} // ���� �˻��� �Ǿ�����
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

	public int ins_emp(String empno, String ename, int mgr, double sal) { // ����߰�

		Connection con = dbcon();
		String sql = "INSERT INTO emp(empno,ename,mgr,sal) "; // values ������ " ��ĭ����
		String sql2 = "VALUES(?,?,?,?)";
		int cnt = 0; // insert�� ����� �Ǿ����� Ȯ���ϱ�����
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql + sql2);
			pstmt.setInt(1, Integer.parseInt(empno));
			pstmt.setString(2, ename);
			pstmt.setInt(3, mgr);
			pstmt.setDouble(4, sal);
			// insert�� ����
			cnt = pstmt.executeUpdate(); // �������彺���̸�Ʈ�� �Ű����� �����ʰ�
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
			} // ���� ���� ����
		}

//		EmpBean[] old_ar_eb = ar_eb; // �迭���� = 4 , �迭���� Ȯ��
//		EmpBean[] new_ar_eb = new EmpBean[old_ar_eb.length + 1];
//		for (int i = 0; i < old_ar_eb.length; i++) {
//			EmpBean eb = new EmpBean();
//
//			eb.setEmpno(old_ar_eb[i].getEmpno());
//			eb.setEname(old_ar_eb[i].getEname());
//		}
//		System.arraycopy(old_ar_eb, 0, new_ar_eb, 0, old_ar_eb.length); // �� �˰����� arraycopy�� �̿��� �����Ҽ�����

//		EmpBean n_eb = new EmpBean(); // ��
//		n_eb.setEmpno(Integer.parseInt(empno));
//		n_eb.setEname(ename);
//		ar_eb.add(n_eb);
		// new_ar_eb[new_ar_eb.length - 1] = n_eb;

		return cnt;
	}

	public int del_emp(String empno) {
		Connection con = dbcon();
		// Ʈ�����ǰ�������
		// Autocommit ����
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
				System.out.println("����ó��:commit ��ȷ");
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("������ ����:rollback ����");
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

		// �Ű����� -> ar_eb , idx
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
		 * eb.setEname(ar_eb[i].getEname()); new_ar_eb[n_idx] = eb; n_idx++; // �⺻�� ������
		 * 1���� // ++n_idx; ����� 1����
		 */
//			System.arraycopy(ar_eb, 0, new_ar_eb, 0, new_ar_eb.length); // ���� ,�������� , Ÿ�� , Ÿ�ٽ��� , ���簳��

//		} catch (ArrayIndexOutOfBoundsException aiobe) {
//			System.out.println("�ش簪�� ���������ʽ��ϴ�.");
//			return ar_eb;
//		}
		return 0;
	}

	public int mod_emp(String m_empno, String m_ename,String empno) {
//		int i_idx = Integer.parseInt(idx); // i_idx�� int�� �ٲٱ����� ����
//		if (i_idx > ar_eb.size()) { // i_idx[0~3] 4���� �����߿��� ���¼��ڸ� Ŭ���ϰԵǸ� �߸��� index �Է�
//			System.out.println("�߸��� index��ȣ �Է�");
//			return ar_eb;
//		} else {
//			EmpBean eb = new EmpBean();
//			eb.setEmpno(Integer.parseInt(m_empno)); // empno ��
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
				System.out.println("����ó�� :Commit ����");
				con.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				System.out.println("������ ����: rollback����");
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

	// connetion���� �޼ҵ� ����
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