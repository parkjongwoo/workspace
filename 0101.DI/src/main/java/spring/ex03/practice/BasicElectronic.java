package spring.ex03.practice;

public abstract class BasicElectronic implements Electronic {

	@Override
	public void turnOn() {
		System.out.println(this.getClass().getSimpleName()+"을 켰습니다.");
	}

	@Override
	public void turnOff() {
		System.out.println(this.getClass().getSimpleName()+"을 껐습니다.");

	}
	
	@Override
	public String toString() {
		return getClass().getName() + " 가전입니다.";
	}
}
