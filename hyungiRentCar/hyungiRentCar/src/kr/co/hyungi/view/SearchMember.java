package kr.co.hyungi.view;

import java.util.List;

import kr.co.hyungi.beans.MemberBean;

public class SearchMember {
	public void memView(List<MemberBean> mb) {
		System.out.println("------------");
		System.out.println("��ȸ��� ");
		System.out.println("-------------");
		for(int i=0; i<mb.size(); i++) {
			System.out.println("NO :"+ (i+1));
			System.out.println("�ڵ�����ȣ:" + mb.get(i).getPhoneNo());
			System.out.println("ȸ����:"+mb.get(i).getMemName());
			System.out.println("���������ȣ:"+mb.get(i).getLicenseNo());
		}

	}
}
