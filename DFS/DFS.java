import java.io.*;
import java.util.Stack;
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

public class DFS{
    static int [][] map;
    static boolean [] visited;
    static int N, M, start, end;

    public static void main(String args[]) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FastScanner sc = new FastScanner();

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int [N+1][M+1];
        visited = new boolean[N + 1];

        for(int i=0; i<M; i++){
            start = sc.nextInt();
            end = sc.nextInt();

            map[start][end] = 1;
            map[end][start] = 1;
        }
    }

    static void dfs(int point){
        Stack<Integer> st = new Stack<>();
        st.push(point);
        visited[point] = true;

        while(!st.empty()){
            for(int i=1; i<= N; i++){
                if(map[point][i] == 1 && visited[i] == false){
                    st.push(i);
                    visited[i] = true;
                    dfs(i);
                }
            }
            st.pop();
        }
    }
}



