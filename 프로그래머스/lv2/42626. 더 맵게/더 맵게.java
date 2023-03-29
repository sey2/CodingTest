import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++)
            pq.add((long)scoville[i]);
        
        while(pq.size() > 1 && pq.peek() < K){
            long first = pq.poll();
            long second = pq.poll() * 2;
            
            pq.add(first + second);
            answer ++;
            
        }
        
        if(pq.isEmpty() || pq.peek() < K)
            return -1;
        else
            return answer;
        // return (answer == 0) ? -1 : answer;
    }
}