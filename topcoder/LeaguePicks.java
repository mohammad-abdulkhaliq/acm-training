
public class LeaguePicks {
	
	public static int[] returnPicks(int position, int friends, int picks) { 
		
		int p = 1;
		int i = 0;
		int j = 0;
		int n = 0;
		double pck = picks * 1.0;
		double fri = friends * 1.0;
		boolean dir = true;
		int [] fr = new int[friends];
		for(int k = 1; k <= friends; k++)
			fr[k-1] = k;
		helper(fr);
			
		int [] myPicks = new int[(int)Math.ceil(pck/fri)];
		//myPicks[0] = position;
		while (p<=picks) {
			
			
			
			if(fr[i] == position) { 
				myPicks[j] = p;
				j++;
				n++;
			}
			
			if((i == (friends-1)) && dir) { 
				
				i = friends-1;
				p++;
				if(fr[i] == position) { 
					myPicks[j] = p;
					j++;
					n++;
				}
				dir = !dir;
			}
			else if(i == 0 && !dir) { 
				i = 0;
				p++;
				if(fr[i] == position) { 
					myPicks[j] = p;
					j++;
					n++;
				}
				dir = !dir;
			}
			
			if(dir && i < (friends-1))
				i++;
			else if(i > 0)
				i--;
			
			p++;
		}
		int [] ret = new int[n];
		for(i = 0; i < n; i++)
			ret[i] = myPicks[i];
		return ret;
	}
	
	public static void helper (int [] x) { 
		
		for(int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
	}
	
	public static void main (String [] args) {
		
		int [] p = returnPicks(1,2,39);
		helper(p);
	
	}

}
