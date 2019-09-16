package kr.co.kil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IomainRun {
	public static void main(String[] args) {

		// ���ϻ���
		File file = new File("c:/Test/Hello.txt");
		File file2 = new File("c:/Test/Hello2.txt");

		if (!file.exists()) {
			// ! = ������ ������ ���� ����
			try {
				System.out.println("����1 ����");
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!file2.exists())
			;
		try {
			System.out.println("����2 ����");
			file2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �ܺ� ���� �о����
		FileInputStream fis = null;
		// �ܺ� ���� �����ϱ�
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int data = 0;
		byte[] readBytes = new byte[100];
		try {
			while ((data = fis.read(readBytes)) != -1) {
		//		System.out.write(data);
				fos.write(readBytes,0,data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				fos.flush(); 
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	}

}