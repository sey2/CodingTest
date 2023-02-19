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

        comb(arr, visited, 0, b);



    }

    public static void comb(int arr[], boolean visited[], int start, int r){
        if(r == 0){
            print(arr, visited);
            return;
        }

        for(int i=start; i<arr.length; i++){
            visited[i] = true;
            comb(arr, visited,  i+1, r-1);
            visited[i] = false;
        }
    }

    public static void print(int arr[], boolean visited[]){
        for(int i=0; i<arr.length; i++) {
            if(visited[i])
              System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


}

