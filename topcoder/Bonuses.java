
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		System.out.println(bonus);
		int [] tmp_points = copyArr(percent);
		Map<Integer, ArrayList<Integer>> map = getMap(percent);
		Arrays.sort(tmp_points);
		printArr(tmp_points);
		printArr(percent);
		for(int i = tmp_points.length - 1; i >= 0; i--){
			ArrayList<Integer> indices = find(map, tmp_points[i]);
			System.out.println(indices);
			for(int j = 0; j < indices.size(); j++) {
				if(bonus != 0)
					percent[indices.get(j)]++;
				else { 
					printArr(percent);
					return percent;
				}
				bonus--;
			}
		}
		return percent;
	}

	public static void main (String [] args) { 
	
	}

	public static ArrayList<Integer> find(Map<Integer, ArrayList<Integer>> map, int value) { 
		
		return map.get(value);
	}
	public static int [] copyArr(int [] src) { 
		
		int [] dest = new int[src.length];
		for(int i = 0; i < src.length; i++) {
			if(!contains(dest, src[i]))
				dest[i] = src[i];
		}
		return dest;
	}
	
	public static Map<Integer, ArrayList<Integer>> getMap(int [] src) { 
		
		Map<Integer, ArrayList<Integer>> myMap = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < src.length; i++) { 
			if(myMap.containsKey(src[i])) { 
				myMap.get(src[i]).add(i);
				continue;
			}
			
			myMap.put(src[i], new ArrayList<Integer>());
			myMap.get(src[i]).add(i);
		}
		return myMap;	
	}
	
	public static boolean contains (int [] src, int val) { 
		
		for(int i : src)
			if(i == val)
				return true;
		return false;
	}
	
	public static void printArr(int [] src) { 
		
		for(int i : src)
			System.out.print(i + " ");
		System.out.println();
	}
}
