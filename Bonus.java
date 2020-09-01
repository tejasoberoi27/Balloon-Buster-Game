package lab4;

import java.util.ArrayList;



public final class Bonus {

	private int maxscore;
	
	public int getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(int maxscore) {
		this.maxscore = maxscore;
	}
	public final ArrayList<Prize> deepCopy(int n, ArrayList<Prize> winning)
	{
		 ArrayList<Prize> copy = new  ArrayList<Prize>();
		for(int i=0;i<n;i++)
		{
			copy.add(winning.get(i).clone());
		}
		return copy;
	}
		//	
		public final ArrayList<Prize> findSequence(ArrayList<Prize> winning)
		{
			int n= winning.size();
			ArrayList<Prize> sample = deepCopy(n,winning);
			ArrayList<Prize> solution = new ArrayList<Prize>(); 
			int maxscore=0;
			while(n!=2)
			{
				int maxprod =0;
				int pos=-1;
				int prev=1;
				int next=1;
				for(int j=0;j<n;j++)
				{
					int newp =1;

					int cur = sample.get(j).getBonuspoints();
					if(j>0)
						prev  = sample.get(j-1).getBonuspoints();
					if(j<n-1)
						next = sample.get(j+1).getBonuspoints();
					newp= prev*cur*next;
					if(newp>maxprod)
					{
						maxprod=newp;
						pos = j;
					}
					
				}
				

				maxscore+= maxprod;
				solution.add(sample.get(pos).clone());
				sample.remove(pos);
				n-=1;
			}
			if(n==2)
			{
				int cur = sample.get(0).getBonuspoints();
				int other = sample.get(1).getBonuspoints();
				if(cur<=other)
				{ solution.add(sample.get(0).clone());
					solution.add(sample.get(1).clone());
					maxscore+=(cur*other+other);
				}
				else
				{
					solution.add(sample.get(1).clone());
					solution.add(sample.get(0).clone());
					maxscore+=(cur*other+cur);
				}
			}
			this.maxscore = maxscore;
			return solution;
		}
		
	}
