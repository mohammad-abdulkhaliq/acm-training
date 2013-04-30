
import java.util.Arrays;

public class Bonuses {

	public static int[] getDivision(int[] points) { 

		int total = 0;
		int [] percent = new int [points.length];
		double left_over = 0;
		double tmp = 0;
		for(int i : points)
			total+=i;
		for(int i = 0; i < points.length; i++) { 
			tmp = (points[i]/total)*100;
			left_over += tmp - Math.floor(tmp);
			percent[i] = (int)Math.floor(tmp);
		}
		//Arrays.sort(points);
		int bonus = (int) ((left_over/total) * 100);
		int [] tmp_points = copyArr(points);
		Arrays.sort(tmp_points);
		for(int i = tmp_points.length - 1; i >=0;  i++){
			int key = find(percent, tmp_points[i]);
			if (bonus != 0){
				percent[key]+=1;
				bonus --;
			}
			else break;
		}
		return percent;
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
	public static int [] copyArr(int [] src) { 
		
		int [] dest = new int[src.length];
		for(int i = 0; i < src.length; i++)
			dest[i] = src[i];
		return dest;
	}

}