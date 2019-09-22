package co.kr.kil;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
	
		if (m - 45 < 0) {
		
			h--;
			m += 15;
		}else {
			m-=45;
		}
		
			// m의값이 -45 했을때 0보다 크면  h-- ex 10 시  9시로   m+15분
		 if
			(h < 0)	// 
				h=23; 
			// <0 크지 않을경우 -45 
	System.out.println(h+" "+m);	
	}

}
	

//10시 10분  -45분 9시 25분
