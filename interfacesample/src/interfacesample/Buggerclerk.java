package interfacesample;

public class Buggerclerk {
	public void orderBugger(BuggerCook cook) {
		System.out.println("주방에 햄버거를 주문합니다.");
		cook.makeBurger();
	}
	public void orderSalad(BuggerCook cook) {
		System.out.println("주방에 샐러드를 주문합니다.");
		cook.makeSalad();
	}

	
}
//고객의 요구사항 처리