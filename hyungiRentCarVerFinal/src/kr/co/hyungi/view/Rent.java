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
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������");
	    System.out.println("��   ���������\\\\   ����\\\\ ����\\\\    �������\\\\       ����\\\\  ��");
	    System.out.println("��   ���������\\\\   ����\\\\ ����\\\\   ���������\\\\      ����\\\\  ��");
	    System.out.println("��   ���\\\\         ����\\\\ ����\\\\  ����\\\\  ����\\\\  �������\\\\  ��");
	    System.out.println("��   ���\\\\         ����\\\\ ����\\\\  ����\\\\  ����\\\\  �������\\\\  ��");
	    System.out.println("��   ���\\\\         ����������\\\\  ����\\\\  ����\\\\     ����\\\\  ��");
	    System.out.println("��   ���\\\\         ����������\\\\  ����\\\\  ����\\\\     ����\\\\  ��");
	    System.out.println("��   ���\\\\         ����\\\\ ����\\\\  ����\\\\  ����\\\\  �������\\\\  ��");
	    System.out.println("��   ���\\\\         ����\\\\ ����\\\\  ����\\\\  ����\\\\  �������\\\\  ��");
	    System.out.println("��   ���������\\\\   ����\\\\ ����\\\\   ���������\\\\      ����\\\\  ��");
	    System.out.println("��   ���������\\\\   ����\\\\ ����\\\\    �������\\\\       ����\\\\  ��");
	    System.out.println("��������������������������������������������������������������������������������������������������������������");
	    System.out.println();

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
			// �� ��� �����ֱ�
			arCb = cd.getAvailableCar(dateInput);
			sc.carView(arCb, dateInput);

			// ������
			carRowNum = carRowNumInput();
			if (carRowNum.equals("x"))
				break;
			carNo = cd.getCarNo(carRowNum, dateInput);
			if (carNo == null) {
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� Ȯ�����ּ���");
				pause(1.5);
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
					pause(1.5);
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("������ ����ϼ̽��ϴ�.");
					pause(1.5);
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
		System.out.println();
        System.out.println("������������������������������������������������������������������������������������������������������������������");
        System.out.println("��   ����\\\\  ����\\\\   ����\\\\     ����\\\\            ����\\\\     ��");
        System.out.println("��   ����\\\\  ����\\\\   ����\\\\     ����\\\\            ����\\\\     ��");
        System.out.println("��   �����������\\\\   ��������\\\\ ����\\\\            ��������\\\\ ��");
        System.out.println("��   ����\\\\  ����\\\\   ��������\\\\ ����\\\\            ��������\\\\ ��");
        System.out.println("��   ����\\\\  ����\\\\   ����\\\\     ����������\\\\      ����\\\\     ��");
        System.out.println("��   �����������\\\\   ����\\\\     ����������\\\\      ����\\\\     ��");
        System.out.println("��                                                       ��");
        System.out.println("��      �����\\\\                   ����\\\\        ����\\\\      ��");
        System.out.println("��      �����\\\\                   ����\\\\        ����\\\\      ��");
        System.out.println("��      �����\\\\                   �����������������\\\\      ��");
        System.out.println("��      ������������������\\\\      ����\\\\        ����\\\\      ��");
        System.out.println("��      ������������������\\\\      �����������������\\\\      ��");
        System.out.println("������������������������������������������������������������������������������������������������������������������");
        System.out.println();
		while (true) {
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = null;

			arUhb = hd.getHistoryReturn(phoneNo);
			if(arUhb.isEmpty()) {
				System.out.println("���೻���� �����ϴ�. �ٽ� Ȯ�����ּ���");
				pause(1.5);
				break;
			}
			sh.historyView(arUhb);
			

			String historyRowNum = rHistoryRowNumInput(); // �����ȣ �Է�
			if (historyRowNum.equals("x"))
				break;
			String rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			if (rentNo == null) {
				System.out.println("�����ȣ �Է��� �߸��Ǿ����ϴ�. �ٽ� Ȯ�����ּ���");
				pause(1.5);
				break;
			} else {
				uhb = hd.getOneHistory(rentNo);
			}
			while (true) {
				sh.historyView(uhb);
				String yesOrNo = returnYesOrNoInput(); // �ݳ��Ͻðڽ��ϱ� y/n?

				if (yesOrNo.equals("y")) {
					// ������
					hd.returnHistory(rentNo);
					System.out.println("�ݳ��Ǿ����ϴ�.");
					pause(1.5);
					break;
				} else if (yesOrNo.equals("n")) {
					System.out.println("�ݳ��� ����ϼ̽��ϴ�.");
					pause(1.5);
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
			}
			break;
		}
	}

	private String rHistoryRowNumInput() {
		System.out.print("�ݳ��ϰ��� �ϴ� ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

	public void rentCancel() {
		System.out.println();
        System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\   �������\\\\       ����\\\\\t        �����\\\\        ����\\\\       �����\\\\        ��" );
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\  ���������\\\\      ����\\\\\t     �����������\\\\     ����\\\\     ����\\\\����\\\\      ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t       �������\\\\       ����\\\\   ����\\\\    ����\\\\    ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t    �����\\\\  �����\\\\    ����\\\\  ����\\\\      ����\\\\   ��");
        System.out.println("��   ���\\\\         ����������\\\\ ����\\\\  ����\\\\     ����\\\\\t  �����\\\\      �����\\\\  ����\\\\ ����\\\\        ����\\\\  ��");
        System.out.println("��   ���\\\\         ����������\\\\ ����\\\\  ����\\\\     ����\\\\\t                      ����\\\\                     ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t���������������������\\\\����\\\\       �����\\\\        ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t���������������������\\\\����\\\\       �����\\\\        ��");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\  ���������\\\\      ����\\\\\t         ����\\\\        ����\\\\�������������������\\\\ ��");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\   �������\\\\       ����\\\\\t         ����\\\\        ����\\\\�������������������\\\\ ��");
        System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
        System.out.println();
		while (true) {
			String phoneNo = cPhoneNoInput();
			if (phoneNo.equals("x"))
				break;
			arUhb = hd.getCurrentHistory(phoneNo);

			if (arUhb.isEmpty()) {
				System.out.println("���೻���� �����ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				pause(1.5);
			} else {
				sh.historyView(arUhb);
				// �����ȣ ����
				String historyRowNum = historyRowNumInput();
				if (historyRowNum.equals("x"))
					break;
				String rentNo = hd.getRentNo(historyRowNum, phoneNo);
				if (rentNo == null) {
					System.out.println("�����ȣ �Է��� �߸��Ǿ����ϴ�. �ٽ� Ȯ�����ּ���");
					pause(1.5);
					break;
				} else {
					uhb = hd.getOneHistory(rentNo);
				}
				while (true) {
					sh.historyView(uhb);
					String yesOrNo = delYesOrNoInput(); // �����Ͻðڽ��ϱ� y/n?

					if (yesOrNo.equals("y")) {
						hd.delHistory(rentNo);
						System.out.println("�뿩��ҵǾ����ϴ�.");
						pause(1.5);
						break;
					} else if (yesOrNo.equals("n")) {
						System.out.println("�뿩��Ҹ� ����ϼ̽��ϴ�.");
						pause(1.5);
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
		System.out.println("������������������������������������������������������������");
		System.out.println("��   ���� �Ͻðڽ��ϱ�? ( y / n ) ");
		System.out.println("������������������������������������������������������������");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	private String returnYesOrNoInput() {
		System.out.println("������������������������������������������������������������");
		System.out.println("��   �ݳ� �Ͻðڽ��ϱ�? ( y / n ) ");
		System.out.println("������������������������������������������������������������");
		String yesOrNo = inputMsg();
		return yesOrNo;
	}

	public void rentModify() {
		System.out.println();
        System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\   �������\\\\       ����\\\\\t       �����\\\\       ������������\\\\    ����\\\\  ��");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\  ���������\\\\      ����\\\\\t     ����\\\\����\\\\           �����\\\\     ����\\\\  ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t   ����\\\\   ����\\\\         ����\\\\    �������\\\\  ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t  ����\\\\     ����\\\\      �����\\\\     �������\\\\  ��");
        System.out.println("��   ���\\\\         ����������\\\\ ����\\\\  ����\\\\     ����\\\\\t ����\\\\       ����\\\\   ����\\\\ ����\\\\     ����\\\\  ��");
        System.out.println("��   ���\\\\         ����������\\\\ ����\\\\  ����\\\\     ����\\\\\t                   ����\\\\     ����\\\\   ����\\\\  ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t�������������������\\\\      ������������\\\\     ��");
        System.out.println("��   ���\\\\         ����\\\\ ����\\\\ ����\\\\  ����\\\\  �������\\\\\t�������������������\\\\   �����\\\\       �����\\\\  ��");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\  ���������\\\\      ����\\\\\t       �����\\\\          �����\\\\       �����\\\\  ��");
        System.out.println("��   ���������\\\\   ����\\\\ ����\\\\   �������\\\\       ����\\\\\t       �����\\\\            �������������\\\\     ��");
        System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
        System.out.println();

		boolean rentModBool = true;
		while (rentModBool) {
			// ����ȣ�Է�
			String phoneNo = phoneNoInput();
			if (phoneNo.equals("x"))
				break;
			// ��ȣ�� �´� ������ ��������
			arUhb = hd.getHistoryReturn(phoneNo);
			if (arUhb.isEmpty()) {
				System.out.println("�ش� ��ȣ�� ���೻���� �����ϴ�. �ٽ� Ȯ�����ּ���");
				pause(1.5);
				break;
			}
			// �����Ϻ����ֱ�
			sh.historyView(arUhb);
			// ���� �����ȣ �Է¹ް� �ش� ��� ����
			String historyRowNum = null;
			historyRowNum = mHistoryRowNumInput(); // �����ȣ �Է�
			if (historyRowNum.equals("x")) {
				break;
			}

			String rentNo = null;
			rentNo = hd.getReturnRentNo(historyRowNum, phoneNo);
			if (rentNo == null) {
				System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�. �ٽ� Ȯ�����ּ���");
				pause(1.5);
				break;
			}
			if (historyRowNum.equals("x"))
				break;
			uhb = hd.getOneHistory(rentNo);

			// ������¥ �Է�
			String mDateInput = mDateInputInput();
			if (mDateInput.equals("x"))
				break;
			if (mDateInput.equals("")) {
				mDateInput = uhb.getRentStartDate() + "-" + uhb.getRentEndDate();
			}

			// ������ ������ �� ��ȣ ��������
			String carNo = Integer.toString(uhb.getCarNo());

			// ���� �����ֱ�->�ڽ��� ������ ���� ��ó�� ���� ������
			arCb = cd.modAvailableCar(rentNo, mDateInput);

			sc.carView(arCb, mDateInput);

				// ���� ���� �Է�
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
				// �� �Է±��� �޾Ұ� ���������� ���� �����Ѱ����� ��������
			System.out.println(carNo);
			// �ؾߵɰ� �������� ��� ���������� ���������.
			// �ش� �� �� �� ������ enterOk true
			if (!cd.enterOk(rentNo, carNo, mDateInput)) {
				System.out.println("������ ��¥���� �ش� ���� �̿��� �� �����ϴ�");
				pause(1.5);
			} else {
				if(mDateInput.equals(uhb.getRentStartDate() + "-" + uhb.getRentEndDate()) && carNo.equals( Integer.toString( uhb.getCarNo() ) ) ){
					System.out.println("��������� �����ϴ�");
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
		System.out.print("�����ϰ��� �ϴ� ");
		String mDateInput = enterDateInput();
		return mDateInput;
	}

	private String mHistoryRowNumInput() {
		System.out.print("�����ϰ��� �ϴ� ");
		String historyRowNum = historyRowNumInput();
		return historyRowNum;
	}

}
