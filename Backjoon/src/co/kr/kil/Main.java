package co.kr.kil;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if ((b <= a && a <= c) || (c <= a && a <= b)) { // b�� a���� ũ��  a��  c���� ũ��   // c�� a���� ũ�� a�� b���� ũ��
			System.out.println(a);
		} else if ((b >= a && c >= b) || (c <= b && b <= a)) {	// b�� a���� �۰� 
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}
}


//Ʋ������  ��°� a,b,c��  "a" " b" "c" �� ǥ�� �������� ū����ǥ ������ �ȵǴµ� .. 
