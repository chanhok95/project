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
		
			// m�ǰ��� -45 ������ 0���� ũ��  h-- ex 10 ��  9�÷�   m+15��
		 if
			(h < 0)	// 
				h=23; 
			// <0 ũ�� ������� -45 
	System.out.println(h+" "+m);	
	}

}
	

//10�� 10��  -45�� 9�� 25��
