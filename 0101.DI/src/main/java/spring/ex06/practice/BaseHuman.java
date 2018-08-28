package spring.ex06.practice;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseHuman implements Human {
	
	protected String name;
	
	@Autowired
	public BaseHuman() {
		this("기본인간");
	}

	public BaseHuman(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
