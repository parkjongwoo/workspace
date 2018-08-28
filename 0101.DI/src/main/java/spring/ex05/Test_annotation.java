package spring.ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean에 annotation 추가 및 사용 방법
 * 사전준비
 * beans.xml 에 네임스페이스 추가(context 계열 태그 로드)
 * xmlns:context="http://www.springframework.org/schema/context"
 * xsi:schemaLocation= ---------------에 추가
 * http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
 * 
 * 1. beans.xml에 <context:annotation-config/> 등록
 * 
 * 2. autowire 사용할 bean 각 위치(변수,생성자,setter,method)에 \@Autowired annotation 사용 
 * 
 * 3. javax.inject 도 autowire와 유사한 기능제공 \@Inject
 * 
 * pom.xml 에 프로젝트 의존성 추가후 사용 : <!-- @inject annotation -->
 * @author goott3-4
 *
 */
public class Test_annotation {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex05/bean_annotation.xml");
		
		Employee e = (Employee)ctx.getBean("employee");
		System.out.println(e.toString());
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
