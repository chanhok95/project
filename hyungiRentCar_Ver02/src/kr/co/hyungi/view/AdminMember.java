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
			System.out.println("===1. 회원조회==========");
			System.out.println("===2. 회원추가==========");
			System.out.println("===3. 회원수정==========");
			System.out.println("===4. 회원삭제==========");
			System.out.println("---x. 전 단계-----------");
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
				System.out.println("전 단계로 이동합니다");
				adBool = false;
			}
		}
		System.out.println();
	}

	private void viewMem() {
		System.out.println("회원 전체 조회");
		md.allData();
	}

	private void delMem() {

		String phoneNo = dPhoneNoInput();

		while (true) {
			String delMsg = delMsg();
			if (delMsg.equals("y")) {
				md.deleteMember(phoneNo);
				System.out.println("*****삭제가 완료되었습니다");
				pause(1.5);
				break;
			} else if (delMsg.equals("n")) {
				System.out.println("*****삭제가 취소되었습니다");
				pause(1.5);
				break;
			} else {
				System.out.println("잘못된 입력입니다");
			}
		}

	}

	private String delMsg() {
		System.out.println("***********************************************");
		System.out.println("******정말 삭제하시겠습니까?(y/n)*****************************************");
		System.out.println("***********************************************");

		String delete = inputMsg();
		return delete;
	}

	private String dPhoneNoInput() {
		System.out.println("삭제할 회원의 번호를 입력해주세요");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private void insMem() {
		System.out.println("회원 데이터 입력 메뉴 입니다");
		System.out.println("=======================");
		String phoneNo = phoneNoInput();
		// 010 11자리 맞는지 확인
		String memName = memNameInput();
		String licenseNo = licenseNoInput();
		// 10자리 숫자인지 확인

		md.insertMember(phoneNo, memName, licenseNo);

	}

	private void modMem() {

		System.out.println("회원 데이터 수정 메뉴 입니다");
		System.out.println("# 회원 핸드폰번호는 수정불가");
		System.out.println("===================");
		String phoneNo = phoneNoInput();
		// 010 11자리 맞는지 확인
		MemberBean mb = md.getOneMember(phoneNo);
		if (mb != null) {

			String mMemName = mMemNameInput();
			String mLicenseNo = mLicenseNoInput();

			// enter처리
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
				System.out.println("변경내역이 없습니다");
			} else {

				if (mMemName.equals(""))
					mMemName = mb.getMemName();
				if (mLicenseNo.equals(""))
					mLicenseNo = mb.getLicenseNo();

				md.modifyMember(phoneNo, mMemName, mLicenseNo);
			}

		} else
			System.out.println("회원정보가 없습니다");
	}

	private String mLicenseNoInput() {
		System.out.println("회원수정입니다. 기존입력이려면 enter");
		String licenseNo = licenseNoInput();
		return licenseNo;
	}

	private String mMemNameInput() {
		System.out.println("회원수정입니다. 기존입력이려면 enter");
		String memName = memNameInput();
		return memName;
	}
}
