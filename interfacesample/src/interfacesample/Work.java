package interfacesample;

public class Work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SandCook pe = new Sandpeople();
		SandCook pa = new Part();
		ClientSand cs = new ClientSand();	
		
		
		System.out.println("주방장 샌드위치주문합니다");
		cs.Sandd(pe);
		System.out.println("알바생 샐러드주문합니다");
		cs.saladd(pa);
	}

}

		//구현 
