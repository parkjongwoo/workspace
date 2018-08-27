package spring.ex01.practice;

public class Apple implements Fruit {
	
	private String name;
	private int sugar;
	
	public Apple() {
		this("기본사과",10);
	}
	
	public Apple(String name, int sugar) {
		this.name = name;
		this.sugar = sugar;
	}
	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public int getSugar() {
		
		return sugar;
	}

}
