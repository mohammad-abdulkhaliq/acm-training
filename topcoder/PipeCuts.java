
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class PipeCuts {
	
	public static double probability(int[] weldLocations, int L)  {
		
		ArrayList<Boolean> valid_cuts = new ArrayList<Boolean>();
		int k = 0;
		boolean valid = false;
		for(int i = 0; i < weldLocations.length; i++) { 
			for(int j = 0; j < weldLocations.length; j++) { 
				valid = helper(weldLocations[i], weldLocations[j], L);
				System.out.println(weldLocations[i] + " " + weldLocations[j] + " " + valid);
				if(valid)
					valid_cuts.add(new Boolean(true));
			}
		}
		double n = valid_cuts.size();
		System.out.println(n);
		double d = (double)(fac(weldLocations.length-1));
		System.out.println(d);
		return n/d;  
		
	}
	
	public static boolean helper(int cut1, int cut2, int L) { 
		int x = cut1 - cut2;
		if(x <= 0)
			return false;
		int y = cut2;
		int z = 100 - cut1;
		
		if((x > L) || (y > L) || (z > L))
			return true;
		return false;
	}
	
	
	public static int fac(int n) { 
		if(n==0)
			return 0;
		else
			return fac(n-1)+n;
	}
	
	public static void main(String [] args) { 
		
		//System.out.println(probability(new int [] {25,50,75}, 25));
		//System.out.println(probability(new int [] {25,50,75}, 50));
		System.out.println(probability(new int [] {99, 88, 77, 66, 55, 44, 33, 22, 11}, 50));
	}

}
