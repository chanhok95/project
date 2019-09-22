package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.CarBean;



public class SearchCar {

	public void all_View(List<CarBean> ar_cb) {

		System.out.println("조회하신 차량결과");
		System.out.println("=============");
		System.out.println(ar_cb.size()); 
		for (int i = 0; i < ar_cb.size(); i++) {
			System.out.println((i + 1) + "번째 사원정보");
			System.out.println("차번호:" + "+" + ar_cb.get(i).getCarNo()); 
			System.out.println("차색깔:" + "+" + ar_cb.get(i).getCarColor());
			System.out.println("차모델명:" + "+" + ar_cb.get(i).getCarModel());
			System.out.println("대여비용(시간당):" + "+" + ar_cb.get(i).getCostPerHour());

			
		}
		
	}

}
