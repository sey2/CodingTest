import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=1; i<=n; i++) arr[i-1] = i;

        per(new int[n], new boolean[n], 0, m);

    }

    public static void per(int out[], boolean visited[], int n, int r){
        if(n == r){
            for(int i=0; i<r; i++){
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[n] = arr[i];
                per(out, visited, n+1, r);
                visited[i] = false;
            }
        }
    }
}