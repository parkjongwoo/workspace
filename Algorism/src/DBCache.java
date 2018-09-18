import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class DBCache {
	
	public DBCache() {
		System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
		System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
	}
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		int size = cities.length;
		if(cacheSize == 0) return size * 5;
		
		Set<String> cacheSet = new HashSet<String>();
		Queue<String> cacheQue = new LinkedBlockingQueue<String>(cacheSize);
		String key = null;
		for (int i = 0; i < size; i++) {
			key = cities[i].toLowerCase();
			if (cacheSet.contains(key)) {
				cacheQue.remove(key);
				cacheQue.add(key);
				answer++;
			} else {
				if (cacheSet.size() >= cacheSize) {
					cacheSet.remove(cacheQue.poll());					
				}
				cacheQue.offer(key);
				cacheSet.add(key);
				
				answer+=5;
			}

		}

		return answer;

	}

	public static void main(String[] args) {
		new DBCache();
		// TODO Auto-generated method stub
//		String AAA = "AAA";
//		String aaa = "aaa";
//		Set<String> set = new HashSet<String>();
//		set.add(AAA.toLowerCase());
//		System.out.println(set.contains("aaa"));
//		set.add(aaa.toLowerCase());
		
	}

}
