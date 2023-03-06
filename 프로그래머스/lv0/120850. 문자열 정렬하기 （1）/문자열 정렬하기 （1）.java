import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]", "");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<my_string.length(); i++) 
            pq.add(Integer.parseInt(my_string.charAt(i)+""));
        
        int answer[] = new int[pq.size()];
        
        int size = pq.size();
        
        for(int i=0; i<size; i++) answer[i] = pq.poll();
        
        return answer;
    }
}