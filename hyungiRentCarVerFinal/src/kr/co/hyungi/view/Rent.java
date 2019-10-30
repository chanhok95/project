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

	public void rent() { // ´ë¿©
		System.out.println();
		System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
	    System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\    ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\    ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\  ¦­");
	    System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
	    System.out.println();

		while (true) {
			String phoneNo = phoneNoInput();// Æù¹øÈ£ ÀÔ·Â¹Þ±â
			if (phoneNo.equals("x"))
				break;
			boolean isMember = md.isMember(phoneNo);// È¸¿øÀÎÁö È®ÀÎÇÏ±â

			String licenseNo = null;
			String dateInput = null;
			if (isMember) {
				// È¸¿øÀÌ¸é ³¯Â¥ÀÔ·Â¸¸
				licenseNo = md.getLicenseNo(phoneNo);
			} else {
				// ºñÈ¸¿øÀÌ¸é ¸éÇã¹øÈ£, ³¯Â¥ÀÔ·Â µÑ´Ù
				licenseNo = licenseNoInput();
				if (licenseNo.equals("x"))
					break;
			}
			dateInput = dateInputInput();
			if (dateInput.equals("x"))
				break;

			String carRowNum = null;
			String carNo = null;
			// Â÷ ¸ñ·Ï º¸¿©ÁÖ±â
			arCb = cd.getAvailableCar(dateInput);
			sc.carView(arCb, dateInput);

			// Â÷°í¸£±â
			carRowNum = carRowNumInput();
			if (carRowNum.equals("x"))
				break;
			carNo = cd.getCarNo(carRowNum, dateInput);
			if (carNo == null) {
				System.out.println("¹øÈ£¸¦ Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
				pause(1.5);
				break;
			}
			cb = cd.getOneCar(carNo);

			while (true) {
				sh.paymentView(dateInput, cb);
				String yesOrNo = yesOrNoInput(); // °áÁ¦ÇÏ½Ã°Ú½À´Ï±î y/n?

				if (yesOrNo.equals("y")) {
					// °ªÀúÀå
					hd.payment(dateInput, cb, phoneNo, licenseNo);
					System.out.println("°áÁ¦µÇ¼Ì½À´Ï´Ù.");
					pause(1.5);
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("°áÁ¦¸¦ Ãë¼ÒÇÏ¼Ì½À´Ï´Ù.");
					pause(1.5);
					break;
				} else {
					System.out.println("Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
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
        System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
        System.out.println("¦­   ¡á¡á¡á\\\\  ¡á¡á¡á\\\\   ¡á¡á¡á\\\\     ¡á¡á¡á\\\\            ¡á¡á¡á\\\\     ¦­");
        System.out.println("¦­   ¡á¡á¡á\\\\  ¡á¡á¡á\\\\   ¡á¡á¡á\\\\     ¡á¡á¡á\\\\            ¡á¡á¡á\\\\     ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á¡á\\\\ ¡á¡á¡á\\\\            ¡á¡á¡á¡á¡á¡á¡á\\\\ ¦­");
        System.out.println("¦­   ¡á¡á¡á\\\\  ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á¡á\\\\ ¡á¡á¡á\\\\            ¡á¡á¡á¡á¡á¡á¡á\\\\ ¦­");
        System.out.println("¦­   ¡á¡á¡á\\\\  ¡á¡á¡á\\\\   ¡á¡á¡á\\\\     ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\     ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\     ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\     ¦­");
        System.out.println("¦­                                                       ¦­");
        System.out.println("¦­      ¡á¡á¡á¡á\\\\                   ¡á¡á¡á\\\\        ¡á¡á¡á\\\\      ¦­");
        System.out.println("¦­      ¡á¡á¡á¡á\\\\                   ¡á¡á¡á\\\\        ¡á¡á¡á\\\\      ¦­");
        System.out.println("¦­      ¡á¡á¡á¡á\\\\                   ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¦­");
        System.out.println("¦­      ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\        ¡á¡á¡á\\\\      ¦­");
        System.out.println("¦­      ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¦­");
        System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
        System.out.println();
		while (true) {
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = null;

			arUhb = hd.getHistoryReturn(phoneNo);
			if(arUhb.isEmpty()) {
				System.out.println("¿¹¾à³»¿ªÀÌ ¾ø½À´Ï´Ù. ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
				pause(1.5);
				break;
			}
			sh.historyView(arUhb);
			

			String historyRowNum = rHistoryRowNumInput(); // ¿¹¾à¹øÈ£ ÀÔ·Â
			if (historyRowNum.equals("x"))
				break;
			String rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			if (rentNo == null) {
				System.out.println("¿¹¾à¹øÈ£ ÀÔ·ÂÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
				pause(1.5);
				break;
			} else {
				uhb = hd.getOneHistory(rentNo);
			}
			while (true) {
				sh.historyView(uhb);
				String yesOrNo = returnYesOrNoInput(); // ¹Ý³³ÇÏ½Ã°Ú½À´Ï±î y/n?

				if (yesOrNo.equals("y")) {
					// °ªÀúÀå
					hd.returnHistory(rentNo);
					System.out.println("¹Ý³³µÇ¾ú½À´Ï´Ù.");
					pause(1.5);
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("¹Ý³³À» Ãë¼ÒÇÏ¼Ì½À´Ï´Ù.");
					pause(1.5);
					break;
				} else {
					System.out.println("Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
				}
			}
			break;
		}
	}

	private String rHistoryRowNumInput() {
		System.out.print("¹Ý³³ÇÏ°íÀÚ ÇÏ´Â ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

	public void rentCancel() {
		System.out.println();
        System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\\t        ¡á¡á¡á¡á\\\\        ¡á¡á¡á\\\\       ¡á¡á¡á¡á\\\\        ¦­" );
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\\t     ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\     ¡á¡á¡á\\\\     ¡á¡á¡á\\\\¡á¡á¡á\\\\      ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t       ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\   ¡á¡á¡á\\\\    ¡á¡á¡á\\\\    ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t    ¡á¡á¡á¡á\\\\  ¡á¡á¡á¡á\\\\    ¡á¡á¡á\\\\  ¡á¡á¡á\\\\      ¡á¡á¡á\\\\   ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\\t  ¡á¡á¡á¡á\\\\      ¡á¡á¡á¡á\\\\  ¡á¡á¡á\\\\ ¡á¡á¡á\\\\        ¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\\t                      ¡á¡á¡á\\\\                     ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\¡á¡á¡á\\\\       ¡á¡á¡á¡á\\\\        ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\¡á¡á¡á\\\\       ¡á¡á¡á¡á\\\\        ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\\t         ¡á¡á¡á\\\\        ¡á¡á¡á\\\\¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\ ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\\t         ¡á¡á¡á\\\\        ¡á¡á¡á\\\\¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\ ¦­");
        System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
        System.out.println();
		while (true) {
			String phoneNo = cPhoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = hd.getCurrentHistory(phoneNo);

			if (arUhb.isEmpty()) {
				System.out.println("¿¹¾à³»¿ªÀÌ ¾ø½À´Ï´Ù.");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				pause(1.5);
			} else {
				sh.historyView(arUhb);
				// ¿¹¾à¹øÈ£ ¼±ÅÃ
				String historyRowNum = historyRowNumInput();
				if (historyRowNum.equals("x"))
					break;
				String rentNo = hd.getRentNo(historyRowNum, phoneNo);
				if (rentNo == null) {
					System.out.println("¿¹¾à¹øÈ£ ÀÔ·ÂÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
					pause(1.5);
					break;
				} else {
					uhb = hd.getOneHistory(rentNo);
				}
				while (true) {
					sh.historyView(uhb);
					String yesOrNo = delYesOrNoInput(); // »èÁ¦ÇÏ½Ã°Ú½À´Ï±î y/n?

					if (yesOrNo.equals("y")) {
						hd.delHistory(rentNo);
						System.out.println("´ë¿©Ãë¼ÒµÇ¾ú½À´Ï´Ù.");
						pause(1.5);
						break;
					} else if (yesOrNo.equals("n")) {
						System.out.println("´ë¿©Ãë¼Ò¸¦ Ãë¼ÒÇÏ¼Ì½À´Ï´Ù.");
						pause(1.5);
						break;
					} else {
						System.out.println("Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
					}
				}
			}
			break;
		}
	}

	private String cPhoneNoInput() {
		System.out.println("Ãë¼ÒÇÏ°íÀÚ ÇÏ´Â");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private String delYesOrNoInput() {
		System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
		System.out.println("¦­   »èÁ¦ ÇÏ½Ã°Ú½À´Ï±î? ( y / n ) ");
		System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	private String returnYesOrNoInput() {
		System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
		System.out.println("¦­   ¹Ý³³ ÇÏ½Ã°Ú½À´Ï±î? ( y / n ) ");
		System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	public void rentModify() {
		System.out.println();
        System.out.println("¦®¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\\t       ¡á¡á¡á¡á\\\\       ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\    ¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\\t     ¡á¡á¡á\\\\¡á¡á¡á\\\\           ¡á¡á¡á¡á\\\\     ¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t   ¡á¡á¡á\\\\   ¡á¡á¡á\\\\         ¡á¡á¡á\\\\    ¡á¡á¡á¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\      ¡á¡á¡á¡á\\\\     ¡á¡á¡á¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\\t ¡á¡á¡á\\\\       ¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\     ¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\     ¡á¡á¡á\\\\\t                   ¡á¡á¡á\\\\     ¡á¡á¡á\\\\   ¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\     ¦­");
        System.out.println("¦­   ¡á¡á\\\\         ¡á¡á¡á\\\\ ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á\\\\\t¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á¡á\\\\       ¡á¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\  ¡á¡á¡á¡á¡á¡á¡á¡á\\\\      ¡á¡á¡á\\\\\t       ¡á¡á¡á¡á\\\\          ¡á¡á¡á¡á\\\\       ¡á¡á¡á¡á\\\\  ¦­");
        System.out.println("¦­   ¡á¡á¡á¡á¡á¡á¡á¡á\\\\   ¡á¡á¡á\\\\ ¡á¡á¡á\\\\   ¡á¡á¡á¡á¡á¡á\\\\       ¡á¡á¡á\\\\\t       ¡á¡á¡á¡á\\\\            ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\\\\     ¦­");
        System.out.println("¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°");
        System.out.println();

		boolean rentModBool = true;
		while (rentModBool) {
			// Æù¹øÈ£ÀÔ·Â
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			// ¹øÈ£¿¡ ¸Â´Â ¿¹¾à¸ñ·Ï °¡Á®¿À±â
			arUhb = hd.getHistoryReturn(phoneNo);
			if (arUhb.isEmpty()) {
				System.out.println("ÇØ´ç ¹øÈ£´Â ¿¹¾à³»¿ªÀÌ ¾ø½À´Ï´Ù. ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
				pause(1.5);
				break;
			}
			// ¿¹¾à¸ñ·Ïº¸¿©ÁÖ±â
			sh.historyView(arUhb);
			// ¼öÁ¤ ¿¹¾à¹øÈ£ ÀÔ·Â¹Þ°í ÇØ´ç ¸ñ·Ï °®±â
			String historyRowNum = null;
			historyRowNum = mHistoryRowNumInput(); // ¿¹¾à¹øÈ£ ÀÔ·Â
			if (historyRowNum.equals("x")) {
				break;
			}

			String rentNo = null;
			rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			if (rentNo == null) {
				System.out.println("¹øÈ£¸¦ Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
				pause(1.5);
				break;
			}
			if (historyRowNum.equals("x"))
				break;
			uhb = hd.getOneHistory(rentNo);

			// ¼öÁ¤³¯Â¥ ÀÔ·Â
			String mDateInput = mDateInputInput();
			if (mDateInput.equals("x"))
				break;
			if (mDateInput.equals("")) {
				mDateInput = uhb.getRentStartDate() + "-" + uhb.getRentEndDate();
			}

			// ¼öÁ¤ÇÒ ¿¹¾àÀÇ Â÷ ¹øÈ£ °¡Á®¿À±â
			String carNo = Integer.toString(uhb.getCarNo());

			// Â÷·® º¸¿©ÁÖ±â->ÀÚ½ÅÀÇ ¿¹¾àÀº ¾ø´Â °ÍÃ³·³ Â÷¸¦ º¸¿©ÁÜ
			arCb = cd.modAvailableCar(rentNo, mDateInput);

			sc.carView(arCb, mDateInput);

				// ¼öÁ¤ Â÷·® ÀÔ·Â
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
				// Â÷ ÀÔ·Â±îÁö ¹Þ¾Ò°í ±âÁ¸Â÷ÀÎÁö »õ·Î ¼±ÅÃÇÑ°ÇÁöµµ Á¤ÇØÁ³³×
			System.out.println(carNo);
			// ÇØ¾ßµÉ°Ç ±âÁ¸Â÷ÀÏ °æ¿ì °¡´ÉÇÑÁö¸¸ ºñ±³ÇØÁà¾ßÇÔ.
			// ÇØ´ç Â÷ ¾µ ¼ö ÀÖÀ¸¸é enterOk true
			if (!cd.enterOk(rentNo, carNo, mDateInput)) {
				System.out.println("º¯°æÇÒ ³¯Â¥¿¡´Â ÇØ´ç Â÷¸¦ ÀÌ¿ëÇÒ ¼ö ¾ø½À´Ï´Ù");
				pause(1.5);
			} else {
				if(mDateInput.equals(uhb.getRentStartDate() + "-" + uhb.getRentEndDate()) && carNo.equals( Integer.toString( uhb.getCarNo() ) ) ){
					System.out.println("º¯°æ»çÇ×ÀÌ ¾ø½À´Ï´Ù");
					pause(1.5);
					break;
				}
				hd.delHistory(rentNo);
				hd.payment(mDateInput, cb, phoneNo, uhb.getLicenseNo());
			}
			break;
		}
	}

	private String mDateInputInput() {
		System.out.print("¼öÁ¤ÇÏ°íÀÚ ÇÏ´Â ");
		String mDateInput = enterDateInput();
		return mDateInput;
	}

	private String mHistoryRowNumInput() {
		System.out.print("¼öÁ¤ÇÏ°íÀÚ ÇÏ´Â ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

}
