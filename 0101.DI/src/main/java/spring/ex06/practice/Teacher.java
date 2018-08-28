package spring.ex06.practice;

import org.springframework.stereotype.Component;

@Component
public class Teacher extends BaseHuman {
	
	
	public Teacher() {
		this("기본 선생");
	}
	
	public Teacher(String name) {
		super();
	}
	
	public void teach() {
		System.out.println("가르칩니다.");
	}

	@Override
	public String toString() {
		teach();
		return "Teacher [name=" + name + "]";
	}
	
	
}
