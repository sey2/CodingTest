import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int node = 0;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        node = n;

        for(int i=0; i<wires.length; i++){
            graph = makeGraph(i, wires);

            ArrayList<Integer> nodeNum = new ArrayList<>();
            visited = new boolean[node+1];
            for(int j=0; j<graph.size()-1; j++){
                if(!visited[j+1]) {
                    nodeNum.add(bfs(j+1));
                }
            }

            answer = Math.min(answer, Math.abs(nodeNum.get(0) - nodeNum.get(1)));
        }

        return answer;
    }

    public int bfs(int start){
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(graph.get(start));
        visited[start] = true;

        int count = 1;
        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();

            for(int num : cur){
                if(!visited[num]){
                    q.add(graph.get(num));
                    visited[num] = true;
                    count ++;
                }
            }
        }

        return count;

    }

    public ArrayList<ArrayList<Integer>> makeGraph(int jumpIdx, int[][] wires){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0; i<node+1; i++) list.add(new ArrayList<>());

        for(int i=0; i<wires.length; i++){
            if(i == jumpIdx) continue;

            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        return list;
    }
}



public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(new Solution().solution(9, new int[][]{
                {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
        }));
    }



}

