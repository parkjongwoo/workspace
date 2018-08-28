package spring.ex04.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ex03.practice.House;

public class Test_DefaultAutowire {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring/ex04/practice/collection_bean_autowire_practice.xml");
		
		House yongsan = (House)ctx.getBean("house_yongsan");
		House gangnam = (House)ctx.getBean("house_gangnam");
		House abudhabi = (House)ctx.getBean("house_uae_Abu_Dhabi");
		
		System.out.println("yongsan:"+yongsan);
		System.out.println("gangnam:"+gangnam);
		System.out.println("abudhabi:"+abudhabi);
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
