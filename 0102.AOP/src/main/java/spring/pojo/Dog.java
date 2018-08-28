package spring.pojo;

public class Dog {
	public void eat() {
		System.out.println("강아지가 먹습니다.");
	}
	
	public void eat(String feed) {		
		System.out.println("강아지가 "+feed+"를 먹습니다.");
	}
	
	public String eat(String feed, int count) {
		String msg = "강아지가 "+feed+"를 "+count+"개 먹습니다.";
		return msg;
	}
}
