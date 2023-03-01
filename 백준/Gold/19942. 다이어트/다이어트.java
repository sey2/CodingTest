import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main
{

    static int arr[][];
    static boolean visited[];
    static int mp, mf, ms, mv;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static int minCost = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");

        mp = Integer.parseInt(input[0]);
        mf = Integer.parseInt(input[1]);
        ms = Integer.parseInt(input[2]);
        mv = Integer.parseInt(input[3]);

        arr = new int[n][5];

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[n];

        for(int i=1; i<=n; i++) combination(0, i);
        

        if(pq.size() > 0) {
            System.out.println(minCost);
            System.out.println(pq.poll());
        }
        else
            System.out.println("-1");

    }

    public static void combination(int start, int r){
        if(r == 0){

            int p = 0;
            int f = 0;
            int s = 0;
            int v = 0;
            int c = 0;
            String str = "";
            for(int i=0; i<arr.length; i++){
                if(visited[i]){
                    str += (i+1) + " ";

                    p += arr[i][0];
                    f += arr[i][1];
                    s += arr[i][2];
                    v += arr[i][3];
                    c += arr[i][4];
                }
            }

            if(p >= mp && f >= mf && s >= ms && v >= mv && minCost >= c){
                if(minCost > c){
                    pq.clear();
                    minCost = c;
                }
                pq.add(str);
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i + 1, r - 1);
                visited[i] = false;
            }
        }
    }



}
