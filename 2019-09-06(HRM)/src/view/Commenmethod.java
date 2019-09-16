package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Commenmethod {
		public String input_msg() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String menu = null;
			try { // try ~ catch 문
				menu = br.readLine(); // String 객체 ,데이터타입x
			} catch (IOException e) {
				menu="";
				// IO예외 상황이 발생하면 별도의 처리를 할수있도록함
				e.printStackTrace();

			}
			return menu;
		}
	}

