package helpers;

public class ArrayHelper {
	
	

	public static int [] copyArr(int [] src) { 
		
		int [] dest = new int[src.length];
		for(int i = 0; i < src.length; i++)
			dest[i] = src[i];
		return dest;
	}
	
	public static void printArr(int [] src) { 
		
		for(int i : src)
			System.out.print(i+ " ");
	}
	
	public static int getIndex(int key, int [] arr) {
		
		for(int i = 0; i < arr.length; i++)
			if(arr[i]==key)
				return i;
		return -1;
	}



}