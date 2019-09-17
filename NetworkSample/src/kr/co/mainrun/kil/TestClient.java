package kr.co.mainrun.kil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args) {
		// client 접속하기
		Socket sk = new Socket();
		System.out.println("연걸 요청");
		try {
			sk.connect(new InetSocketAddress("192.168.14.45", 8989));
			System.out.println("연결 성공");
			System.out.println(sk.getRemoteSocketAddress());

			// 데이터 전달을 위한 byte 선언
			byte[] bytes = null;
			String message = null;

			OutputStream os = sk.getOutputStream();
			message = input_msg();
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("메시지 전달 성공");

			InputStream is = sk.getInputStream();
			bytes = new byte[100];
			int rbc = is.read(bytes);
			message = new String(bytes, 0, rbc, "UTF-8");
			System.out.println("서버로 받은 메시지 :" + message);
			is.close();
			os.close();
			sk.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String input_msg() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String menu = null;
		try { // try ~ catch 문
			menu = br.readLine(); // String 객체 ,데이터타입x
		} catch (IOException e) {
			menu = "";
			// IO예외 상황이 발생하면 별도의 처리를 할수있도록함
			e.printStackTrace();

		}
		return menu;
	}

}
