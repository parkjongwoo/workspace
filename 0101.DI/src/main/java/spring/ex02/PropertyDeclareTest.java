package spring.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyDeclareTest {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
						"spring/ex02/property_declare.xml");
		
		Department d = ((Department)ctx.getBean("department"));
		
		System.out.println(d);
		
		Employee e = ((Employee)ctx.getBean("employee")); 
		
		System.out.println(e);
		System.out.println(e.getDept());
		
		Employee e2 = ((Employee)ctx.getBean("employee_2")); 
		
		System.out.println(e2);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
