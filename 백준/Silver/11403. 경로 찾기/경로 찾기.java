import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{

    static int dist[][];
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        dist = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)
                    dist[i][j] = 0;
                dist[i][j] = 100_000_000;
            }
        }


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int cost = Integer.parseInt(st.nextToken());
                if(cost == 1) {
                    dist[i][j] = cost;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] != 100_000_000)
                    System.out.print(1 + " ");
                else
                    System.out.print("0" + " ");
            }
            System.out.println();
        }


    }

}