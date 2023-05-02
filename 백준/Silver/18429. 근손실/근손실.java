import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static int n, k;
    public static int arr[];
    public static int ans = 0;

    public static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        backtracking(500,  arr.length);
        System.out.println(ans);

    }

    public static void backtracking(int weight, int r){
        if(r == 0){
            ans ++;
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i] && (weight + arr[i] - k >= 500)){
                visited[i] = true;
                backtracking( weight + arr[i] - k,  r - 1);
                visited[i] = false;
            }
        }
    }
}