import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue <Integer> pq = new PriorityQueue <>();
        
        int answer = 0;
        for(int num : scoville) pq.add(num);
        
        while(true){
            if(pq.size() == 1 && pq.peek() < K) return -1;
            int mepZZill = pq.peek();
            
            if(mepZZill < K){
                int one = pq.poll();
                int two = pq.poll()*2;
                pq.add(one + two);
                answer++;
            }else break;
            
        }
        
        
        return answer;
    }
}
