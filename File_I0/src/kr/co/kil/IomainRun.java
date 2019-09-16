package kr.co.kil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IomainRun {
	public static void main(String[] args) {

		// 파일생성
		File file = new File("c:/Test/Hello.txt");
		File file2 = new File("c:/Test/Hello2.txt");

		if (!file.exists()) {
			// ! = 파일이 없으면 파일 생성
			try {
				System.out.println("파일1 생성");
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!file2.exists())
			;
		try {
			System.out.println("파일2 생성");
			file2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 외부 파일 읽어오기
		FileInputStream fis = null;
		// 외부 파일 전달하기
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