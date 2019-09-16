package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Hash {
	public static void main(String[] args) {
		// map �÷��� ����
		Map<String, Integer> map = new HashMap<String, Integer>();

		// ��ü ����

		map.put("�ſ��", 85);
		map.put("ȫ�浿", 90);
		map.put("���屺", 85);
		map.put("ȫ�浿", 95); // ȫ�浿 Ű�� ���� ������ �Ǹ������� �����Ѱ����� ��ó
		System.out.println("�� Entry��:" + map.size()); // ����� ����

		// ��ü ã��

		System.out.println("\tȫ�浿:" + map.get("ȫ�浿"));
		System.out.println();

		Set<String> keySet = map.keySet();

		Iterator<String> keyIterable = keySet.iterator();
		while (keyIterable.hasNext()) {
			String key = keyIterable.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + ":" + value);

		}
		System.out.println();
		// ��ü ����
		map.remove("ȫ�浿");
		System.out.println("�� Entry �� :" + map.size());
		// ��ü�� �ϳ��� ó��
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entIterator = entrySet.iterator();

		while (entIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " :" + value);

		}
		System.out.println();
		// ��ü ��ü ����
		map.clear();
		System.out.println("�� entry�� :" + map.size());
	}

}
