package spring.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ex03.Employee;

public class Test_Autowire {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex04/bean_autowire_practice.xml");
		
		Employee e = (Employee)ctx.getBean("employee");
		System.out.println(e.toString());
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
