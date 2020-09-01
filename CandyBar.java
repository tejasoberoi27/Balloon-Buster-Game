package lab4;

public class CandyBar extends Prize{
	public CandyBar(String sPrize,int weight)
	{
		super("Candy Bar",sPrize,weight);
		
	}
	@Override
	public CandyBar clone()
	{
		CandyBar p = (CandyBar) super.clone();
		return p;
	}
}
