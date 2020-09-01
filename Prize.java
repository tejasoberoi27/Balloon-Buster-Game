package lab4;


public class Prize implements Cloneable{
	private final String sType;
	private final String sPrize;
	private final int iWeight;
	private final int bonuspoints;
	public Prize(String Stype,String sPrize,int weight)
	{
		this.sType = Stype;
		this.sPrize = sPrize;
		this.iWeight  = weight;
		if(this.getsType().equalsIgnoreCase("Soft Toy"))
		{
			this.bonuspoints = 30;
		}
		else if(this.getsType().equalsIgnoreCase("Candy Bar"))
		{
			this.bonuspoints = 20;
		}
		else
		{
			this.bonuspoints = 10; 
		}
	}
	public String getsPrize() {
		return sPrize;
	}
	public String getsType() {
		return sType;
	}
	public int getiWeight() {
		return iWeight;
	}

	@Override
	public	boolean	equals(Object	o1)	{	
		if(o1	!=	null	&&	getClass()	==	o1.getClass())	{	
			Prize	o	=	(Prize)	o1;	//type	casting	
			return	(sType.equalsIgnoreCase(o.sType)	&&	iWeight==o.iWeight && sPrize.equalsIgnoreCase(o.sPrize));	
		}	
		else	{return	false;	
		}
	}
	@Override
	public Prize clone(){
		// TODO Auto-generated method stub
		try {
			Prize copy = (Prize) super.clone(); 
			return copy;
			} catch (CloneNotSupportedException e) {
			// this will never happen
			return null;
			}		
	}
	public int getBonuspoints() {
		return bonuspoints;
	}
	
	

}

