
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class Todos {
	
	static void alphabeticalSortMethod() {

		TreeMap<String, ArrayList<String>> sorted = new TreeMap<>();
		sorted.putAll(todosMap);
		for (Map.Entry<String, ArrayList<String>> entry : sorted.entrySet()) {
			System.out.println(entry.getValue());
		}
		
	}
	
	static void reverseAlphabeticalSortMethod () {
		//Arrays.sort(null,Collections.reverseOrder());
	}

	public static HashMap<String,ArrayList<String>> todosMap;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
