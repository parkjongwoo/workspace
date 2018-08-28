package spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.pojo.Dog;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/aop_def.xml");
		
		Dog dog = (Dog)ctx.getBean("dog");
		
		dog.eat();
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
