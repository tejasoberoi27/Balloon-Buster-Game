package lab4;

public class FiveStar extends CandyBar {

	public FiveStar() {
		super("Five-Star", 7);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public FiveStar clone()
	{
		FiveStar p = (FiveStar) super.clone();
		return p;
	}

}
