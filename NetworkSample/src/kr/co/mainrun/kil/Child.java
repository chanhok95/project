package kr.co.mainrun.kil;

public class Child extends Parent {

	private String name;

	public Child() {
		this("ȫ�浿");
		System.out.println("child ȣ��");
	}

	public Child(String name) {
		this.name = name;
		System.out.println("child string name ȣ��");
	}

	
}


