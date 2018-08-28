package spring.ex05;

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
