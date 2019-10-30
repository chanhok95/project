package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.MemberBean;

public class SearchMember extends CommonMethod {
	public void memberallView(ArrayList<MemberBean> arMb) {
		for(int i=0;i<arMb.size();i++) {
			System.out.println("**********************");
			System.out.println("*****No." + (i+1)+"******");
			System.out.println("**********************");
			System.out.println("*****" + arMb.get(i).getPhoneNo()+"******");
			System.out.println("*****" + arMb.get(i).getMemName());
			System.out.println("*****" + arMb.get(i).getLicenseNo());
			System.out.println("**********************");
			System.out.println("**********************");
		}
	}
}
