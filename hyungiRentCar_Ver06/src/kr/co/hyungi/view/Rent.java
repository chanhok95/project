package kr.co.hyungi.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.CarData;
import kr.co.hyungi.domain.HistoryData;
import kr.co.hyungi.domain.MemberData;

public class Rent extends CommonMethod {

	MemberData md = new MemberData();
	CarData cd = new CarData();
	HistoryData hd = new HistoryData();
	SearchCar sc = new SearchCar();
	SearchHistory sh = new SearchHistory();
	MemberBean mb = null;
	CarBean cb = null;
	ArrayList<CarBean> arCb = null;
	UsageHistoryBean uhb = null;
	ArrayList<UsageHistoryBean> arUhb = null;

	public void rent() { // 渠罹
		System.out.println();
		System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
	    System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\    ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\  早");
	    System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\    ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\  早");
	    System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
	    System.out.println();

		while (true) {
			String phoneNo = phoneNoInput();// ア廓�� 殮溘嫡晦
			if (phoneNo.equals("x"))
				break;
			boolean isMember = md.isMember(phoneNo);// �蛾衋恔� �挫恉炱�

			String licenseNo = null;
			String dateInput = null;
			if (isMember) {
				// �蛾衋抶� 陳瞼殮溘虜
				licenseNo = md.getLicenseNo(phoneNo);
			} else {
				// 綠�蛾衋抶� 賊ъ廓��, 陳瞼殮溘 萃棻
				licenseNo = licenseNoInput();
				if (licenseNo.equals("x"))
					break;
			}
			dateInput = dateInputInput();
			if (dateInput.equals("x"))
				break;

			String carRowNum = null;
			String carNo = null;
			// 離 跡煙 爾罹輿晦
			arCb = cd.getAvailableCar(dateInput);
			sc.carView(arCb, dateInput);

			// 離堅腦晦
			carRowNum = carRowNumInput();
			if (carRowNum.equals("x"))
				break;
			carNo = cd.getCarNo(carRowNum, dateInput);
			if (carNo == null) {
				System.out.println("廓�ㄧ� 澀跤 殮溘ж樟蝗棲棻. 棻衛 �挫恉媮祤撚�");
				break;
			}
			cb = cd.getOneCar(carNo);

			while (true) {
				sh.paymentView(dateInput, cb);
				String yesOrNo = yesOrNoInput(); // 唸薯ж衛啊蝗棲梱 y/n?

				if (yesOrNo.equals("y")) {
					// 高盪濰
					hd.payment(dateInput, cb, phoneNo, licenseNo);
					System.out.println("唸薯腎樟蝗棲棻.");
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("唸薯蒂 鏃模ж樟蝗棲棻.");
					break;
				} else {
					System.out.println("澀跤殮溘ж樟蝗棲棻.");
				}
			}
			break;
		}
	}

