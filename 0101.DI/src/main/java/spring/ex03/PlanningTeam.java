package spring.ex03;

public class PlanningTeam implements Department {
	@Override
	public void work() {
		System.out.println(this.getClass().getName()+" 근무중");
	}
}
