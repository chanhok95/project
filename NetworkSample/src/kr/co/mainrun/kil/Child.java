package kr.co.mainrun.kil;

public class Child extends Parent {

	private String name;

	public Child() {
		this("홍길동");
		System.out.println("child 호출");
	}

	public Child(String name) {
		this.name = name;
		System.out.println("child string name 호출");
	}

	
}


