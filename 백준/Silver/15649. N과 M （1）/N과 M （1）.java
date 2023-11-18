import java.io.*;
import java.util.StringTokenizer;


public class Main
{
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for(int i=1; i<=n; i++) arr[i-1] = i;

        per(arr, new int[m], new boolean[n], 0, m);
        bw.close();

    }

    public static void per(int arr[], int out[], boolean visited[], int depth, int r) throws IOException {
        if(depth == r) {
            for(int i=0; i<out.length; i++) {
                bw.write(out[i] + " ");
            }

            bw.write("\n");

            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                per(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }


}