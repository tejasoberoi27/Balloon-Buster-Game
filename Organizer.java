package lab4;

import java.util.*;

public final class Organizer {
	private ArrayList<Pair> selection;
	private boolean bTag[][];
	private Player player;
	public Organizer() {
		this.selection = new ArrayList<Pair>(50);
		this.bTag = new boolean[10][10];
	}

	
	public void setPlayer(Player player) {
		this.player = player;
	}


	public final ArrayList<Pair> tagBalloons()
	{
		for(int k=0;k<50;k++)
		{
			int i= new Random().nextInt(10);
			int j = new Random().nextInt(10);
			Pair p1 =new Pair(i,j);
			while(bTag[i][j]==true)
			{
				i= new Random().nextInt(10);
				j = new Random().nextInt(10);
				p1 =new Pair(i,j);
			}
			bTag[i][j]=true;
			selection.add(p1);
		}
		return this.selection;

	}
	
	public final void compareGuess(Prize guess,Prize real)
	{
		if( real.equals(guess))
		{
			System.out.println("You won "+real.getsPrize());
			Prize won = real.clone();
			player.collectPrize(won);
			player.updateScore(2,guess.clone(),real.clone());
		}
		else
		{
			System.out.println("Sorry, you guessed wrong, it was "+real.getsPrize());
			player.updateScore(1,guess.clone(),real.clone());
		}

		
		
	}
}
