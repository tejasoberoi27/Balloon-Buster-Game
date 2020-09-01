package lab4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public final class Game {
	private ArrayList<Player>players;
	private ArrayList<Prize>prizes;
	private Organizer Org;
	private Player player;
	private Board board;
	private ArrayList<Pair> selection;
	private int cntAssigned;


	public Game(Organizer Org) {
		this.players= new ArrayList<Player>();
		this.prizes = new ArrayList<Prize>();
		this.selection = new ArrayList<Pair>();
		prizes.add(new Dog());
		prizes.add(new Cat());
		prizes.add(new Rabbit());
		prizes.add(new KitKat());
		prizes.add(new Snickers());
		prizes.add(new FiveStar());
		prizes.add(new Pen());
		prizes.add(new Pencil());
		prizes.add(new Eraser());

		this.Org = Org;
		this.cntAssigned=0;

	}

	public final boolean checkIfNew(Player P)
	{
		for(int i=0;i<players.size();i++)
		{
			if(P.getsName().equalsIgnoreCase(players.get(i).getsName()))
			{
				return false;
			}
		}
		return true;
	}
	

	
	public final void Restart(Player player,int bonus)
	{
		if(bonus==0)
		{
		this.player= player;
		Org.setPlayer(player);
		board = new Board();
		selection = Org.tagBalloons();
		this.assignPrizes();
		return;
		}
		else
		{
			player.displayStrategy();
		}

	}

	//	public final void assignPrize(Prize prize)
	//	{
	//		Pair current= selection.get(cntAssigned);
	//		int i = current.getX();
	//		int j= current.getY();
	//		board.getBalloons().get(i).get(j).setPrize(prize);	
	//	}

	//	private final void simulateShot() {
	//		// TODO Auto-generated method stub
	//		for(int i =0;i<10;i++)
	//		{
	//			 player.takeAim();
	//		}
	//	}

	public final void assignPrizes()
	{

		while(cntAssigned<50)
		{
			int size=0;
			boolean bMarked[]=new boolean[9];
			while(size<9 && cntAssigned<50)
			{
				int ch = new Random().nextInt(9);
				while(bMarked[ch]==true)
				{
					ch = new Random().nextInt(9);
				}
				Pair current= selection.get(cntAssigned);

				switch (ch) {
				case 0:
					board.assignPrize(current,new Dog());					
					break;
				case 1:
					board.assignPrize(current,new Cat());
					break;
				case 2:
					board.assignPrize(current,new Rabbit());
					break;
				case 3:
					board.assignPrize(current,new KitKat());
					break;
				case 4:
					board.assignPrize(current,new Snickers());
					break;
				case 5:
					board.assignPrize(current,new FiveStar());
					break;
				case 6:
					board.assignPrize(current,new Pen());
					break;
				case 7:
					board.assignPrize(current,new Pencil());
					break;
				case 8:
					board.assignPrize(current,new Eraser());
					break;

				default:
					break;
				}
				size+=1;
				cntAssigned+=1;
			}


		}
	}

	public final void compareGuess(Pair p1,int guess) {
		if(0<=guess &&guess<=4)
		{Prize gPrize = player.giveObject(guess);
		Prize real = board.getBalloons().get(p1.getX()).get(p1.getY()).getPrize();
		Org.compareGuess(gPrize, real);

		}
		else
		{
			System.out.println("Invalid choice");
		}
	}

	public final boolean checkifPrize(Pair pair) {
		// TODO Auto-generated method stub
		if(board.getBalloons().get(pair.getX()).get(pair.getY()).getPrize()!=null)
		{
			return true;
		}
		else
		{
			player.updateScore(3,null,null);
			return false;
		}
	}

	public final void displayScore()
	{
		System.out.println(player.getPoints()+" points");
	}

	public final void displaySummary()
	{
		player.displaySummary();
	}

//	public void displayBoard()
//	{
//		for(int i=0;i<10;i++)
//		{
//			for(int j=0;j<10;j++)
//			{
//				Prize p =board.getBalloons().get(i).get(j).getPrize();
//				if(p!=null)
//				System.out.println(i+""+j+p.getsPrize());
//				else
//					System.out.println(i+""+j);					
//			}
//		}
//
//	}

}
