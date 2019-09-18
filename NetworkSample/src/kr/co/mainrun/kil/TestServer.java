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
		// server �����Ҽ��ֵ��� ����
		ServerSocket ss = null;

		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.45", 8989)); // ip�� ��Ʈ��ȣ�� inetsoket ��ü

			while (true) {

				System.out.println("������");
				Socket socket = ss.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); //
				System.out.println("���� ���� : ���� IP:" + isa.getHostName() + "Port��ȣ:" + isa.getPort());

				// client���� ���� ���� �޾ƿü� �ֵ��� �ϱ�
				// inputstream �޾ƿ���
				InputStream is = socket.getInputStream();
				byte[] bytes = null;
				bytes = new byte[100];
				int readByteCnt = is.read(bytes);
				String msg = null;
				msg = new String();
				msg = new String(bytes, 0, readByteCnt, "UTF-8");
				System.out.println("["+isa.getHostName()+ "]���� ���� �޽���" + msg);
			
				//Output Stream ���ؼ� ������ �� �ֵ��� ����
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
		// socket ����� ���� �� �ֵ��� �����ϱ�
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
		try { // try ~ catch ��
			menu = br.readLine(); // String ��ü ,������Ÿ��x
		} catch (IOException e) {
			menu = "";
			// IO���� ��Ȳ�� �߻��ϸ� ������ ó���� �Ҽ��ֵ�����
			e.printStackTrace();

		}
		return menu;
	}
}
