package spring.ex01.practice;

public class Banana implements Fruit {
	
	private String name;
	private int sugar;
	
	public Banana() {
		this("기본당도",10);
	}
	
	public Banana(String name, int sugar) {
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
