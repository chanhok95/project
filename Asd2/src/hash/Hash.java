package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Hash {
	public static void main(String[] args) {
		// map 컬렉션 생성
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 객체 저장

		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 85);
		map.put("홍길동", 95); // 홍길동 키가 같기 때문에 맨마지막에 저장한값으로 대처
		System.out.println("총 Entry수:" + map.size()); // 저장된 수업

		// 객체 찾기

		System.out.println("\t홍길동:" + map.get("홍길동"));
		System.out.println();

		Set<String> keySet = map.keySet();

		Iterator<String> keyIterable = keySet.iterator();
		while (keyIterable.hasNext()) {
			String key = keyIterable.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + ":" + value);

		}
		System.out.println();
		// 객체 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수 :" + map.size());
		// 객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entIterator = entrySet.iterator();

		while (entIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " :" + value);

		}
		System.out.println();
		// 객체 전체 삭제
		map.clear();
		System.out.println("총 entry수 :" + map.size());
	}

}
