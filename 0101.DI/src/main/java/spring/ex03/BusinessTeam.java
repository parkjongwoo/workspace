package spring.ex03;

public class BusinessTeam implements Department {

	@Override
	public void work() {
		System.out.println(this.getClass().getName()+" 근무중");
	}

}
