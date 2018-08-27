package spring.ex03.practice;

public abstract class BasicFurniture implements Furniture {

	@Override
	public void putIn() {
		System.out.println(this.getClass().getSimpleName()+"에 내용물을 넣었습니다.");
	}

	@Override
	public void putOut() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName()+"에 내용물을 뺐습니다.");

	}

}
