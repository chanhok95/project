package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.MemberBean;

public class SearchMember extends CommonMethod {
	public void memberallView(ArrayList<MemberBean> arMb) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┃폰 번호                 ┃ 면허 번호               ┃ 이름                                     ");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		for(int i=0;i<arMb.size();i++) {
			System.out.printf("┃ %-6s\t",arMb.get(i).getPhoneNo());
			System.out.printf("┃ %-6s\t ",arMb.get(i).getLicenseNo());
			System.out.print("┃ "+arMb.get(i).getMemName()+"\n");
			
		}System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
}
