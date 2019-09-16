package interfacesample;

public class Newbook implements Bookorder {

	@Override
	public void newbook() {
		// TODO Auto-generated method stub
		System.out.println("새로운책을 주문한사람");
	}

	@Override
	public void usedbook() {
		// TODO Auto-generated method stub
		System.out.println("오래된 책을 주문한사람");
	}
	
}
