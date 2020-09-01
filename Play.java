package lab4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call p1 method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(
				new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO add check for eof if necessary
			tokenizer = new StringTokenizer(
					reader.readLine() );
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble( next() );
	}
}

public class Play {

	private static Game game;

	public int checkIfSame(String[] arr, int n,String name)
	{
		for(int i =0;i<n;i++)
		{
			if(arr[i]!=null)
			{
				if(arr[i].equalsIgnoreCase(name))
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean check(String s,String choice[],int cnt)
	{
		for(int i =0;i<cnt;i++)
		{
			if(s.equalsIgnoreCase(choice[i]))
			{
				System.out.println("Choice Repeated");
				return false;
			}
		
		}
		
		if(s.equalsIgnoreCase("Dog"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("Cat"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("Rabbit"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("KitKat"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("Snickers"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("FiveStar"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("Pen"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("Pencil"))
		{
			return true;
		}
		else if(s.equalsIgnoreCase("Eraser"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Play p1 = new Play();
		Reader.init(System.in);
		Organizer Org = new Organizer();
		Game game = new Game(Org);
		System.out.println("Enter Number of Players");
		int n = Reader.nextInt();
		String arr[]=new String[n];
		ArrayList<Player> parr= new ArrayList<Player>(n);
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter player No."+(i+1)+"\'s Name ");
			String name = Reader.next();
			arr[i]= name;
		}
		
		for(int i=0;i<n;i++)
		{

			String name = arr[i];
			System.out.println("-- "+name+" started playing--");
			int index = p1.checkIfSame(arr, n, name);
			Player p;
			if(index>=0 && index<i)
			{
//				System.out.println("in");				
				p = parr.get(index);
				game.Restart(p,1);
			}
			else
			{
				p = new Player(name);
				parr.add(p);
				String choices[] = new String[5];
				int cnt =0;
				while(cnt<5)
				{
					choices[cnt]= Reader.next();
					if(p1.check(choices[cnt],choices,cnt))
					{
						cnt++;
					}
					else
					{
						System.out.println("Invalid choice! Enter again!");						
					}

					
				}
				//				System.err.println(choices);
				p.chooseUnique5(choices);
				game.Restart(p,0);
//				game.displayBoard();
				boolean bHit[][] = new boolean[10][10];
				for(int z=0;z<10;z++)
				{
					System.out.println("Choose a coordinate");
					Pair pair = new Pair();
					int valid =1;
					int y= Reader.nextInt();
					if(y<0 || y>9)
						valid =0;
					int j = Reader.nextInt();
					if(j<0 || j>9)
						valid =0;
					if(valid==1)
						pair =new Pair(y,j);
					else
					{
						System.out.println("invalid input");
					}

					while( valid==1  && bHit[y][j]==true )
					{
						System.out.println("Already chosen, Choose again");
						y= Reader.nextInt();
						j = Reader.nextInt();
						if(y<0 || y>9)
							valid =0;
						if(j<0 || j>9)
							valid =0;
						if(valid==1)
						pair =new Pair(y,j);
					}
					if(valid==0)
						continue;
					bHit[y][j]=true;
					if(game.checkifPrize(pair))
					{
						System.out.println("Guess prize");
						int guess = Reader.nextInt();
						while(!(guess>=0 && guess<5))
						{
							System.out.println("Invalid guess! Guess again");
							guess = Reader.nextInt();
						}
						game.compareGuess(pair,guess);
					}
					else
					{
						System.out.println("Sorry, no prize here");
					}
					game.displayScore();
				}

				game.displaySummary();

			}


		}



	}
}
