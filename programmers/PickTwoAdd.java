import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                
                if(!list.contains(sum)) list.add(sum);
            }
        }
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
