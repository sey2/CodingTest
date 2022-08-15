import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        
        if(d[0] > budget) return answer;
        
        sum = d[0];
        answer++;
        
        for(int i=1; i<d.length; i++){
           if(sum + d[i] > budget) break;
            sum += d[i];
            answer++;
        }
        
        return answer;
    }
}
