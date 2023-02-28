import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{

    static int arr[];
    static boolean visited[];
    static int ans = 0;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) combination(arr, visited, 0, i);

        System.out.println(ans);

    }

    public static void combination(int arr[], boolean visited[], int start, int r){
        if(r == 0){
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                if(visited[i]) {
                    sum +=  arr[i];
                }
            }
            if(sum == m){
                ans ++;
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

}






