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
			System.out.println("   [ 1 ] 회원 조회");
			System.out.println("   [ 2 ] 회원 추가");
			System.out.println("   [ 3 ] 회원 수정");
			System.out.println("   [ 4 ] 회원 삭제");
			System.out.println("   [ x ] 전 단계");
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
				System.out.println("전 단계로 이동합니다");
				adBool = false;
			}
		}
		System.out.println();
	}

	private void viewMem() {
		System.out.println();
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ■■     회원 전체 조회         ■■");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━");
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
		break;
		}
	}

	private String delMsg() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   정말 삭제 하시겠습니까? ( y / n ) ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		String delete = inputMsg();
		return delete;
	}

	private String dPhoneNoInput() {
		System.out.println("삭제할 회원의 번호를 입력해주세요");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private void insMem() {
		while (true) {
			System.out.println("회원 데이터 입력 메뉴 입니다");
			System.out.println("=======================");
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			mb = md.getOneMember(phoneNo);
			if (mb != null) {
				System.out.println("해당 번호는 있는 멤버입니다");
				break;
			}
				
			
			// 010 11자리 맞는지 확인
			String memName = memNameInput();
			if (memName.equals("x"))
				break;
			String licenseNo = licenseNoInput();
			if (licenseNo.equals("x"))
				break;
			// 10자리 숫자인지 확인

			md.insertMember(phoneNo, memName, licenseNo);
			break;
		}
	}

	private void modMem() {

		while (true) {
			System.out.println("회원 데이터 수정 메뉴 입니다");
			System.out.println("# ");
			System.out.println("===================");
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			// 010 11자리 맞는지 확인
			MemberBean mb = md.getOneMember(phoneNo);
			if (mb != null) {

				String mPhoneNo = mPhoneNoInput();
				if (mPhoneNo.equals("x"))
					break;
				else if(mPhoneNo.equals(""))
					mPhoneNo = mb.getPhoneNo();
				if (!mPhoneNo.equals(mb.getPhoneNo())&&md.getOneMember(mPhoneNo)!=null) {
					System.out.println("해당 번호는 이미 등록되어있습니다. 다시 확인해주세요");
					break;
				}
				
				String mMemName = mMemNameInput();
				if (mMemName.equals("x"))
					break;
				String mLicenseNo = mLicenseNoInput();
				if (mLicenseNo.equals("x"))
					break;
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

				if (mPhoneNo.equals(mb.getPhoneNo())&&mMemName.equals("") && mLicenseNo.equals("")) {
					System.out.println("변경내역이 없습니다");
				} else {
					
					if (mMemName.equals(""))
						mMemName = mb.getMemName();
					if (mLicenseNo.equals(""))
						mLicenseNo = mb.getLicenseNo();

					md.modifyMember(phoneNo, mPhoneNo, mMemName, mLicenseNo);
					hd.modHistory(phoneNo, mPhoneNo, mLicenseNo);
					
				}

			} else
				System.out.println("회원정보가 없습니다");
		break;
		}
	}

	private String mPhoneNoInput() {
		System.out.println("회원수정입니다. 기존입력이려면 enter");
		String phoneNo = modPhoneNoInput();
		return phoneNo;
	}

	private String mLicenseNoInput() {
		System.out.println("회원수정입니다. 기존입력이려면 enter");
		String licenseNo = modLicenseNoInput();
		return licenseNo;
	}

	private String mMemNameInput() {
		System.out.println("회원수정입니다. 기존입력이려면 enter");
		String memName = modMemNameInput();
		return memName;
	}
}
