package algorism;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class HakingList {

	public HakingList() {
		showMemory();
//		long start = new Date().getTime();
//		System.out.println(start);		
		Branch request = getRequestBranch();
		int max = request.left;
		Map<String,Branch> map = new HashMap<String,Branch>();
		SortedMap<Integer,List<Branch>> root = new TreeMap<Integer,List<Branch>>();
		SortedMap<Integer,Set<Integer>> hackList = new TreeMap<Integer,Set<Integer>>();
		StringBuffer sb = new StringBuffer();
		
		System.out.println(request.toString());
		for (int i = 0; i < request.right; i++) {
			Branch b = getBranch(max);
			String key = b.toString();
			if (map.get(key) != null) {
				i--;
				continue;
			}
			map.put(key, b);
			sb.append(key).append('\n');
			if(root.get(b.right)==null)
			{
				List<Branch> list = new ArrayList<Branch>();
				list.add(b);
				root.put(b.right, list);
			}else {
				root.get(b.right).add(b);
			}			
		}
		System.out.println(sb);
		System.out.println("=================");
		System.out.println("root:"+root);
		
		sb.setLength(0);
		sb = null;
		map.clear();
		map = null;
//		Param p = new Param();
		Stack<Branch> workList = new Stack<Branch>();
		Set<Integer> history = new HashSet<Integer>();
		boolean first = true;
		Integer right;
		Integer left;
		for(Entry<Integer,List<Branch>> entry : root.entrySet()) {			
			// add work stack
			List<Branch> rootItemlist = entry.getValue();
			
			for(Branch b : rootItemlist) {
				workList.push(b);
			}
//			System.out.println("workList:"+workList);
			first = true;
			
			while(true) {
				if(workList.isEmpty())
					break;
				Branch item = workList.pop();
				right = Integer.valueOf(item.right);
				left = Integer.valueOf(item.left);
				if(hackList.get(right) == null) {
					hackList.put(right,new HashSet<Integer>());
				}
				hackList.get(right).add(left);
//				if(!first) {
					System.out.println("history:"+history);
					if(history.size()>0 && (history.contains(item.left) || item.left == entry.getKey())) {
						System.out.println("history에 존재하는 루트 탐색종료");
						history.clear();
						first=true;
						continue;					
					}
//				}			
				history.add(item.left);
				first = false;
				
//				System.out.println("count:"+count);
				
				List<Branch> nextBranchItemlist = root.get(left);
//				System.out.println("nextBranchItemlist:"+nextBranchItemlist);
				if(nextBranchItemlist != null) {
					for(Branch b : nextBranchItemlist) {
						workList.push(b);
					}					
				}
//				else {
//					count.put(item.left, count.get(item.left)-1);
//				}
			}			
		}
		
		System.out.println("결과:\n"+hackList);
		showMemory();
	}
	
	public void process(Param p) {
		System.out.println("startkey:"+p.startkey+" nowkey:"+p.nowkey+" listidx:"+p.listidx+" count:"+p.count);
		System.out.println("entry.getValue():"+p.root.get(p.nowkey));
		p.count++;
		
		if(p.startkey==p.nowkey && p.count>1) {//순환일 경우 최초 컴퓨터는 해킹된 상태이므로 올린 카운트 다시 내리고 값 반환
			p.count--;
			return ;
		}
		
		List<Branch>list = p.root.get(p.nowkey);		
		if(list == null) {
			p.count--;
			return ;
		}
//		if(list.size()<=listidx) {//리스트 마지막 인덱스 초과시 증가한 카운트 초기화 후 반환
//			count--;
//			return count;
//		}
		
		for(int i=0;i<list.size();i++) {
			Branch b = list.get(p.listidx);
//			p.count = process(p);
		}	
//		return p.count;
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
//		return new Branch(randomIntN(10000), randomIntN(100000));
		return new Branch(randomIntN(10), randomIntN(20));
	}

	private Branch getBranch(int max) {
		int left = randomIntN(max);
		int right = randomIntN(max, left);
		return new Branch(left, right);
	}
	Random random = new Random();
	private int randomIntN(int max) {
		return random.nextInt(max)+1;
	}	

	private int randomIntN(int max, int left) {
		int right = randomIntN(max);
//		System.out.println("left:"+left+" right:"+right);
		if (left == right)
			right = randomIntN(max, left);
		return right;
	}
	
	public static Comparator<Branch> branchSorter = new Comparator<Branch>() {
		@Override
		public int compare(Branch o1, Branch o2) {
			return o1.left-o2.left;
		}
	};
	
	class Branch{
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
	class Param{
		public int startkey;
		public int nowkey;
		public int listidx;
		public int count;
		SortedMap<Integer,List<Branch>> root;
		public void clear() {
			startkey = 0;
			nowkey = 0;
			listidx = 0;
			count = 0;
			root = null;
		}
	}
	public static void main(String[] args) {
		new HakingList();
	}
}
