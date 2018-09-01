package algorism;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class HakingList {
	//개념설명
	//결과 작성 > 시작점 목록 작성 > 시작점별 순환 > 시작점 신뢰목록 저장> 한개의 신뢰 정보를 다음 시작점 목록으로 변경 > 신뢰정보저장 > 시작점 순환
	
	//로직 설명
	//1. 출력용 map을 작성한다. map은 출력문자열을 키로, 좌항,우항의 숫자조합으로 이루어진 Branch를 값으로 갖는다.
	//2. 1과 동시에 시작점 map을 작성한다. 시작점map은 우항에 등록된 번호를 키로, 해당 Branch의 List를 값으로 갖는다. 즉 시작점별 Branch의 List.
	//3. 시작점별로 순환하며 work Branch stack에 해당 시작점map의 Branch List를 저장한다.
	//4. stack에서 Branch를 꺼낸다.
	//5. 4번Branch의 좌우항으로 결과 map에 키는 Branch의 우항, 값은 좌항의 Set으로하고 값을 추가한다. 
	//6. 4번 Branch의 우항을 history stack에 저장한고, 좌항을 시작점map에서 찾아 work stack에 저장한다.
	//7. 4,5,6을 순환한다. 순환 종료는 Branch stack이 비었을 때 한다. 
	//8. 5번 실행전 4번Branch의 좌항이 history 또는 시작점에 포함된 경우 순환되는 것이므로 5,6실행을 뛰어넘어 4항부터 다시 실행한다.
	
	Map<String,Branch> map = new HashMap<String,Branch>(); // 관계목록 출력위한 키 조합
	Map<Integer,List<Branch>> root = new HashMap<Integer,List<Branch>>();//우변에 한번이라도 있어 시작가능한 번호의 Branch목록
	Map<Integer,Set<Integer>> hackList = new HashMap<Integer,Set<Integer>>();//각 시작가능한 번호별 신뢰관계 목록
	StringBuffer sb = new StringBuffer();//신뢰관계 목록 출력폼
	
	public HakingList() {
		showMemory();
//		long start = new Date().getTime();
//		//System.out.println(start);		
		Branch request = getRequestBranch();//컴퓨터 번호갯수, 신뢰관계갯수
		int max = request.left;		//컴퓨터번호의 발생가능 최대치
		
		System.out.println(request.toString());
		for (int i = 0; i < request.right; i++) {// 신뢰관계 갯수만큼 순환
			Branch b = getBranch(max);//신뢰받는 컴퓨터와 신뢰하는 컴퓨터가 동일하지 않게 랜덤 발생
			String key = b.toString();//"신뢰하는 컴퓨터(빈칸)신뢰받는 컴퓨터" 형식으로 키저장 
			if (map.get(key) != null) {//기존에 있는 신뢰관계라면 다시 실행
				i--;
				continue;
			}
			map.put(key, b);//관계저장
			sb.append(key).append('\n');//출력폼 저장
			if(root.get(b.right)==null)//
			{
				List<Branch> list = new ArrayList<Branch>();
				list.add(b);
				root.put(b.right, list);
			}else {
				root.get(b.right).add(b);
			}			
		}
		System.out.println(sb);
		//System.out.println("=================");
		//System.out.println("root:"+root);
		
		sb.setLength(0);
		sb = null;
		map.clear();
		map = null;
		Stack<Branch> workList = new Stack<Branch>();
		Stack<Integer> history = new Stack<Integer>();
//		Integer right;
		Integer left;
		Integer start;
//		boolean first = true;
		for(Entry<Integer,List<Branch>> entry : root.entrySet()) {	
			List<Branch> rootItemlist = entry.getValue();
			start = entry.getKey();
			for(Branch b : rootItemlist) {
				if(b.left == start)
					continue;
				workList.push(b);
			}
			
			while(true) {
				if(workList.isEmpty()) {//모든 검색 루트 완료
					history.clear();
					break;
				}
				//System.out.println("workList:"+workList);
				Branch item = workList.pop();
				
				if((history.size()>0 && history.contains(item.left)) || item.left == start) {
					//System.out.println("순환발견. 탐색 종료. 히스토리 정리");
					if(!workList.isEmpty()) {
						clear(history,workList.lastElement());
					}
					continue;					
				}	
				history.push(item.right);
				
//				right = Integer.valueOf(item.right);
				left = Integer.valueOf(item.left);
				
				if(hackList.get(start) == null) {
					hackList.put(start,new HashSet<Integer>());
				}				
				
				hackList.get(start).add(left);
				//aa
				Set<Integer> complete = hackList.get(left);
				if(complete != null) {
					System.out.println("start:"+start+"left:"+left+ " complete:"+complete.toString());
					if(complete.size()>=max)
					for(Integer i : complete) {
						hackList.get(start).add(i);
					}
					continue;
				}
				
				List<Branch> nextBranchItemlist = root.get(left);
				//System.out.println("nextBranchItemlist:"+nextBranchItemlist);
				if(nextBranchItemlist != null) {
					for(Branch b : nextBranchItemlist) {
						if(b.left == start || (history.size()>0 && history.contains(item.left)))
							continue;
						workList.push(b);
					}					
				}
				else {
					if(!workList.isEmpty()) {
						clear(history,workList.lastElement());
					}
				}
			}
			System.out.println("hackList:"+hackList);
//			first=false;
		}
		
		System.out.println("결과:\n"+hackList);
		showMemory();
	}
	
	private void clear(Stack<Integer> history, Branch next) {
		while(history.isEmpty()) {
			Integer deleted = history.pop();
			if(deleted == next.right) {//이전 히스토리 찾음
				return;
			}
		}
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
//		return new Branch(randomIntN(100), randomIntN(200));
		return new Branch(100, 200);
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
//		//System.out.println("left:"+left+" right:"+right);
		if (left == right)
			right = randomIntN(max, left);
		return right;
	}
	
	
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
	
	public static void main(String[] args) {
		new HakingList();
	}
}
