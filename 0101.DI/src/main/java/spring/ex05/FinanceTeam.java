package spring.ex05;

public class FinanceTeam implements Department {
	
	
	@Override
	public void work() {
		System.out.println(this.getClass().getName()+" 근무중");
	}
}
