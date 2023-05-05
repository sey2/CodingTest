import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,max=0;
    static int[][] chicken;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); // 회원 수 
        m = Integer.parseInt(st.nextToken()); // 치킨 종류

        chicken=new int[n][m];
        visited=new boolean[m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++)
                chicken[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(max);
    }

    static void dfs(int depth,int start) {
        if(depth==3) {
            int sum=0;
        
            for(int i=0;i<n;i++) {
                int num=0;
                
                for(int j=0;j<m;j++) {
                    
                    if(visited[j]==true)
                        num = Math.max(num, chicken[i][j]);
                }
                sum+=num;
            }

            max=Math.max(max, sum);
            return;
        }
        
        for(int i=start;i<m;i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(depth+1,i+1);
                visited[i] = false;
            }
        }
    }
}