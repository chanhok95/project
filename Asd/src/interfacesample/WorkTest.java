package interfacesample;

public class WorkTest {
	public static void main(String[] args) {
		// 호텔주방장 hcook 아르타바이트 pcook 점원 bk
		BuggerCook hcook = new HotelCook();
		BuggerCook pcook = new PartTimer();
		Buggerclerk bk = new Buggerclerk();
		
		// 주문 발생에 대한처리
		System.out.println("호텔식 햄버거 주문요청 들어옴");
		bk.orderBugger(hcook);
	
		System.out.println("호텔식 샐러드 주문요청 들어옴");
		bk.orderSalad(hcook);

		System.out.println("알바식 햄버거 주문요청 들어옴");
		bk.orderBugger(pcook);
	
		System.out.println("알바식 샐러드 주문요청 들어옴");
		bk.orderSalad(pcook);

	
	
	
	}
	
}
//기능에 대한 테스트