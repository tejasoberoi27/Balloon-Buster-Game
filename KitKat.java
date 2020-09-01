package lab4;

public class KitKat extends CandyBar {

	public KitKat() {
		super("Kit-Kat", 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public KitKat clone()
	{
		KitKat p = (KitKat) super.clone();
		return p;
	}
}
