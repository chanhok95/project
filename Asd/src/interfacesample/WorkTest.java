package interfacesample;

public class WorkTest {
	public static void main(String[] args) {
		// ȣ���ֹ��� hcook �Ƹ�Ÿ����Ʈ pcook ���� bk
		BuggerCook hcook = new HotelCook();
		BuggerCook pcook = new PartTimer();
		Buggerclerk bk = new Buggerclerk();
		
		// �ֹ� �߻��� ����ó��
		System.out.println("ȣ�ڽ� �ܹ��� �ֹ���û ����");
		bk.orderBugger(hcook);
	
		System.out.println("ȣ�ڽ� ������ �ֹ���û ����");
		bk.orderSalad(hcook);

		System.out.println("�˹ٽ� �ܹ��� �ֹ���û ����");
		bk.orderBugger(pcook);
	
		System.out.println("�˹ٽ� ������ �ֹ���û ����");
		bk.orderSalad(pcook);

	
	
	
	}
	
}
//��ɿ� ���� �׽�Ʈ