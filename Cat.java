package lab4;

public class Cat extends SoftToy {

	public Cat() {
		super("Cat", 40);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cat clone()
	{
		Cat p = (Cat) super.clone();
		return p;
	}
}
