import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}

public class Back1697{
    static int map[][];
    static int visited[];
    static int k;
    static int max = 100000;

    public static void main(String args[]) throws IOException{
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();   // 수빈이 위치
        k = sc.nextInt();   // 동생 위치

        visited = new int[max+1];

        bfs(n);
    }

    static void bfs(int point){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(point);
        visited[point] = 1;

        while(!queue.isEmpty()) {
            int x = queue.poll();

            if(x == k){
                System.out.println(visited[x]-1);
                break;
            }   

            if(x-1 >=0 && visited[x-1] == 0){
                visited[x-1] = visited[x]+1;
                queue.add(x-1);
            }

            if(x+1 <= max && visited[x+1] == 0){
                visited[x+1] = visited[x]+1;
                queue.add(x+1);
            }

            if(x*2 <= max && visited[2*x] == 0){
                visited[2*x] = visited[x]+1;
                queue.add(2 * x);
            }
        }

    }
}