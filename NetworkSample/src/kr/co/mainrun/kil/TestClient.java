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
		// client �����ϱ�
		Socket sk = new Socket();
		System.out.println("���� ��û");
		try {
			sk.connect(new InetSocketAddress("192.168.14.45", 8989));
			System.out.println("���� ����");
			System.out.println(sk.getRemoteSocketAddress());

			// ������ ������ ���� byte ����
			byte[] bytes = null;
			String message = null;

			OutputStream os = sk.getOutputStream();
			message = input_msg();
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("�޽��� ���� ����");

			InputStream is = sk.getInputStream();
			bytes = new byte[100];
			int rbc = is.read(bytes);
			message = new String(bytes, 0, rbc, "UTF-8");
			System.out.println("������ ���� �޽��� :" + message);
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
