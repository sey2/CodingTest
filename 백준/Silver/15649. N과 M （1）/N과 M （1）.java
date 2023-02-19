import java.io.*;
import java.util.*;

public class Main {

    public static int arr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr = new int[a];
        for(int i=0; i<arr.length; i++) arr[i] = i+1;

        int output[] = new int[b];
        boolean visited[] = new boolean[a];

        per(output,visited, 0, a, b);

    }

    public static void per(int output[], boolean visited[], int depth, int n, int r){
        if(depth == r){
            print(output);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                per(output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void print(int output[]){
        for(int i=0; i<output.length; i++)
            System.out.print(output[i] + " ");
        System.out.println();
    }


}

