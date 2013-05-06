
import java.util.Arrays;


public class Badgers {


	public static int feedMost(int [] hunger, int [] greed,int totalFood) { 
		
		int [] h_hunger = copyArr(hunger);
		int [] g_greed = copyArr(greed);
		int [] h_greed = new int[hunger.length];
		int [] g_hunger = new int[hunger.length];
		Arrays.sort(h_hunger);
		Arrays.sort(g_greed);
		for(int i = 0; i<hunger.length; i++) { 
			h_greed[i] = greed[(getIndex(h_hunger[i], hunger))];
			g_hunger[i] = hunger[(getIndex(g_greed[i],greed))];
		}
		int i_hunger = 0;
		int i_greed = 0;
		for(i_hunger = 0; i_hunger < hunger.length; i_hunger++)
			if(!canEat(h_hunger,h_greed,totalFood,i_hunger))
				break;
		for(i_greed = 0; i_greed < greed.length; i_greed++)
			if(!canEat(g_hunger, g_greed, totalFood, i_greed))
				break;
		System.out.println(i_hunger + " + " + i_greed);
		return i_hunger > i_greed ? i_hunger : i_greed;
	}
	
	public static int getIndex(int key, int [] arr) {
		
		for(int i = 0; i < arr.length; i++)
			if(arr[i]==key)
				return i;
		return -1;
	}

	public static boolean canEat(int [] hunger,int [] greed, int totalFood, int badgers) { 


		int currFood = 0;

		for(int i = 0; i < badgers; i++)
			if((currFood += hunger[i] + (greed[i] * badgers)) >= totalFood)
				return false;

		return true;
	}
	
	public static int [] copyArr(int [] src) { 
		
		int [] dest = new int[src.length];
		for(int i = 0; i < src.length; i++)
			dest[i] = src[i];
		return dest;
	}

	public static void main(String [] args) { 

		System.out.println(feedMost(new int [] {1,2,3,4,5,6,7,8,9,10}, new int [] {10,9,8,7,6,5,4,3,2,1}, 100 ));
	}

}