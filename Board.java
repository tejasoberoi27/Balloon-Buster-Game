package lab4;

import java.util.ArrayList;

public final class Board {
 private ArrayList<ArrayList<Balloon>>balloons ;
 
public Board() {

	this.balloons = new ArrayList<ArrayList<Balloon>>(10);
	this.setup();
	}
	


private final void setup()
{
	for(int i =0;i<10;i++)
	{
		ArrayList <Balloon>row = new ArrayList<Balloon>(10);
		for(int j=0;j<10;j++)
		{
			row.add(new Balloon() );
		}
		this.balloons.add(row);
	}
}

public final void assignPrize(Pair current,Prize prize)
{
	int i = current.getX();
	int j= current.getY();
	this.getBalloons().get(i).get(j).setPrize(prize);	
}

public final ArrayList<ArrayList<Balloon>> getBalloons() {
	return balloons;
}


 
}
