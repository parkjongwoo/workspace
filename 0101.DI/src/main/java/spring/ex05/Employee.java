package spring.ex05;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

//@autowired annotation: java 클래스에 annotation으로 지정하는 방법
//1.객체변수
//2.생성자
//3.setter
//4.일반메소드
public class Employee {
	String name;
	
//	@Autowired//멤버변수에 사용 
//	Department dept;
	
//	@Autowired//멤버변수에 사용
//	@Qualifier("b2")//xml에 같은 타입 여러개 선언되어 있는 경우 id를 지정해서 특정해줘야함.
	
	@Inject
	@Named("b2")
	Department dept;
	
	@Autowired(required=false)
	FinanceTeam ft;
	
	public FinanceTeam getFt() {
		return ft;
	}

	public void setFt(FinanceTeam ft) {
		this.ft = ft;
	}

	public Employee() {
		super();
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
//	@Autowired//생성자에 사용
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
		return "Employee [name=" + name + ", dept=" + dept + ", ft=" + ft + "]";
	}
}
