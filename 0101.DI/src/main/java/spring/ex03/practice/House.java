package spring.ex03.practice;

import java.util.List;
import java.util.Set;

public class House {
	private int price;
	private String addr;
	private List<Furniture> furnitures;
	private Set<Electronic> electronics;
	
	public House() {
		this("욕지도 욕지면");
	}
	
	public House(String addr) {
		this.price = 50;
		this.addr = addr;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public List<Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(List<Furniture> furnitures) {
		this.furnitures = furnitures;
	}

	public Set<Electronic> getElectronics() {
		return electronics;
	}

	public void setElectronics(Set<Electronic> electronics) {
		this.electronics = electronics;
	}
	
	
}
