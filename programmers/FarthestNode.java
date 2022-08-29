import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private boolean visited[];
    private int depth[];

    public int solution(int n, int[][] edge) {
        init(n,edge);

        bfs(1);

        Arrays.sort(depth);

        int answer = 0;
        int max = depth[n];
        for(int i=n; i>=0; i--){
            if(max != depth[i]) break;
            answer++;
        }
        return answer;
    }

    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        depth[start] = 1;
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int vertex : list.get(cur)){
                if(!visited[vertex]){
                    queue.add(vertex);
                    depth[vertex] = depth[cur]+1;
                    visited[vertex] = true;
                }
            }
        }
    }

    public void init(int n, int [][] edge){

        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        visited = new boolean[n+1];
        depth = new int[n+1];
    }
}
