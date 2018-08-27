package spring.ex01.practice;

import java.util.ArrayList;
import java.util.List;

public class FruitStore {
	private List<Fruit> stock;
	
	public FruitStore() {
		
		stock = new ArrayList<Fruit>();
	}
	
	public FruitStore(Fruit f) {
		this();
		addStock(f);
	}
	
	public FruitStore addStock(Fruit f) {
		stock.add(f);
		
		return this;
	}
	
	public void printAllFuitInStock() {
		StringBuffer sb = new StringBuffer();
		for(Fruit f : stock) {
			sb.append(f.getName()).append("의 당도").append(f.getSugar()).append('\n');
		}
		
		System.out.println(sb);
	}
}
