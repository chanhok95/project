package kr.co.mainrun.kil;

public class Qsd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�ε��� �ʰ�");
			} catch (NumberFormatException e) {
				System.out.println("���� ��ȯ �ȵ�");
			} finally {
				System.out.println(value);
			}
		}
	}
}
