package lab4;

public class Rabbit extends SoftToy {

	public Rabbit() {
		super("Rabbit", 20);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Rabbit clone()
	{
		Rabbit p = (Rabbit) super.clone();
		return p;
	}
}
