package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Commenmethod {
		public String input_msg() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null;
			try { // try ~ catch ��
				menu = br.readLine(); // String ��ü ,������Ÿ��x
			} catch (IOException e) {
				menu="";
				// IO���� ��Ȳ�� �߻��ϸ� ������ ó���� �Ҽ��ֵ�����
				e.printStackTrace();

			}
			return menu;
		}
	}

