import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=1; i<=n; i++) arr[i-1] = i;

        //comb(new boolean[n], 0, m);

        per(new int[n], new boolean[n], 0, m);
        bw.close();

    }

    public static void comb(boolean visited[], int start, int r) throws IOException {
        if(r == 0){
            for(int i=0; i<arr.length; i++){
                if(visited[i])
                    bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                comb(visited,i+1, r-1);
                visited[i] = false;
            }
        }
    }

    public static void per(int out[], boolean visited[], int n, int r) throws IOException {
        if(n == r){
            for(int i=0; i<r; i++){
                bw.write(out[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0; i<arr.length; i++){
            out[n] = arr[i];
            per(out, visited, n+1, r);
        }
    }
}