import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class MapTest {

	public static void main(String[] args) {
//		long start = new Date().getTime();
//		long end = 0;
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		
//		for(int i=0;i<100000;i++) {
//			map.put(String.valueOf(i), i);
//		}
//		
//		System.out.println(map.get("99999"));
//		
//		end = new Date().getTime();
//		System.out.println(end - start);
		
//		long start = new Date().getTime();
//		long end = 0;
//		List<String> list = new ArrayList<String>();
//		
//		for(int i=0;i<100000;i++) {
//			list.add(String.valueOf(i));
//		}
//		
//		for(int i=0;i<100000;i++) {
//			if(i==99999) {
//				System.out.println(list.get(i));
//			}
//		}
//		
//		
//		
//		end = new Date().getTime();
//		System.out.println(end - start);
		
		long start = new Date().getTime();
		long end = 0;
		LinkedList<String> que = new LinkedList<String>();
		
		for(int i=0;i<100000;i++) {
			que.add(String.valueOf(i));
		}
		
		System.out.println(que.removeFirstOccurrence("99999"));
		
		end = new Date().getTime();
		System.out.println(end - start);
	}

}
