import java.util.*;
import java.io.*;


public class Main
{
    static int arr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i< n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        com(new boolean[n],0, m);
        // per(new int[m], new boolean[n], 0, m);
    }

    public static void com(boolean visited[], int idx, int r){
        if(r == 0){
            for(int i=0; i<arr.length; i++){
                if(visited[i])
                    System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return;
        }

        for(int i=idx; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                com(visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public static void per(int out[], boolean visited[], int idx, int r){
        if(r == 0){
            for(int i=0; i<out.length; i++){
                System.out.print(out[i] + " ");
            }
            System.out.println("");
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[idx] = arr[i];
                per(out, visited, idx+1, r-1);
                visited[i] = false;
            }
        }
    }

}