import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int arr[] = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<arr.length; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            max = 0;

            comb(arr, new boolean[n], 0, 2, m);

            System.out.println("#" + cnt++ + " " + ((max == 0) ? -1 : max));
        }
    }

    public static void comb(int arr[], boolean visited[], int start, int r, int m) {
        if(r == 0) {
            int sum = 0;

            for(int i=0; i<arr.length; i++) {
                if(visited[i]) {
                    sum += arr[i];
                }
            }

            if(sum <= m) {
                max = Math.max(sum, max);
            }
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(arr, visited, i+1, r-1, m);
                visited[i] = false;
            }
        }
    }

}

