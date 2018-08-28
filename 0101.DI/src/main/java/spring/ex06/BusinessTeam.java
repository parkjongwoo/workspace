package spring.ex06;

import org.springframework.stereotype.Component;

@Component
public class BusinessTeam implements Department {

	@Override
	public void work() {
		System.out.println(this.getClass().getName()+" 근무중");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"입니다.";
	}
	
	
}
