package interfacesample;

public class Part implements SandCook {

	@Override
	public void sand() {
		// TODO Auto-generated method stub
		System.out.println("알바 생 샌드위치를 만듬");
	}

	@Override
	public void salad() {
		// TODO Auto-generated method stub
		System.out.println("알바생이 샐러드를 만듬");
	}
	
}

// 재정의 알바생이 만드는 샌드위치들 