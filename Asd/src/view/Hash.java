package view;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Hash {
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();

		map.put("ch","12");
	
					
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("���̵�� ��й�ȣ�� �Է����ּ���.");
			System.out.println("���̵� :");
			String id = scanner.nextLine();
			
			System.out.println("��й�ȣ :");
			String password = scanner.nextLine();
			System.out.println();
		
			
			
			
			
			
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(password)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					break;
				}else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
				}else {
					System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");
				}
			}
		
		}
	}
