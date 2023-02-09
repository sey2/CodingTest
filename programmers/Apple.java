import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<score.length; i++)
            pq.add(score[i]);

        while(!pq.isEmpty() && pq.size() >= m){
            for(int i=0; i<m; i++) {
                if(i == m-1) answer += pq.poll() * m;
                else pq.poll();
            }
        }


        return answer;
    }
}
