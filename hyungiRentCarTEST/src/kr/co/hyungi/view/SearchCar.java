package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.CarBean;

public class SearchCar extends CommonMethod {

	public void carView(ArrayList<CarBean> cb) {

		System.out.println("��ȸ�Ͻ� �������");
		System.out.println("=============");
		for (int i = 0; i < cb.size(); i++) {
			System.out.println("No(��ȣ):" + (i + 1));
			System.out.println("����ȣ:" + cb.get(i).getCarNo());
			System.out.println("������:" + cb.get(i).getCarColor());
			System.out.println("���𵨸�:" + cb.get(i).getCarModel());
			System.out.println("�ð��� ����:" + cb.get(i).getCostPerHour());
		}
	}
	//��Ʈī ��� ��¥�� �´� ���ݱ��� �����ֱ�
	public void carView(ArrayList<CarBean> cb, String inputDate) {
		System.out.println(" ������������������������������������������������");
		System.out.println(" ������������������������������������������������");
		System.out.println(" ���     ��ȸ ���� ���         ���");
		System.out.println(" ������������������������������������������������");
		System.out.println(" ������������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��(No)��ȣ�� ���� ��ȣ �� ���� �𵨸�                                      �� ���� ����               �� �ð��� ����");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < cb.size(); i++) {
			System.out.print("�� "+(i+1)+"\t");
			System.out.print("�� "+cb.get(i).getCarNo()+"\t");
			System.out.printf("�� %-25s\t",cb.get(i).getCarModel());
			System.out.printf("�� %-6s\t ",cb.get(i).getCarColor());
			long calHour = new Rent().costCal(inputDate);
			System.out.print("�� "+cb.get(i).getCostPerHour() * calHour+" ��\n");
		}System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public void carView(CarBean cb, String inputDate) {

		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� ���� �𵨸�                                        �� ���� ����               �� ����");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf("�� %-25s\t",cb.getCarModel());
		System.out.printf("�� %-6s\t ",cb.getCarColor());
		long calHour = new Rent().costCal(inputDate);
		System.out.print("�� "+cb.getCostPerHour() * calHour+" ��\n");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public void allView(ArrayList<CarBean> arCb) {
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��(No)��ȣ�� ���� ��ȣ �� ���� �𵨸�                                      �� ���� ����               �� �ð��� ����");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		
		for(int i=0;i<arCb.size();i++) {

			    System.out.print("�� "+(i+1)+"\t");
				System.out.print("�� "+arCb.get(i).getCarNo()+"\t");
				System.out.printf("�� %-25s\t",arCb.get(i).getCarModel());
				System.out.printf("�� %-6s\t ",arCb.get(i).getCarColor());
				System.out.print("�� "+arCb.get(i).getCostPerHour()+" ��\n");
				}System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		
	}

}
