package kr.co.mainrun.kil;

public class Tas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =1 ;
		int sum = 0 ;
		while(true) {
			sum+=n;
			if(n++ >= 10 ) break; // break 문 때문에 부등호를 < 으로 하게되면 조건을 탈출하게듸므로 값은 1이됨 그러므로 > 으로 하고 >= 을해야 10 까지 값이 돌아서 1~10까지의 값의 합이 나옴
		}
		System.out.println(sum);
	}

}
