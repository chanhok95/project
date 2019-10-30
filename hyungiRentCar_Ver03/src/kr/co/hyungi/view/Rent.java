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

	public void rent() { // �뿩

		while (true) {
			String phoneNo = phoneNoInput();// ����ȣ �Է¹ޱ�
			if (phoneNo.equals("x"))
				break;
			boolean isMember = md.isMember(phoneNo);// ȸ������ Ȯ���ϱ�

			String licenseNo = null;
			String dateInput = null;
			if (isMember) {
				// ȸ���̸� ��¥�Է¸�
				licenseNo = md.getLicenseNo(phoneNo);
			} else {
				// ��ȸ���̸� �����ȣ, ��¥�Է� �Ѵ�
				licenseNo = licenseNoInput();
				if (licenseNo.equals("x"))
					break;
			}
			dateInput = dateInputInput();
			if (dateInput.equals("x"))
				break;

			String carRowNum = null;
			String carNo = null;
			while (true) {
				// �� ��� �����ֱ�
				arCb = cd.getAvailableCar(dateInput);
				sc.carView(arCb, dateInput);

				// ������
				carRowNum = carRowNumInput();
				if (carRowNum.equals("x"))
					break;
				carNo = cd.getCarNo(carRowNum, dateInput);
				if (carNo != null)
					break;
			}
			cb = cd.getOneCar(carNo);

			while (true) {
				sh.paymentView(dateInput, cb);
				String yesOrNo = yesOrNoInput(); // �����Ͻðڽ��ϱ� y/n?

				if (yesOrNo.equals("y")) {
					// ������
					hd.payment(dateInput, cb, phoneNo, licenseNo);
					System.out.println("�����Ǽ̽��ϴ�.");
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("������ ����ϼ̽��ϴ�.");
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
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
		while (true) {
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = null;

			arUhb = hd.getHistoryReturn(phoneNo);
			sh.historyView(arUhb);

			String historyRowNum = rHistoryRowNumInput(); // �����ȣ �Է�
			if (historyRowNum.equals("x"))
				break;
			String rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			uhb = hd.getOneHistory(rentNo);

			while (true) {
				sh.historyView(uhb);
				String yesOrNo = returnYesOrNoInput(); // �ݳ��Ͻðڽ��ϱ� y/n?

				if (yesOrNo.equals("y")) {
					// ������
					hd.returnHistory(rentNo);
					System.out.println("�ݳ��Ǿ����ϴ�.");
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("�ݳ��� ����ϼ̽��ϴ�.");
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
			}
		}
	}

	private String rHistoryRowNumInput() {
		System.out.print("�ݳ��ϰ��� �ϴ� ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

	public void rentCancel() {
		while (true) {
			String phoneNo = cPhoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = hd.getCurrentHistory(phoneNo);

			if (arUhb.isEmpty()) {
				System.out.println("���೻���� �����ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
			} else {
				sh.historyView(arUhb);
				// �����ȣ ����
				String historyRowNum = historyRowNumInput();
				if (historyRowNum.equals("x"))
					break;
				String rentNo = hd.getRentNo(historyRowNum, phoneNo);
				uhb = hd.getOneHistory(rentNo);

				while (true) {
					sh.historyView(uhb);
					String yesOrNo = delYesOrNoInput(); // �����Ͻðڽ��ϱ� y/n?

					if (yesOrNo.equals("y")) {
						hd.delHistory(rentNo);
						System.out.println("�뿩��ҵǾ����ϴ�.");
						break;
					} else if (yesOrNo.equals("n")) {
						System.out.println("�뿩��Ҹ� ����ϼ̽��ϴ�.");
						break;
					} else {
						System.out.println("�߸��Է��ϼ̽��ϴ�.");
					}
				}
			}
			break;
		}
	}

	private String cPhoneNoInput() {
		System.out.println("����ϰ��� �ϴ�");
		String phoneNo = phoneNoInput();
		return phoneNo;
	}

	private String delYesOrNoInput() {
		System.out.println("******************����(y/n)**********************************");
		System.out.println("************************************************************");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	private String returnYesOrNoInput() {
		System.out.println("******************�ݳ�(y/n)**********************************");
		System.out.println("************************************************************");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	public void rentModify() {

		boolean rentModBool = true;
		while (rentModBool) {
			// ����ȣ�Է�
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			String rentNo = null;
			String historyRowNum = null;
			while (true) {
				// ��ȣ�� �´� ������ ��������
				arUhb = hd.getHistoryReturn(phoneNo);
				// �����Ϻ����ֱ�
				sh.historyView(arUhb);
				// ���� �����ȣ �Է¹ް� �ش� ��� ����
				historyRowNum = mHistoryRowNumInput(); // �����ȣ �Է�
				if (historyRowNum.equals("x"))
					break;
				rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
				if (rentNo == null) {
					System.out.println("�߸��� �Է��Դϴ�.");
				} else {
					break;
				}
			}
			if (historyRowNum.equals("x"))
				break;

			uhb = hd.getOneHistory(rentNo);

			// ��¥ �Է�
			String dateInput = dateInputInput();
			if (dateInput.equals("x"))
				break;
			if (dateInput.equals("")) {
				dateInput = uhb.getRentStartDate() + "-" + uhb.getRentEndDate();
			}

			// ������ ������ �� ��ȣ ��������
			String carNo = Integer.toString(uhb.getCarNo());

			// ���� �����ֱ�
			arCb = cd.modAvailableCar(rentNo, dateInput);

			sc.carView(arCb, dateInput);

			while (true) {
				// ���� ���� �Է�
				String carRowNum = carRowNumInput();
				if (carRowNum.equals("x"))
					break;
				if (!carRowNum.equals("")) {
//����					carNo = cd.getCarNo(carRowNum, dateInput);
					cb = cd.getOneCar(carNo);
					if (carNo != null)
						break;
				} else {
					cb = cd.getOneCar(carNo);
					break;
				}
				// �� �Է±��� �޾Ұ� ���������� ���� �����Ѱ����� ��������
			}
			// �ؾߵɰ� �������� ��� ���������� ���������.
			// carNo�� ������ enterOk true
			if (cd.enterOk(carNo, dateInput)) {
				System.out.println("������ ��¥���� �ش� ���� �̿��� �� �����ϴ�");
			} else {
				hd.delHistory(rentNo);
				hd.payment(dateInput, cb, phoneNo, uhb.getLicenseNo());
			}
			break;
		}
	}

	private String mHistoryRowNumInput() {
		System.out.print("�����ϰ��� �ϴ� ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

}
