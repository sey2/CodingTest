import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int prev = arr[0];
        list.add(prev);
        
        for(int i=1; i<arr.length; i++){
            if(prev == arr[i]) continue;
            list.add(arr[i]);
            prev = arr[i];
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
