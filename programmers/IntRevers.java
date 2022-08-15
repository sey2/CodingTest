import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<str.length(); i++) pq.add(Integer.toString(str.charAt(i)-48));
        
        String ans ="";
        while(!pq.isEmpty()) ans+= pq.poll(); 
        
        return Long.parseLong(ans);
    }
}
