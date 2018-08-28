package spring.pojo;

public class Cat {
	public void eat() {
		System.out.println("고양이가 먹습니다.");
	}
	
	public void eat(String feed) {		
		System.out.println("고양이가 "+feed+"를 먹습니다.");
	}
	
	public String eat(String feed, int count) {
		String msg = "고양이가 "+feed+"를 "+count+"개 먹습니다.";
		return msg;
	}
}
