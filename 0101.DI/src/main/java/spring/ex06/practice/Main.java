package spring.ex06.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex06/practice/school_bean_def.xml");
		
		School school = (School)ctx.getBean("school");
		
		System.out.println(school.toString());
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
