import java.util.HashSet;

public class Solution {
	public int solution(int[] topping) {
		int len = topping.length;
		int result = 0;
		int cheolsuArr[] = new int[len + 1];

		HashSet<Integer> cheolsuSet = new HashSet<>();
		HashSet<Integer> brotherSet = new HashSet<>();

		for (int i = 0; i < len; i++) {
			cheolsuSet.add(topping[i]);
			cheolsuArr[topping[i]]++;
		}
		
		for (int i = 0; i < len; i++) {
			brotherSet.add(topping[i]);

			cheolsuArr[topping[i]]--;
			
			if (cheolsuArr[topping[i]] == 0) {
				cheolsuSet.remove(topping[i]);
			}

			if (cheolsuSet.size() == brotherSet.size())
				result++;
		}

		return result;
	} // End of solution
} // End of Main class
