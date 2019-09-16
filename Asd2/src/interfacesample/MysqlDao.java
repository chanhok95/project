package interfacesample;

public class MysqlDao implements DataAccessObject {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("mysql 검색");
	
	}

	@Override
	public void insert() {
	
		// TODO Auto-generated method stub
		System.out.println("mysql 삭제");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("mysql 삽입");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("mysql 수정");
		
	}



}
