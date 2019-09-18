package kr.co.mainrun.kil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// server 구동할수있도록 생성
		ServerSocket ss = null;

		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.45", 8989)); // ip와 포트번호를 inetsoket 객체

			while (true) {

				System.out.println("연결중");
				Socket socket = ss.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); //
				System.out.println("연결 수락 : 접속 IP:" + isa.getHostName() + "Port번호:" + isa.getPort());

				// client에서 부터 값을 받아올수 있도록 하기
				// inputstream 받아오기
				InputStream is = socket.getInputStream();
				byte[] bytes = null;
				bytes = new byte[100];
				int readByteCnt = is.read(bytes);
				String msg = null;
				msg = new String();
				msg = new String(bytes, 0, readByteCnt, "UTF-8");
				System.out.println("["+isa.getHostName()+ "]에서 받은 메시지" + msg);
			
				//Output Stream 통해서 전달할 수 있도록 구성
				OutputStream os = socket.getOutputStream();
				String msg2 = null;
				msg2 = input_msg();
				bytes = msg2.getBytes("UTF-8");
				os.write(bytes);
				
				os.close();
				
				
				
				
				is.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// socket 종료시 닫을 수 있도록 구성하기
		if (!ss.isClosed()) {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
