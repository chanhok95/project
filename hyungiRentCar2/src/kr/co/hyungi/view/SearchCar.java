package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.CarBean;



public class SearchCar {

	public void all_View(List<CarBean> ar_cb) {

		System.out.println("��ȸ�Ͻ� �������");
		System.out.println("=============");
		System.out.println(ar_cb.size()); 
		for (int i = 0; i < ar_cb.size(); i++) {
			System.out.println((i + 1) + "��° �������");
			System.out.println("����ȣ:" + "+" + ar_cb.get(i).getCarNo()); 
			System.out.println("������:" + "+" + ar_cb.get(i).getCarColor());
			System.out.println("���𵨸�:" + "+" + ar_cb.get(i).getCarModel());
			System.out.println("�뿩���(�ð���):" + "+" + ar_cb.get(i).getCostPerHour());

			
		}
		
	}

}
