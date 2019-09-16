package domain;

public class DeptData {

	public DeptBean[] def2_data() {
			
			DeptBean db = new DeptBean();
			DeptBean db2= new DeptBean();
			DeptBean db3 =new DeptBean();
			DeptBean db4 =new DeptBean();
			DeptBean db5 =new DeptBean();
			DeptBean db6 =new DeptBean();
			DeptBean db7 =new DeptBean();
					
		db.setDeptno(0);
		db.setDname("IT");
		db.setLoc("TEMP");
		
		db2.setDeptno(15);
		db2.setDname("IT");
		db2.setLoc("SEOUL");
		
		db3.setDeptno( 96);
		db3.setDname ("IT");
		db3.setLoc ( "SEOUL");
		
		db4.setDeptno(  10);
		db4.setDname  ("ACCOUNTING");
		db4.setLoc ( "NEW YORK");
		
		db5.setDeptno  (20);
		db5.setDname  ("RESEARCH");
		db5.setLoc  ("DALLS");
		
		db6.setDeptno(30);
		db6.setDname("SALES");
		db6.setLoc("CHICAGO");
		
		db7.setDeptno(80);
		db7.setDname("OPERATIONS");
		db7.setLoc("BOSTON");
		
	DeptBean[] ar_db = {db,db2,db3,db4,db5,db6,db7};
	DeptBean[] ar_db2 = new  DeptBean[7];
		ar_db2[0] = db;
		ar_db2[1] = db2;
		ar_db2[2] =db3;
		ar_db2[3] =db4;
		ar_db2[4] =db5;
		ar_db2[5] =db6;
		ar_db2[6] =db7;

	return ar_db2;
	
	}
	// def_data()
	// 특정 사원 정보조회후 값세팅하기 (def_data()에 갖고있는 초기화)
	public DeptBean getEmp2(int deptno, DeptBean[] ar_db) {
		if (ar_db == null) {
			ar_db = def2_data();

		}
		for (int i = 0; i < ar_db.length; i++) {
			if (ar_db[i].getDeptno() == deptno) {
				return ar_db[i];
			}
		}

		return null;
	}
}
