package interfacesample;

public class HotelCook implements BuggerCook {

	@Override
	public void makeBurger() {
		System.out.println("호텔급 햄버거 만듧");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeSalad() {
		// TODO Auto-generated method stub
		System.out.println("호텔급 샐러드 만듦");
	}

}
// 햄버거를 만드는 사람에는 호텔주장장이 있다