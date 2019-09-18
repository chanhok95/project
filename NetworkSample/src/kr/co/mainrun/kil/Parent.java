package kr.co.mainrun.kil;

public class Parent {

	public String nation;
	
	public Parent() {
		this("대한민국");
		System.out.println("부모 call");
		
	}
	public Parent(String nation) {
		this.nation = nation;
		System.out.println("부모 (string nation call");
		
	}
}
