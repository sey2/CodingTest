import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int one[] = {1, 2, 3, 4, 5};
        int two[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int three[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count[] = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(one[i%one.length] == answers[i]) count[0]++;
            if(two[i%two.length] == answers[i]) count[1]++;
            if(three[i%three.length] == answers[i]) count[2]++;
            
        }
    
        Integer arr[] = {count[0],count[1], count[2]};
        Arrays.sort(arr,Collections.reverseOrder());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=3; i++){
            if(arr[0] == count[i-1])
                list.add(i);
        }
        
    
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
