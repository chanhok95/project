package kr.co.hyungi.view;

import java.util.ArrayList;

import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.domain.HistoryData;
import kr.co.hyungi.domain.MemberData;

public class AdminMember extends CommonMethod {

	
	SearchMember sm = new SearchMember();
	MemberData md = new MemberData();
	ArrayList<MemberBean> arMb = null;
	MemberBean mb= null;
	HistoryData hd = new HistoryData();
	
	public void member() {

		boolean adBool = true;
		while (adBool) {

			System.out.println();
			System.out.println("   [ 1 ] ȸ�� ��ȸ");
			System.out.println("   [ 2 ] ȸ�� �߰�");
			System.out.println("   [ 3 ] ȸ�� ����");
			System.out.println("   [ 4 ] ȸ�� ����");
			System.out.println("   [ x ] �� �ܰ�");
			System.out.println();

			String sel = inputMsg();
			if (sel.equals("1")) {
				viewMem();
			} else if (sel.equals("2")) {
				insMem();
			} else if (sel.equals("3")) {
				modMem();
			} else if (sel.equals("4")) {
				delMem();
			} else if (sel.equals("x")) {
				System.out.println("�� �ܰ�� �̵��մϴ�");
				adBool = false;
			}
		}
		System.out.println();
	}

	private void viewMem() {
		System.out.println();
		System.out.println(" ������������������������������������������������");
		System.out.println(" ������������������������������������������������");
		System.out.println(" ���     ȸ�� ��ü ��ȸ         ���");
		System.out.println(" ������������������������������������������������");
		System.out.println(" ������������������������������������������������");
		arMb=md.allData();
		sm.memberallView(arMb);
	}

	private void delMem() {
		while (true) {
			arMb=md.allData();
			sm.memberallView(arMb);
			String phoneNo = dPhoneNoInput();
			if(phoneNo.equals("x")) break;
			while (true) {
				String delMsg = delMsg();
				if (delMsg.equals("y")) {
					md.deleteMember(phoneNo);
					System.out.println("*****������ �Ϸ�Ǿ����ϴ�");
					pause(1.5);
					break;
				} else if (delMsg.equals("n")) {
					System.out.println("*****������ ��ҵǾ����ϴ�");
					pause(1.5);
					break;
				} else {
					System.out.println("�߸��� �Է��Դϴ�");
				}
			}
		break;
		}
	}

	private String delMsg() {
		System.out.println("������������������������������������������������������������������");
		System.out.println("��   ���� ���� �Ͻðڽ��ϱ�? ( y / n ) ");
		System.out.println("������������������������������������������������������������������");

		String delete = inputMsg();
		return delete;
	}

	private String dPhoneNoInput() {
		System.out.println("������ ȸ���� ��ȣ�� �Է����ּ���");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private void insMem() {
		while (true) {
			System.out.println("ȸ�� ������ �Է� �޴� �Դϴ�");
			System.out.println("=======================");
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			mb = md.getOneMember(phoneNo);
			if (mb != null) {
				System.out.println("�ش� ��ȣ�� �ִ� ����Դϴ�");
				break;
			}
				
			
			// 010 11�ڸ� �´��� Ȯ��
			String memName = memNameInput();
			if (memName.equals("x"))
				break;
			String licenseNo = licenseNoInput();
			if (licenseNo.equals("x"))
				break;
			// 10�ڸ� �������� Ȯ��

			md.insertMember(phoneNo, memName, licenseNo);
			break;
		}
	}

	private void modMem() {

		while (true) {
			System.out.println("ȸ�� ������ ���� �޴� �Դϴ�");
			System.out.println("# ");
			System.out.println("===================");
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			// 010 11�ڸ� �´��� Ȯ��
			MemberBean mb = md.getOneMember(phoneNo);
			if (mb != null) {

				String mPhoneNo = mPhoneNoInput();
				if (mPhoneNo.equals("x"))
					break;
				else if(mPhoneNo.equals(""))
					mPhoneNo = mb.getPhoneNo();
				if (!mPhoneNo.equals(mb.getPhoneNo())&&md.getOneMember(mPhoneNo)!=null) {
					System.out.println("�ش� ��ȣ�� �̹� ��ϵǾ��ֽ��ϴ�. �ٽ� Ȯ�����ּ���");
					break;
				}
				
				String mMemName = mMemNameInput();
				if (mMemName.equals("x"))
					break;
				String mLicenseNo = mLicenseNoInput();
				if (mLicenseNo.equals("x"))
					break;
				// enteró��
//			if (mMemName.equals("")) {
//				if (mLicenseNo.equals("")) {
//				}else {
//					md.modifyMember(phoneNo, mMemName, mLicenseNo);
//				}
//			}else {
//				if (mLicenseNo.equals("")) {
//					mLicenseNo = mb.getLicenseNo();
//					md.modifyMember(phoneNo, mMemName, mLicenseNo);
//				}else {
//				}
//			}

				if (mPhoneNo.equals(mb.getPhoneNo())&&mMemName.equals("") && mLicenseNo.equals("")) {
					System.out.println("���泻���� �����ϴ�");
				} else {
					
					if (mMemName.equals(""))
						mMemName = mb.getMemName();
					if (mLicenseNo.equals(""))
						mLicenseNo = mb.getLicenseNo();

					md.modifyMember(phoneNo, mPhoneNo, mMemName, mLicenseNo);
					hd.modHistory(phoneNo, mPhoneNo, mLicenseNo);
					
				}

			} else
				System.out.println("ȸ�������� �����ϴ�");
		break;
		}
	}

	private String mPhoneNoInput() {
		System.out.println("ȸ�������Դϴ�. �����Է��̷��� enter");
		String phoneNo = modPhoneNoInput();
		return phoneNo;
	}

	private String mLicenseNoInput() {
		System.out.println("ȸ�������Դϴ�. �����Է��̷��� enter");
		String licenseNo = modLicenseNoInput();
		return licenseNo;
	}

	private String mMemNameInput() {
		System.out.println("ȸ�������Դϴ�. �����Է��̷��� enter");
		String memName = modMemNameInput();
		return memName;
	}
}
