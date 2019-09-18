package kr.co.mainrun.kil;

public class Tas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =1 ;
		int sum = 0 ;
		while(true) {
			sum+=n;
			if(n++ >= 10 ) break;
		}
		System.out.println(sum);
	}

}
