import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{

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
    }

    public static void per(int arr[], int out[], boolean visited[], int depth, int r){
        if(depth == r){
            print(out, visited);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                per(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }

    }

    public static void print(int arr[], boolean visited[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}






