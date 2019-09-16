package view;

 
// 화면 출력을 할수있도록 구성하는 틀
public abstract class Search extends Commenmethod{		//abstract클래스 가없으면 메소드에서도 만들지 못함
	//전체 내용 볼수 있도록 하는 메소드 구성
	public abstract void allview(Object[] ar_ob);
	// 선택 내용 볼수있도록 하는 구성
	
	public abstract String selview(Object ob);

 
}

