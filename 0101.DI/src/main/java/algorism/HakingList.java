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
	Set<Integer> allnum = new HashSet<Integer>();
	StringBuffer sb = new StringBuffer();//신뢰관계 목록 출력폼
	
	public HakingList() {
		showMemory();
//		long start = new Date().getTime();
//		////System.out.println(start);		
		Branch request = getRequestBranch();//컴퓨터 번호갯수, 신뢰관계갯수
		int max = request.left;		//컴퓨터번호의 발생가능 최대치
		
		//System.out.println(request.toString());
		for (int i = 0; i < request.right; i++) {// 신뢰관계 갯수만큼 순환
			Branch b = getBranch(max);//신뢰받는 컴퓨터와 신뢰하는 컴퓨터가 동일하지 않게 랜덤 발생
			String key = b.toString();//"신뢰하는 컴퓨터(빈칸)신뢰받는 컴퓨터" 형식으로 키저장 
			if (map.get(key) != null) {//기존에 있는 신뢰관계라면 다시 실행
				i--;
				continue;
			}
			map.put(key, b);//관계저장
			allnum.add(b.left);//전체 컴퓨터 번호 저장
			allnum.add(b.right);
			sb.append(key).append('\n');//출력폼 저장
			if(root.get(b.right)==null)//리스트 저장소가 없으면
			{
				List<Branch> list = new ArrayList<Branch>();//리스트만들고
				list.add(b);//리스트에 branch추가
				root.put(b.right, list);//해당 리스트 루트변수에 저장
			}else {
				root.get(b.right).add(b);//있는 리스트에 branch 저장
			}			
		}
		System.out.println(sb);//신뢰 목록 출력
		////System.out.println("=================");
		////System.out.println("root:"+root);
		
		sb.setLength(0);
//		sb = null;
		map.clear();
		map = null;//신뢰 목록 생성작업용 저장소 삭제
		
		int totalComcnt = allnum.size();//실제 생성된 컴퓨터 번호의 총 대수
		allnum.clear();
		allnum = null;
		Stack<Branch> workList = new Stack<Branch>();//카운팅 작업 목록 저장용 변수(카운트에 추가할 신뢰정보를 쌓고 한개씩 확인하며 카운팅)
		Stack<Integer> history = new Stack<Integer>();//히스토리 저장 변수(뎁스가 올라갈때마다 - 즉, 다음 신뢰정보가 추가될 경우- 우변 번호가 추가됨.순환관계 체크용)
//		Integer right;
		Integer left;//좌항 신뢰 하는 컴퓨터 번호
		Integer start;//우항 신뢰 받는 컴퓨터 번호
//		boolean first = true;
		for(Entry<Integer,List<Branch>> entry : root.entrySet()) {	//우항에 포함된 전체 컴퓨터번호 목록을 순환
			List<Branch> rootItemlist = entry.getValue();//이번 번호의 최상위 신뢰 목록
			start = entry.getKey();//이번 최상위 신뢰대상 번호
			for(Branch b : rootItemlist) {
				if(b.left == start)//right,left동일하면 제외
					continue;
				workList.push(b);//이번회차의 루트 목록 작성
			}
			
			while(true) {//이번회 workList가 비워지거나 (검색완료), 이번 신뢰대상 컴퓨터가 모든 컴퓨터에게 신뢰받는 경우 순환 종료
				if(workList.isEmpty()) {//모든 검색 루트 완료
					break;
				}
				////System.out.println("workList:"+workList);
				Branch item = workList.pop();
				
				if((history.size()>0 && history.contains(item.left)) || item.left == start) {
					////System.out.println("순환발견. 탐색 종료. 히스토리 정리");
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
					//System.out.println("start:"+start+"left:"+left+ " complete:"+complete.toString());		
					
					for(Integer i : complete) {
						if(start == i)continue;
						hackList.get(start).add(i);
					}
					
					if(hackList.get(start).size()>=totalComcnt-1) {
						
						break;
					}
					else {
						if(!workList.isEmpty()) {
							clear(history,workList.lastElement());
						}
						continue;
					}
				}
				
				List<Branch> nextBranchItemlist = root.get(left);
				////System.out.println("nextBranchItemlist:"+nextBranchItemlist);
				if(nextBranchItemlist != null) {
					for(Branch b : nextBranchItemlist) {
						if(b.left == start || (history.size()>0 && history.contains(item.left))) {							
							continue;
						}
						workList.push(b);
					}					
				}
				else {
					if(!workList.isEmpty()) {
						clear(history,workList.lastElement());
					}
				}
			}
			workList.clear();
			history.clear();
			
//			//System.out.println("hackList:"+hackList);
			
//			first=false;
		}
		
		for(Entry<Integer,Set<Integer>> e : hackList.entrySet()) {
			sb.append(e.getKey()).append(':').append(e.getValue().size()).append('\n');
		}
		System.out.println("result======================\n"+sb.toString());
		showMemory();
	}
	
	/**
	 * Branch의 right에 해당하는 컴퓨터번호가 나올때까지 history를 삭제
	 * @param history
	 * @param next
	 */
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
//		return new Branch(randomIntN(200), randomIntN(2000));
		return new Branch(10000, 100000);
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
//		////System.out.println("left:"+left+" right:"+right);
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