	public long costCal(String inputDate) {

		String strDate = inputDate.split("-")[0];
		String endDate = inputDate.split("-")[1];
		long calHour = 0;
		SimpleDateFormat format = new SimpleDateFormat("MMddHH");
		Date sd = null;
		Date ed = null;
		try {
			sd = format.parse(strDate);
			ed = format.parse(endDate);

			calHour = (ed.getTime() - sd.getTime()) / 1000 / 60 / 60;

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return calHour;
	}

	public void rentReturn() {
		System.out.println();
        System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
        System.out.println("早   ﹥﹥﹥\\\\  ﹥﹥﹥\\\\   ﹥﹥﹥\\\\     ﹥﹥﹥\\\\            ﹥﹥﹥\\\\     早");
        System.out.println("早   ﹥﹥﹥\\\\  ﹥﹥﹥\\\\   ﹥﹥﹥\\\\     ﹥﹥﹥\\\\            ﹥﹥﹥\\\\     早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥﹥\\\\ ﹥﹥﹥\\\\            ﹥﹥﹥﹥﹥﹥﹥\\\\ 早");
        System.out.println("早   ﹥﹥﹥\\\\  ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥﹥\\\\ ﹥﹥﹥\\\\            ﹥﹥﹥﹥﹥﹥﹥\\\\ 早");
        System.out.println("早   ﹥﹥﹥\\\\  ﹥﹥﹥\\\\   ﹥﹥﹥\\\\     ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\     早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\     ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\     早");
        System.out.println("早                                                       早");
        System.out.println("早      ﹥﹥﹥﹥\\\\                   ﹥﹥﹥\\\\        ﹥﹥﹥\\\\      早");
        System.out.println("早      ﹥﹥﹥﹥\\\\                   ﹥﹥﹥\\\\        ﹥﹥﹥\\\\      早");
        System.out.println("早      ﹥﹥﹥﹥\\\\                   ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      早");
        System.out.println("早      ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\        ﹥﹥﹥\\\\      早");
        System.out.println("早      ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      早");
        System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
        System.out.println();
		while (true) {
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = null;

			arUhb = hd.getHistoryReturn(phoneNo);
			if(arUhb.isEmpty()) {
				System.out.println("蕨擒頂羲檜 橈蝗棲棻. 棻衛 �挫恉媮祤撚�");
				break;
			}
			sh.historyView(arUhb);
			

			String historyRowNum = rHistoryRowNumInput(); // 蕨擒廓�� 殮溘
			if (historyRowNum.equals("x"))
				break;
			String rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			if (rentNo == null) {
				System.out.println("蕨擒廓�� 殮溘檜 澀跤腎歷蝗棲棻. 棻衛 �挫恉媮祤撚�");
				break;
			} else {
				uhb = hd.getOneHistory(rentNo);
			}
			while (true) {
				sh.historyView(uhb);
				String yesOrNo = returnYesOrNoInput(); // 奩陶ж衛啊蝗棲梱 y/n?

				if (yesOrNo.equals("y")) {
					// 高盪濰
					hd.returnHistory(rentNo);
					System.out.println("奩陶腎歷蝗棲棻.");
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("奩陶擊 鏃模ж樟蝗棲棻.");
					break;
				} else {
					System.out.println("澀跤殮溘ж樟蝗棲棻.");
				}
			}
		}
	}

	private String rHistoryRowNumInput() {
		System.out.print("奩陶ж堅濠 ж朝 ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

	public void rentCancel() {
		System.out.println();
        System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\\t        ﹥﹥﹥﹥\\\\        ﹥﹥﹥\\\\       ﹥﹥﹥﹥\\\\        早" );
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\\t     ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\     ﹥﹥﹥\\\\     ﹥﹥﹥\\\\﹥﹥﹥\\\\      早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t       ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\   ﹥﹥﹥\\\\    ﹥﹥﹥\\\\    早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t    ﹥﹥﹥﹥\\\\  ﹥﹥﹥﹥\\\\    ﹥﹥﹥\\\\  ﹥﹥﹥\\\\      ﹥﹥﹥\\\\   早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\\t  ﹥﹥﹥﹥\\\\      ﹥﹥﹥﹥\\\\  ﹥﹥﹥\\\\ ﹥﹥﹥\\\\        ﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\\t                      ﹥﹥﹥\\\\                     早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\﹥﹥﹥\\\\       ﹥﹥﹥﹥\\\\        早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\﹥﹥﹥\\\\       ﹥﹥﹥﹥\\\\        早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\\t         ﹥﹥﹥\\\\        ﹥﹥﹥\\\\﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\ 早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\\t         ﹥﹥﹥\\\\        ﹥﹥﹥\\\\﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\ 早");
        System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
        System.out.println();
		while (true) {
			String phoneNo = cPhoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = hd.getCurrentHistory(phoneNo);

			if (arUhb.isEmpty()) {
				System.out.println("蕨擒頂羲檜 橈蝗棲棻.");
				System.out.println("棻衛 殮溘п輿撮蹂.");
			} else {
				sh.historyView(arUhb);
				// 蕨擒廓�� 摹鷗
				String historyRowNum = historyRowNumInput();
				if (historyRowNum.equals("x"))
					break;
				String rentNo = hd.getRentNo(historyRowNum, phoneNo);
				if (rentNo == null) {
					System.out.println("蕨擒廓�� 殮溘檜 澀跤腎歷蝗棲棻. 棻衛 �挫恉媮祤撚�");
					break;
				} else {
					uhb = hd.getOneHistory(rentNo);
				}
				while (true) {
					sh.historyView(uhb);
					String yesOrNo = delYesOrNoInput(); // 餉薯ж衛啊蝗棲梱 y/n?

					if (yesOrNo.equals("y")) {
						hd.delHistory(rentNo);
						System.out.println("渠罹鏃模腎歷蝗棲棻.");
						break;
					} else if (yesOrNo.equals("n")) {
						System.out.println("渠罹鏃模蒂 鏃模ж樟蝗棲棻.");
						break;
					} else {
						System.out.println("澀跤殮溘ж樟蝗棲棻.");
					}
				}
			}
			break;
		}
	}

	private String cPhoneNoInput() {
		System.out.println("鏃模ж堅濠 ж朝");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private String delYesOrNoInput() {
		System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
		System.out.println("早   餉薯 ж衛啊蝗棲梱? ( y / n ) ");
		System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	private String returnYesOrNoInput() {
		System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
		System.out.println("早   奩陶 ж衛啊蝗棲梱? ( y / n ) ");
		System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	public void rentModify() {
		System.out.println();
        System.out.println("旨收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旬");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\\t       ﹥﹥﹥﹥\\\\       ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\    ﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\\t     ﹥﹥﹥\\\\﹥﹥﹥\\\\           ﹥﹥﹥﹥\\\\     ﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t   ﹥﹥﹥\\\\   ﹥﹥﹥\\\\         ﹥﹥﹥\\\\    ﹥﹥﹥﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\      ﹥﹥﹥﹥\\\\     ﹥﹥﹥﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\\t ﹥﹥﹥\\\\       ﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\     ﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\     ﹥﹥﹥\\\\\t                   ﹥﹥﹥\\\\     ﹥﹥﹥\\\\   ﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\     早");
        System.out.println("早   ﹥﹥\\\\         ﹥﹥﹥\\\\ ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥\\\\\t﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥﹥\\\\       ﹥﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\  ﹥﹥﹥﹥﹥﹥﹥﹥\\\\      ﹥﹥﹥\\\\\t       ﹥﹥﹥﹥\\\\          ﹥﹥﹥﹥\\\\       ﹥﹥﹥﹥\\\\  早");
        System.out.println("早   ﹥﹥﹥﹥﹥﹥﹥﹥\\\\   ﹥﹥﹥\\\\ ﹥﹥﹥\\\\   ﹥﹥﹥﹥﹥﹥\\\\       ﹥﹥﹥\\\\\t       ﹥﹥﹥﹥\\\\            ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥\\\\     早");
        System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
        System.out.println();

		boolean rentModBool = true;
		while (rentModBool) {
			// ア廓��殮溘
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			// 廓�ˋ� 蜃朝 蕨擒跡煙 陛螳螃晦
			arUhb = hd.getHistoryReturn(phoneNo);
			if (arUhb.isEmpty()) {
				System.out.println("п渡 廓�ㄣ� 蕨擒頂羲檜 橈蝗棲棻. 棻衛 �挫恉媮祤撚�");
				break;
			}
			// 蕨擒跡煙爾罹輿晦
			sh.historyView(arUhb);
			// 熱薑 蕨擒廓�� 殮溘嫡堅 п渡 跡煙 乾晦
			String historyRowNum = null;
			historyRowNum = mHistoryRowNumInput(); // 蕨擒廓�� 殮溘
			if (historyRowNum.equals("x")) {
				break;
			}

			String rentNo = null;
			rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			if (rentNo == null) {
				System.out.println("廓�ㄧ� 澀跤殮溘ж樟蝗棲棻. 棻衛 �挫恉媮祤撚�");
				break;
			}
			if (historyRowNum.equals("x"))
				break;
			uhb = hd.getOneHistory(rentNo);

			// 熱薑陳瞼 殮溘
			String mDateInput = mDateInputInput();
			if (mDateInput.equals("x"))
				break;
			if (mDateInput.equals("")) {
				mDateInput = uhb.getRentStartDate() + "-" + uhb.getRentEndDate();
			}

			// 熱薑й 蕨擒曖 離 廓�� 陛螳螃晦
			String carNo = Integer.toString(uhb.getCarNo());

			// 離榆 爾罹輿晦->濠褐曖 蕨擒擎 橈朝 匙籀歲 離蒂 爾罹邀
			arCb = cd.modAvailableCar(rentNo, mDateInput);

			sc.carView(arCb, mDateInput);

				// 熱薑 離榆 殮溘
				String carRowNum = enterCarRowNumInput();
				if (carRowNum.equals("x"))
					break;
				if (!carRowNum.equals("")) {
					carNo = cd.getCarNo(carRowNum, mDateInput);
					cb = cd.getOneCar(carNo);
					if (carNo != null)
						break;
				} else {
					cb = cd.getOneCar(carNo);
				}
				// 離 殮溘梱雖 嫡懊堅 晦襄離檣雖 億煎 摹鷗и勒雖紫 薑п螺啻
			System.out.println(carNo);
			// п撿腆勒 晦襄離橾 唳辦 陛棟и雖虜 綠掖п醜撿л.
			// п渡 離 噩 熱 氈戲賊 enterOk true
			if (!cd.enterOk(rentNo, carNo, mDateInput)) {
				System.out.println("滲唳й 陳瞼縑朝 п渡 離蒂 檜辨й 熱 橈蝗棲棻");
			} else {
				if(mDateInput.equals(uhb.getRentStartDate() + "-" + uhb.getRentEndDate()) && carNo.equals( Integer.toString( uhb.getCarNo() ) ) ){
					System.out.println("滲唳餌о檜 橈蝗棲棻");
					break;
				}
				hd.delHistory(rentNo);
				hd.payment(mDateInput, cb, phoneNo, uhb.getLicenseNo());
			}
			break;
		}
	}

	private String mDateInputInput() {
		System.out.print("熱薑ж堅濠 ж朝 ");
		String mDateInput = enterDateInput();
		return mDateInput;
	}

	private String mHistoryRowNumInput() {
		System.out.print("熱薑ж堅濠 ж朝 ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

}
