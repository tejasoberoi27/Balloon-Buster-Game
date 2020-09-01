package lab4;

public class Pen extends StationeryItem {

	public Pen() {
		super("Pen", 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pen clone()
	{
		Pen p = (Pen) super.clone();
		return p;
	}
}
