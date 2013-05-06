
import java.util.Arrays;

public class Bonuses {
	
	static int last = 0;

	public static int[] getDivision(int[] points) { 

		int total = 0;
		int [] percent = new int [points.length];
		double left_over = 0;
		double tmp = 0;
		for(int i : points)
			total+=i;
		for(int i = 0; i < points.length; i++) { 
			tmp = ((double)points[i]/total)*100;
			left_over += tmp - Math.floor(tmp);
			percent[i] = (int)Math.floor(tmp);
		}
		int bonus = (int) Math.ceil(left_over);
		int [] tmp_points = copyArr(points);
		Arrays.sort(tmp_points);
		for(int i = tmp_points.length - 1; i >= 0; i--){
			int key = find(points, tmp_points[i]);
			
			if (bonus != 0){
				percent[key]++;
				bonus--;
			}
			else break;
		}
		return percent;
	}

	public static void main (String [] args) { 
	
		int [] x = getDivision(new int[]{5,5,5,5,5,5});
		System.out.println(x[0] + " " + x[1] + " " + x[2]);
	}

	public static int find(int [] src, int value) { 

		for(int i = 0; i < src.length; i++) {
			if(value == src[last]) {
				last++;
				return last-1;
			}
			if(value == src[i]) {
				return i;
			}
			
		}
		return -1;
	}
	public static int [] copyArr(int [] src) { 
		
		int [] dest = new int[src.length];
		for(int i = 0; i < src.length; i++)
			dest[i] = src[i];
		return dest;
	}
	

}
