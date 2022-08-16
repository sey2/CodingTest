import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static boolean visited[];
    public static int depth[];
    public static List<List<Integer>> map = new ArrayList<>();

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int answer[] = new int[sources.length];

        for(int i=0; i<=n; i++) map.add(new ArrayList<>());

        for(int i=0; i< roads.length; i++){
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);

        }


        for(int i=0; i<sources.length; i++) {
            if(sources[i] == destination)
                answer[i] = 0;
            else
                answer[i] = bfs(sources[i], destination, n);
        }

        return answer;
    }
    public static int bfs(int start, int end, int n){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n+1];
        depth = new int[n+1];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int num : map.get(cur)){
                if(!visited[num]){
                    queue.add(num);
                    depth[num] = depth[cur] + 1;
                    if(num == end) return depth[end];
                    visited[num] = true;
                }
            }
        }

        return -1;
    }
}
