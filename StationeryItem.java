package lab4;

public class StationeryItem extends Prize{

	public StationeryItem(String sPrize, int weight) {
		super("Stationery Item", sPrize, weight);
	}
	
	@Override
	public StationeryItem clone()
	{
		StationeryItem p = (StationeryItem) super.clone();
		return p;
	}

}
