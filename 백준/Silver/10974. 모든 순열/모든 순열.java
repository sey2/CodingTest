import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{

    static int arr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        int out[] = new int[n];

        for(int i=0; i<n; i++) arr[i] = i+1;
        permutation(out, 0, n);
    }

    public static void permutation(int out[], int depth, int r){
        if(depth == r){

            for(int i=0; i<out.length; i++)
                System.out.print(out[i] + " ");

            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(out, depth + 1, r);
                visited[i] = false;
            }
        }
    }


}



