package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.CarBean;



public class SearchCar {

	public void carView(List<CarBean> cv) {

		System.out.println("��ȸ�Ͻ� �������");
		System.out.println("=============");
		for (int i = 0; i < cv.size(); i++) {
			System.out.println("����ȣ:"  + cv.get(i).getCarNo()); 
			System.out.println("������:" + cv.get(i).getCarColor());
			System.out.println("���𵨸�:" +  cv.get(i).getCarModel());
			System.out.println("�뿩���(�ð���):" +  cv.get(i).getCostPerHour());

			
		}
	}

}
