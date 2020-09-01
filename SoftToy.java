package lab4;

public class SoftToy extends Prize{
	public SoftToy(String sPrize,int weight)
	{
		super("Soft Toy",sPrize,weight);
		
	}
	
	@Override
	public SoftToy clone()
	{
		SoftToy p = (SoftToy) super.clone();
		return p;
	}
	
	
}
