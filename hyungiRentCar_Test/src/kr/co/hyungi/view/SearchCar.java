package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.CarBean;

public class SearchCar extends CommonMethod {

	public void carView(ArrayList<CarBean> cb) {

		System.out.println("조회하신 차량결과");
		System.out.println("=============");
		for (int i = 0; i < cb.size(); i++) {
			System.out.println("No(번호):" + (i + 1));
			System.out.println("차번호:" + cb.get(i).getCarNo());
			System.out.println("차색깔:" + cb.get(i).getCarColor());
			System.out.println("차모델명:" + cb.get(i).getCarModel());
			System.out.println("시간당 가격:" + cb.get(i).getCostPerHour());
		}
	}

	public void carView(ArrayList<CarBean> cb, String inputDate) {

		System.out.println("조회하신 차량결과");
		System.out.println("=============");
		for (int i = 0; i < cb.size(); i++) {
			System.out.println("No(번호):" + (i + 1));
			System.out.println("차번호:" + cb.get(i).getCarNo());
			System.out.println("차색깔:" + cb.get(i).getCarColor());
			System.out.println("차모델명:" + cb.get(i).getCarModel());

			long calHour = new Rent().costCal(inputDate);
			System.out.println("가격:" + cb.get(i).getCostPerHour() * calHour);
			System.out.println("********************************************");
		}
	}

	public void carView(CarBean cb, String inputDate) {

		System.out.println("=============");
		System.out.println("차색깔:" + cb.getCarColor());
		System.out.println("차모델명:" + cb.getCarModel());
		long calHour = new Rent().costCal(inputDate);
		System.out.println("가격:" + cb.getCostPerHour() * calHour);
		System.out.println("********************************************");
	}

	public void allView(ArrayList<CarBean> arCb) {
		for(int i=0;i<arCb.size();i++) {
				System.out.println("**********************");
				System.out.println("*****No." + (i+1)+"******");
				System.out.println("**********************");
				System.out.println("*****" + arCb.get(i).getCarNo()+"******");
				System.out.println("*****" + arCb.get(i).getCarModel());
				System.out.println("*****" + arCb.get(i).getCarColor());
				System.out.println("*****" + arCb.get(i).getCostPerHour());
				System.out.println("**********************");
				System.out.println("**********************");
		}
	}

}
