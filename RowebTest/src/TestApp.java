import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TestApp {
	public static void main(String[] args) {
		int[] A = { 4, 5, 10, 11, 6 };
		int M = -1;
		showDifference(A, M);

	}

	private static void showDifference(int[] a, int k) {
		
		// Creating a HashMap to retain the values as key and their indices in an ArrayList
		// ArrayList was used to print all indices of duplicate values if they exist
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		System.out.println("The pair of numbers whose difference is " + k + " are: \n");
		
		// Adding each element of the array in the map with all of its indices retained into an ArrayList of Integers
		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i]))
				map.put(a[i], new ArrayList<Integer>());
			map.get(a[i]).add(i);
		}
		
		//Verifying if the map contains two values whose difference is -1
		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			Integer key = entry.getKey();
			ArrayList<Integer> value = entry.getValue();
			int diff = key + k;
			
			//If two values whose difference is -1 are found in the array, they will be printed.
			if (map.containsKey(diff)) {
				if (diff > key)
					System.out.print("(" + key + " - " + diff + ")" + " at following indices: ");
				else
					System.out.print("(" + diff + " - " + key + ")" + " at following indices: ");
				
				//If a value is found more than once in the array, all indices of that value will be printed. 
				for (int i = 0; i < value.size(); i++) {
					ArrayList<Integer> v2 = map.get(diff);

					for (int j = 0; j < v2.size(); j++) {
						if (diff > key)
							System.out.println("A[" + value.get(i) + "] and A[" + v2.get(j) + "]");
						else
							System.out.println("A[" + v2.get(j) + "] and A[" + value.get(i) + "]");
					}
				}
			}
		}
	}
}
