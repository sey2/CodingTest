import java.io.*;
import java.util.*;

public class Main {

    static long ans = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];
        boolean visited[] = new boolean [n];

        for(int i=0; i<n; i++){
            String input[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        for(int i=1; i<=n; i++){
            combination(arr, visited, 0, i);
            visited = new boolean [n];
        }

        System.out.println(ans);
    }

    public static void combination(int arr[][], boolean visited[], int start, int r){
        if(r == 0){
            int sin = 1;
            int bitter = 0;

            for(int i=0; i<arr.length; i++){
                if(visited[i]) {
                    sin *= arr[i][0];
                    bitter += arr[i][1];
                }
            }

            ans = Math.min(ans, Math.abs(sin - bitter));
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


