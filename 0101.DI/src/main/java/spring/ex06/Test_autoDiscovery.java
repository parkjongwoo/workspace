package spring.ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ex06.Employee;

/***
 * context:component-scan , \@Component 등록 및 사용
 * 사전준비
 * beans.xml 에 네임스페이스 추가
 * xmlns:context="http://www.springframework.org/schema/context"
 * xsi:schemaLocation= ---------------에 추가
 * http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
 * 
 * 1. beans.xml에 context:component-scan 등록
 * 
 * 2. 가져올 bean class에 \@Component annotation 추가
 * 
 * 3. ApplicationContext 에서 가져올때 이름은 클래스명(첫글자 소문자로 변경) 사용
 * @author goott3-4
 *
 */
public class Test_autoDiscovery {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex06/bean_auto_discovery.xml");
		
		//
		Employee e = (Employee)ctx.getBean("employee");
		System.out.println(e.toString());
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
