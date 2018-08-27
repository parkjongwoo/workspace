package spring.ex01;

public class Dog {
	private String name;
	private String food;
	private Cat cat;
	public Dog() {
		System.out.println("기본생성자");
	}
	
	public Dog(String name, String food, Cat cat) {
		super();
		System.out.print("두번째 생성자");
		this.name = name;
		this.food = food;
		this.cat = cat;
		
	}
	
	public void jump() {
		System.out.println("jump!!");
	}
	
	public void eat() {
		System.out.println(name+"이 "+food+"를 냠냠!!");
	}
}
