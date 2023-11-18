import java.io.*;
import java.util.StringTokenizer;


public class Main
{

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int out[] = new int[m];
        boolean visited[] = new boolean[n];

        for(int i=0; i<n; i++) arr[i] = i+1;

        per(arr, out, visited, 0, m);
        bw.flush();
    }

    public static void per(int arr[], int out[], boolean visited[], int depth, int r) throws IOException {
        if(depth == r){
            print(out, visited);
            return;
        }

        for(int i=0; i<arr.length; i++){
            out[depth] = arr[i];
            per(arr, out, visited, depth + 1, r);

        }

    }

    public static void print(int arr[], boolean visited[]) throws IOException {
        for(int i=0; i<arr.length; i++){
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
    }



}






