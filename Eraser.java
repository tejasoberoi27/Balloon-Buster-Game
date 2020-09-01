package lab4;

public class Eraser extends StationeryItem {

	public Eraser() {
		super("Eraser", 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Eraser clone()
	{
		Eraser p = (Eraser) super.clone();
		return p;
	}
}
