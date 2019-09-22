package co.kr.kil;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if ((b <= a && a <= c) || (c <= a && a <= b)) { // b가 a보다 크고  a는  c보다 크고   // c는 a보다 크고 a는 b보다 크고
			System.out.println(a);
		} else if ((b >= a && c >= b) || (c <= b && b <= a)) {	// b는 a보다 작고 
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}
}


//틀린이유  출력값 a,b,c에  "a" " b" "c" 로 표현 변수값이 큰따옴표 에들어가면 안되는데 .. 
