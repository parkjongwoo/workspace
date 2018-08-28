package algorism;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HakingList {

	public HakingList() {
		showMemory();
//		long start = new Date().getTime();
//		System.out.println(start);		
		Branch request = getRequestBranch();
		int max = request.left;
		Map<String,Branch> map = new HashMap<String,Branch>();
		Map<Branch,Integer> root = new HashMap<Branch,Integer>();
		Map<Branch,Integer> reaf = new HashMap<Branch,Integer>();
		Map<Branch,Integer> body = new HashMap<Branch,Integer>();
		
		System.out.println(request.toString());
		for (int i = 0; i < request.right; i++) {
			Branch b = getBranch(max);
			String key = b.toString();
			if (map.get(key) != null) {
				i--;
				continue;
			}
			map.put(key, b);
			root.put(b, Integer.valueOf(b.right));
			reaf.put(b, Integer.valueOf(b.left));
		}
		System.out.println("root.size()+ reaf.size():"+(root.size()+ reaf.size()));
		boolean b = false;
		for( Entry<String,Branch> e : map.entrySet()) {				
			b = root.get(e.getValue()).equals(e.getValue().left);
			if(b) {				
				root.remove(e.getValue());
				
			}
			b = reaf.get(e.getValue()).equals(e.getValue().right);
			if(b) {				
				reaf.remove(e.getValue());
			}						
			if(b) {
				body.put(e.getValue(),e.getValue().left);
			}
		}
		
		
		
		int total = root.size()+ reaf.size()+body.size();
		System.out.println("root.size():"+root.size()+" reaf.size():"+reaf.size()+" body.size():"+body.size());
		System.out.println("total:"+map.size() + " | "+total);
//		long end = new Date().getTime();
//		System.out.println(end - start);
		showMemory();
	}
	static Runtime r = Runtime.getRuntime();
	public static void showMemory() {

		DecimalFormat format = new DecimalFormat("###,###,###.##");

		// JVM이 현재 시스템에 요구 가능한 최대 메모리량, 이 값을 넘으면 OutOfMemory 오류가 발생 합니다.

		long max = r.maxMemory();

		// JVM이 현재 시스템에 얻어 쓴 메모리의 총량

		long total = r.totalMemory();

		// JVM이 현재 시스템에 청구하여 사용중인 최대 메모리(total)중에서 사용 가능한 메모리

		long free = r.freeMemory();

		System.out.println(
				"Max:" + format.format(max) + ", Total:" + format.format(total) + ", Free:" + format.format(free));

	}

	private Branch getRequestBranch() {
		return new Branch(randomIntN(10000), randomIntN(100000));
	}

	private Branch getBranch(int max) {
		int left = randomIntN(max);
		int right = randomIntN(max, left);
		return new Branch(left, right);
	}
	
	private int randomIntN(int max) {
		return (int) (Math.round(Math.random() * max) + 1);
	}	

	private int randomIntN(int max, int left) {
		int right = randomIntN(max);
		if (left == right)
			randomIntN(max, left);
		return right;
	}	

	public static void main(String[] args) {
		new HakingList();
	}

	class Branch {
		public int left;
		public int right;

		public Branch() {
		}

		public Branch(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return left + " " + right;
		}
	}
}
