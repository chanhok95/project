package kr.co.hyungi.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.hyungi.beans.CarBean;
import kr.co.hyungi.beans.MemberBean;
import kr.co.hyungi.beans.UsageHistoryBean;
import kr.co.hyungi.domain.CarData;
import kr.co.hyungi.domain.HistoryData;
import kr.co.hyungi.domain.MemberData;
import kr.co.hyungi.domain.MemberData;

public class Rent extends CommonMethod {

	public void historyView(List<UsageHistoryBean> uh) { // �뿩���

		System.out.println("��ȸ�� �뿩������ �Ʒ��� �����ϴ�.");
		for (int i = 0; i < uh.size(); i++) {
			System.out.println("���� No(��ȣ):" + (i + 1));
			System.out.println("��Ʈ��ȣ:" + uh.get(i).getRentNo());
			System.out.println("����ȣ:" + uh.get(i).getCarNo());
			System.out.println("����ȣ:" + uh.get(i).getPhoneNo());
			System.out.println("�����ȣ:" + uh.get(i).getLicenseNo());
			System.out.println("�뿩��¥:" + uh.get(i).getRentStartDate());
			System.out.println("�ݳ���¥:" + uh.get(i).getRentEndDate());
			System.out.println("�뿩����:" + uh.get(i).getState());
			System.out.println("**********************************");
			System.out.println("**********************************");
			System.out.println("**********************************");

		}
	}

	public String ins_license() {
		String inlicenseno = inputMsg();
		new MemberData().isMember(inlicenseno);
		return inlicenseno;
	}

	public String phoneEqual() { // �뿩 �ڵ�����ȣ ��
		System.out.println("--------�뿩-------");
		System.out.println("�ڵ�����ȣ�� �Է����ּ���.");
		String phoneNo = inputMsg();
		new MemberData().isMember(phoneNo);
		return phoneNo;

	}

	public String equal() { // �뿩��� ����ȣ�Էº�
		System.out.println("�ڵ�����ȣ�� �Է����ּ���.");
		String phoneNo = inputMsg();
		return phoneNo;
	}

	public String licenseNoAdd() { // �����ȣ
		System.out.println("�������� ��ȣ�� �Է��ϼ���.");
		String licenseno = inputMsg();

		return licenseno;

	}

	public String rentDate() { // �뿩���� �ݳ�����

		System.out.println("�뿩,�ݳ��ð��Է��ϼ��� ex) 010102-010103 �뿩-�ݳ�");
		String inputDate = inputMsg();

		return inputDate;

	}

	public String carAdd() { // ��������
		System.out.println("-----------------------");
		System.out.println("���Ͻô� ������ȣ�� �Է����ּ���.");
		String carno = inputMsg();
		return carno;
	}

	public String payMent() { // ������ ����
		System.out.println("�����Ͻðڽ��ϱ�.y:���� n:���");
		String cash = inputMsg();
		return cash;
	}

	public void rent() { // �뿩 main?

		String phoneNo = phoneEqual();// ����ȣ �� �����ִ��� Ȯ��
		boolean isMember = new MemberData().isMember(phoneNo);// ȸ������ Ȯ���ϱ�
		String licenseNo = null;
		String inputDate;
		if (isMember) {
			inputDate = rentDate();
		} else {
			licenseNo = licenseNoAdd();
			inputDate = rentDate();
		}
		List<CarBean> cb = new CarData().def_data();
		new SearchCar().carView(cb);
		String carno = carAdd();

		String select = payMent();
		if (select.equals("y")) {
			System.out.println("�����Ǽ̽��ϴ�.");
			rent();
			// ������
			new HistoryData().ins(carno, phoneNo, licenseNo, inputDate);
		} else if (select.equals("n")) {
			rent();
		}
	}

	public void rentCancel() { // �뿩��� main?
		String phoneNo = equal();
		List<UsageHistoryBean> uh = new HistoryData().def_data(phoneNo);
		if (uh.isEmpty()) {
			System.out.println("���೻���� �����ϴ�.");
			System.out.println("�ٽ� �Է����ּ���.");
			rentCancel();
		} else {
			historyView(uh);
			System.out.println("����no(��ȣ)�� �Է����ּ���.");
			String rentNo = inputMsg();
			System.out.println("�����Ͻðڽ��ϱ�? ex) y,n");
			String select = inputMsg();

			if (select.equals("y")) {

				new HistoryData().delHistory(uh.get(Integer.parseInt(rentNo) - 1).getRentNo());
			} else if (select.equals("n")) {
				rent();
			}
		}
	}

	public void searchView() { // ȸ����ȸ
		List<MemberBean> mb = new MemberData().def_data();
		new SearchMember().memView(mb);

	}

	public void usedState() {// ���� (������,�����) Ȯ��
		List<UsageHistoryBean> uh = new HistoryData().state();
		historyView(uh);
	}

	public long dateCal(long calDateDays) { // startdate - enddate ��
		{
			System.out.println("�뿩��");
			String strDate = inputMsg();
			System.out.println("�ݳ���");
			String EndDate = inputMsg();

			try { // String Type�� Date Type���� ĳ�����ϸ鼭 ����� ���ܷ� ���� ���⼭ ����ó�� ������ ������ �����Ϸ����� ������ �߻��ؼ�
					// �������� �� �� ����.
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				// date1, date2 �� ��¥�� parse()�� ���� Date������ ��ȯ.
				Date FirstDate = format.parse(strDate);
				Date SecondDate = format.parse(EndDate);

				// Date�� ��ȯ�� �� ��¥�� ����� �� �� ���ϰ����� long type ������ �ʱ�ȭ �ϰ� �ִ�.
				// ������ -950400000. long type ���� return �ȴ�.
				long calDate = FirstDate.getTime() - SecondDate.getTime();

				// Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�.
				// ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
				 calDateDays = calDate / (24 * 60 * 60 * 1000);

				calDateDays = Math.abs(calDateDays);

				System.out.println("�� ��¥�� ��¥ ����: " + calDateDays);
			} catch (ParseException e) {
			
			}
		}
		return calDateDays;
	}

}
