package lab4;

//import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class Player {
	private String sName;
	//	private int iShotsLeft;
	private int points;
	private ArrayList<Prize>alSelection;
	private ArrayList<Prize>strategy;
	private int iArr[];
	private int maxScore;
//	private int bonuslist[];
	private boolean bHit[][];
	private ArrayList<Prize> Winning = new ArrayList<Prize>(); 
	public Player(String sName) {
		this.alSelection =  new ArrayList<Prize>(5);
		this.strategy = new ArrayList<Prize>();
		this.sName = sName;
		//		this.iShotsLeft = 10;
		this.points = 0;
		//		this.iArr = new int[100];
		this.bHit = new boolean[10][10];
	}
	public void chooseUnique5(String arr[])
	{
		for(int i=0;i<5;i++)
		{
			String s = arr[i];
			if(s.equalsIgnoreCase("Dog"))
			{
				alSelection.add(new Dog());
			}
			else if(s.equalsIgnoreCase("Cat"))
			{
				alSelection.add(new Cat());
			}
			else if(s.equalsIgnoreCase("Rabbit"))
			{
				alSelection.add(new Rabbit());
			}
			else if(s.equalsIgnoreCase("KitKat"))
			{
				alSelection.add(new KitKat());
			}
			else if(s.equalsIgnoreCase("Snickers"))
			{
				alSelection.add(new Snickers());
			}
			else if(s.equalsIgnoreCase("FiveStar"))
			{
				alSelection.add(new FiveStar());
			}
			else if(s.equalsIgnoreCase("Pen"))
			{
				alSelection.add(new Pen());
			}
			else if(s.equalsIgnoreCase("Pencil"))
			{
				alSelection.add(new Pencil());
			}
			else if(s.equalsIgnoreCase("Eraser"))
			{
				alSelection.add(new Eraser());
			}
			else
			{
				System.out.println("Invalid output");
			}

		}

	}



	//	public Pair takeAim()
	//	{
	//		
	//		int i= new Random().nextInt(10);
	//		int j = new Random().nextInt(10);
	//		Pair p1 =new Pair(i,j);
	//		while(bHit[i][j]==true)
	//		{
	//			i= new Random().nextInt(10);
	//			j = new Random().nextInt(10);
	//			p1 =new Pair(i,j);
	//		}
	//		bHit[i][j]=true;
	//		return p1;
	//		
	//	}


	public final Prize giveObject(int g)
	{

		return alSelection.get(g);
	}

	public final void collectPrize(Prize p)
	{
		Winning.add(p);
	}
	public final void updateScore(int outcome,Prize guess,Prize real) {
	
		if(outcome==1)
		{
			points -= (Math.abs(real.getiWeight()-guess.getiWeight()));
		}
		else if(outcome==2)
		{
			Prize win = real;
			if(win.getsType().equalsIgnoreCase("Soft Toy"))
			{
				this.points = this.points*2 +10;
			}
			else if(win.getsType().equalsIgnoreCase("Candy Bar"))
			{
				this.points = this.points+20;
			}
			else if(win.getsType().equalsIgnoreCase("Stationery Item"))
			{
				this.points = (int)(1.1*this.points) + 5; 
			}
			
		}
		else if(outcome==3)
		{
			points =(int) points/2;
		}
		if(points<0)
		{
			points=0;
		}
		
		
	}
	public final int getPoints() {
		return points;
	}
	
	
	
	public String getsName() {
		return sName;
	}
	public final void displaySummary() {
		// TODO Auto-generated method stub
		System.out.println("--Summary of "+this.sName+"--");

		System.out.println("You have won ");
		if(Winning.size()>0)
		{
		for(int i =0;i<Winning.size();i++)
		{
			if(i!=Winning.size()-1)
			System.out.print(Winning.get(i).getsPrize()+", ");
			else
			{
				System.out.print(Winning.get(i).getsPrize()+". ");				
			}
		}
		}
		else
		{
			System.out.print("nothing");
		}
		System.out.print(" Total points won = "+this.getPoints());
	}
	
	public final void displayStrategy()
	{
		if(this.Winning.size()>0)
		{
		if(this.strategy.size()==0)
		{
			Bonus b1 = new Bonus();
			strategy = b1.findSequence(this.Winning);
			maxScore= b1.getMaxscore();
			System.out.println("Maximum Points ="+ maxScore);
			System.out.println("Strategy = ");
			for(int i =0;i<strategy.size();i++)
			{
				if(i!=strategy.size()-1)
				System.out.print(strategy.get(i).getsPrize()+",");
				else
				System.out.print(strategy.get(i).getsPrize()+".");					
			}
		}
		}
		else
		{
			System.out.println("Did not win anything last time! :(");
		}
	}
	
	




}
