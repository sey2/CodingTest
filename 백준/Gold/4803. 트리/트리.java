import java.io.*;
import java.util.Arrays;

public class Main {
    static int arr[];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cs = 1;
        while(true){
            int ans = 0;
            String input[] = br.readLine().split(" ");

            if(input[0].equals("0") && input[1].equals("0"))
                break;

            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            arr = new int[n+1];
            check = new boolean[n+1];

            Arrays.fill(arr, -1);

            for(int i=0; i<m; i++){
                input = br.readLine().split(" ");
                int a = find(Integer.parseInt(input[0]));
                int b = find(Integer.parseInt(input[1]));

                if(a == b)
                    arr[a] = -2;
                else
                    union(a,b);
            }

            for(int i=1; i<=n; i++) {
                if(arr[i] == -1)
                    ans ++;
            }

            if(ans > 1)
                bw.write("Case " + cs + ": A forest of "+ ans + " trees.\n");
            else if(ans == 1)
                bw.write("Case " + cs + ": There is one tree.\n");
            else
                bw.write("Case " + cs + ": No trees.\n");
            cs ++;
        }
        bw.close();
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x!=y){
            if(arr[x]==-2)
                arr[y] = x;

            else if(arr[y]==-2)
                arr[x] = y;

            else if(arr[x] < 0)
                arr[y] = x;

            else
                arr[x] = y;

        }
    }

    public static int find(int a){
        if(arr[a] < 0) return a;

        return arr[a] = find(arr[a]);
    }
}

