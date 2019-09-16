package interfacesample;

public class OracleDao implements DataAccessObject{

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("orcle검색");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("오라클 삽입");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("오라클 수정");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("오라클 삭제");
	}

}
