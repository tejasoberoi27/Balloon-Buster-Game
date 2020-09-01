package lab4;

public class Snickers extends CandyBar {

	public Snickers() {
		super("Snickers", 5);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Snickers clone()
	{
		Snickers p = (Snickers) super.clone();
		return p;
	}

}
