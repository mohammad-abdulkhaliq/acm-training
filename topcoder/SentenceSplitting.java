import java.util.ArrayList;


public class SentenceSplitting {

	public static int split(String sentence, int K) {
		
		
		int [] spaces = spaces(sentence);
		//int k = 0;
		ArrayList<String> str = new ArrayList<String>();
		int middle = spaces.length/2;
		int k = 0;
		str.add(sentence.substring(0, spaces[middle]));
		for(int i = 0; i < spaces.length; i++) { 
			str.add(sentence.substring(k, spaces))
		}
		
		
		return -1;
	}
	
	public static int [] spaces(String sentence) { 
		
		int n = 0;
		int i = 0;
		for(i = 0; i < sentence.length(); i++)
			if(sentence.charAt(i)==' ')
				n++;
		int [] spaces = new int[n];
		for(i = 0; i < sentence.length(); i++)
			if(sentence.charAt(i)==' ')
				spaces[i] = i;
				
		return spaces;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
