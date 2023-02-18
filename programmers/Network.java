import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public boolean visited[];

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }


        return answer;
    }

    public void bfs(int start, int [][] computers){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0; i<computers.length; i++){
                if(!visited[i] && computers[cur][i] == 1){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
