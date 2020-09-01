package lab4;

public class Dog extends SoftToy {

	public Dog() {
		super("Dog", 50);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Dog clone()
	{
		Dog p = (Dog) super.clone();
		return p;
	}

}
