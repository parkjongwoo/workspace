package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect//aop:aspect 태그 대체
public class Animal {
	
	@Pointcut("execution(* *.eat(..))")//aop:pointcut 대체. 메소드명이 id로 사용됨
	public void eating() {
		
	}
	
	@Before("eating()")//aop:before 대체. 연관 pointcut을 id 지정
	public void rush() {
		System.out.println("주민에게 달려오다!!");
	}
	@After("eating()")//aop:after 대체. 연관 pointcut을 id 지정
	public void sleep() {
		System.out.println("자자!!");
	}
}
