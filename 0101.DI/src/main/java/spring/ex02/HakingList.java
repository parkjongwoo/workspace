package spring.ex02;

import java.util.ArrayList;
import java.util.List;

public class HakingList {
	
	public HakingList() {
		
		Branch request = getRequestBranch();
		List<Branch> list = new ArrayList<Branch>();
		
		System.out.println("컴퓨터대수:"+request.left+" 신뢰갯수:"+request.right);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<request.right;i++) {
			Branch b = getBranch();
			list.add(b);
			sb.append(b).append("   ");
			if(i%5==0) {
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	private Branch getRequestBranch() {
		return new Branch(randomIntN(), randomIntM());
	}
	private Branch getBranch() {
		return new Branch(randomIntN(), randomIntN());
	}
	private int randomIntN() {
		return (int)(Math.round(Math.random() * 10000) + 1);
	}
	private int randomIntM() {
		return (int)(Math.round(Math.random() * 100000) + 1);
	}	
	
	public static void main(String[] args) {
		new HakingList();
	}
	
	class Branch{
		public int left;
		public int right;
		
		public Branch() {}
		public Branch(int left, int right) {
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			return left+":"+right;
		}
	}
}
