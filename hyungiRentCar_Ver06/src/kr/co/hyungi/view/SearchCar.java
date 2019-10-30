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
	//렌트카 목록 날짜에 맞는 가격까지 보여주기
	public void carView(ArrayList<CarBean> cb, String inputDate) {
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ■■     조회 차량 결과         ■■");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┃(No)번호┃ 차량 번호 ┃ 차량 모델명                                      ┃ 차량 색상               ┃ 시간당 가격");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		for (int i = 0; i < cb.size(); i++) {
			System.out.print("┃ "+(i+1)+"\t");
			System.out.print("┃ "+cb.get(i).getCarNo()+"\t");
			System.out.printf("┃ %-25s\t",cb.get(i).getCarModel());
			System.out.printf("┃ %-6s\t ",cb.get(i).getCarColor());
			long calHour = new Rent().costCal(inputDate);
			System.out.print("┃ "+cb.get(i).getCostPerHour() * calHour+" 원\n");
		}System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public void carView(CarBean cb, String inputDate) {

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┃ 차량 모델명                                        ┃ 차량 색상               ┃ 가격");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("┃ %-25s\t",cb.getCarModel());
		System.out.printf("┃ %-6s\t ",cb.getCarColor());
		long calHour = new Rent().costCal(inputDate);
		System.out.print("┃ "+cb.getCostPerHour() * calHour+" 원\n");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	public void allView(ArrayList<CarBean> arCb) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┃(No)번호┃ 차량 번호 ┃ 차량 모델명                                      ┃ 차량 색상               ┃ 시간당 가격");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		for(int i=0;i<arCb.size();i++) {

			    System.out.print("┃ "+(i+1)+"\t");
				System.out.print("┃ "+arCb.get(i).getCarNo()+"\t");
				System.out.printf("┃ %-25s\t",arCb.get(i).getCarModel());
				System.out.printf("┃ %-6s\t ",arCb.get(i).getCarColor());
				System.out.print("┃ "+arCb.get(i).getCostPerHour()+" 원\n");
				}System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
	}

}
