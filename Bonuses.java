import java.util.Arrays;


public class Bonuses {
	
	public static int[] getDivision(int[] points) { 
		
		int total = 0;
		double [] perc = new double [points.length];
		double left_over = 0;
		double tmp = 0;
		for(int i : points)
			total+=i;
		for(int i = 0; i < points.length; i++) { 
			tmp = (points[i]/total)*100;
			left_over += Math.floor(tmp) - tmp;
			perc[i] = Math.floor(tmp);
		}
		Arrays.sort(points); 
		while(left_over > 0) { 
			
		}
			
			
		
		
		return null;
	}
	
	public static void main (String [] args) { 
		
		double x = 1.32;
		System.out.println((int)Math.floor(x));
	}
	
	public static int find(int [] src, int key) { 
		
		for(int i = 0; i < src.length; i++)
			if(key == src[i])
				return i;
		return -1;
	}

}
