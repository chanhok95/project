package kr.co.mainrun.kil;

public class Parent {

	public String nation;
	
	public Parent() {
		this("���ѹα�");
		System.out.println("�θ� call");
		
	}
	public Parent(String nation) {
		this.nation = nation;
		System.out.println("�θ� (string nation call");
		
	}
}
