package kr.co.hyungi.view;

import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.domain.MemberData;

public class AdminMember extends CommonMethod {

	MemberData md = new MemberData();
	MemberBean mb = null;
	public void member() {

		boolean adBool = true;
		while (adBool) {

			System.out.println();
			System.out.println("======================");
			System.out.println("===1. ȸ����ȸ==========");
			System.out.println("===2. ȸ���߰�==========");
			System.out.println("===3. ȸ������==========");
			System.out.println("===4. ȸ������==========");
			System.out.println("---x. �� �ܰ�-----------");
			System.out.println("======================");

			String sel = inputMsg();
			if(sel.equals("1")){
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
		System.out.println("ȸ�� ��ü ��ȸ");
		md.allData();
	}

	private void delMem() {

		String phoneNo = dPhoneNoInput();

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

	}

	private String delMsg() {
		System.out.println("***********************************************");
		System.out.println("******���� �����Ͻðڽ��ϱ�?(y/n)*****************************************");
		System.out.println("***********************************************");

		String delete = inputMsg();
		return delete;
	}

	private String dPhoneNoInput() {
		System.out.println("������ ȸ���� ��ȣ�� �Է����ּ���");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private void insMem() {
		System.out.println("ȸ�� ������ �Է� �޴� �Դϴ�");
		System.out.println("=======================");
		String phoneNo = phoneNoInput();
		// 010 11�ڸ� �´��� Ȯ��
		String memName = memNameInput();
		String licenseNo = licenseNoInput();
		// 10�ڸ� �������� Ȯ��

		md.insertMember(phoneNo, memName, licenseNo);

	}

	private void modMem() {

		System.out.println("ȸ�� ������ ���� �޴� �Դϴ�");
		System.out.println("# ȸ�� �ڵ�����ȣ�� �����Ұ�");
		System.out.println("===================");
		String phoneNo = phoneNoInput();
		// 010 11�ڸ� �´��� Ȯ��
		MemberBean mb = md.getOneMember(phoneNo);
		if (mb != null) {

			String mMemName = mMemNameInput();
			String mLicenseNo = mLicenseNoInput();

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

			if (mMemName.equals("") && mLicenseNo.equals("")) {
				System.out.println("���泻���� �����ϴ�");
			} else {

				if (mMemName.equals(""))
					mMemName = mb.getMemName();
				if (mLicenseNo.equals(""))
					mLicenseNo = mb.getLicenseNo();

				md.modifyMember(phoneNo, mMemName, mLicenseNo);
			}

		} else
			System.out.println("ȸ�������� �����ϴ�");
	}

	private String mLicenseNoInput() {
		System.out.println("ȸ�������Դϴ�. �����Է��̷��� enter");
		String licenseNo = licenseNoInput();
		return licenseNo;
	}

	private String mMemNameInput() {
		System.out.println("ȸ�������Դϴ�. �����Է��̷��� enter");
		String memName = memNameInput();
		return memName;
	}
}
