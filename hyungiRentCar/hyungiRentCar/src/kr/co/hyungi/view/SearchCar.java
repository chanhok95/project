package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.CarBean;



public class SearchCar {

	public void carView(List<CarBean> cv) {

		System.out.println("조회하신 차량결과");
		System.out.println("=============");
		for (int i = 0; i < cv.size(); i++) {
			System.out.println("차번호:"  + cv.get(i).getCarNo()); 
			System.out.println("차색깔:" + cv.get(i).getCarColor());
			System.out.println("차모델명:" +  cv.get(i).getCarModel());
			System.out.println("대여비용(시간당):" +  cv.get(i).getCostPerHour());

			
		}
	}

}
