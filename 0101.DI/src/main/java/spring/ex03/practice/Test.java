package spring.ex03.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
						"spring/ex03/practice/collection_bean_practice.xml");
		
		House yongsan = (House)ctx.getBean("house_yongsan");
		House gangnam = (House)ctx.getBean("house_gangnam");
		House abudi = (House)ctx.getBean("house_uae_Abu_Dhabi");
		
		
		System.out.println("info of yongsan_house");
		
		System.out.println("addr: "+yongsan.getAddr());
		System.out.println("price: "+yongsan.getPrice());
		System.out.println("funiture list:");
		for(Furniture f : yongsan.getFurnitures()) {
			f.putIn();
			f.putOut();
		}
		
		System.out.println("info of house_gangnam");
		
		System.out.println("addr: "+gangnam.getAddr());
		System.out.println("price: "+gangnam.getPrice());
		System.out.println("funiture list:");
		for(Furniture f : gangnam.getFurnitures()) {
			f.putIn();
			f.putOut();
		}
		
		System.out.println("info of house_uae_Abu_Dhabi");
		
		System.out.println("addr: "+abudi.getAddr());
		System.out.println("price: "+abudi.getPrice());
		System.out.println("funiture list:");
		for(Furniture f : abudi.getFurnitures()) {
			f.putIn();
			f.putOut();
		}
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
