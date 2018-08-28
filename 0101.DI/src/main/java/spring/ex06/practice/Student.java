package spring.ex06.practice;

import org.springframework.stereotype.Component;

@Component
public class Student extends BaseHuman{
	
	
	public Student() {
		this("기본 학생");
	}
	
	public Student(String name) {
		super();
	}
	
	public void study() {
		System.out.println("공부합니다.");
	}

	@Override
	public String toString() {
		study();
		return "Student [name=" + name + "]";
	}
	
	
}
