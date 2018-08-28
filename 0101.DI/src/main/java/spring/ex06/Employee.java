package spring.ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//context:component-scan 을 xml에 등록하면 해당 패키지의 @Component 지정한 class를 bean으로 등록한다.
@Component
public class Employee {
	String name;
	
//	@Autowired//멤버변수에 사용 
//	Department dept;
	
//	@Autowired//멤버변수에 사용
//	@Qualifier("b2")//xml에 같은 타입 여러개 선언되어 있는 경우 id를 지정해서 특정해줘야함.
	
	@Autowired
	Department dept;

	public Employee() {
		super();
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	@Autowired//생성자에 사용
	public Employee(Department dept) {
		this("기본사원");
		this.dept = dept;
	}
	
	public Employee(String name, Department dept) {
		this("기본사원");
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDept() {
		return dept;
	}
//	@Autowired//메소드에 사용
//	@Qualifier("b2")
	public void setDept(Department dept) {
		this.dept = dept;
		this.dept.work();
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + "]";
	}
}
