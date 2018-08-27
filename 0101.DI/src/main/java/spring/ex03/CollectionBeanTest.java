package spring.ex03;

import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex03/collection_declare.xml");
		
		Company c = (Company)ctx.getBean("company_list");
		
		for(Department d : c.getDeptList()) {
			d.work();
		}
		
		for(Department d : c.getDeptSet()) {
			d.work();
		}
		
		for(Entry<String,Department> e : c.getDeptMap().entrySet()) {
			System.out.println(e.getKey()+":"+e.getValue());
			e.getValue().work();
		}
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
