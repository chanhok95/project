package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.MemberBean;

public class SearchMember {
	public void memView(List<MemberBean> mb) {
		System.out.println("------------");
		System.out.println("조회결과 ");
		System.out.println("-------------");
		for(int i=0; i<mb.size(); i++) {
			System.out.println("NO :"+ (i+1));
			System.out.println("핸드폰번호:" + mb.get(i).getPhoneNo());
			System.out.println("회원명:"+mb.get(i).getMemName());
			System.out.println("운전면허번호:"+mb.get(i).getLicenseNo());
		}

	}
}
