import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        Arrays.sort(array);
        int ans = 0;
        
        for(int i=array.length-1; i>=0; i--)
            if(array[i] > height)
                ans ++;
            else return ans;
        
        return ans;
    }
    
}