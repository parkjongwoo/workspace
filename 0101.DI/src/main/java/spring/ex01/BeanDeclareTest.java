package spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ex01.practice.Apple;
import spring.ex01.practice.Banana;
import spring.ex01.practice.FruitStore;

public class BeanDeclareTest {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
						"spring/ex01/bean_declare.xml");
		
		//xml에 등록한 
		Dog dog = (Dog)ctx.getBean("dog");
		dog.jump();
		
		Cat cat = (Cat)ctx.getBean("cat");
		cat.scratch();
		
		Dog dog2 = (Dog)ctx.getBean("dog2");
		dog2.eat();
		
		
		Apple a = (Apple)ctx.getBean("apple");
		Apple ah = (Apple)ctx.getBean("apple_honey");
		
		Banana b = (Banana)ctx.getBean("banana");
		Banana bh = (Banana)ctx.getBean("banana_honey");
		
		FruitStore store = (FruitStore)ctx.getBean("fruitStore");
		
		
		store.addStock(a).addStock(ah).addStock(b);
		
		store.printAllFuitInStock();
		
		store.addStock(bh);
		
		store.printAllFuitInStock();
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
