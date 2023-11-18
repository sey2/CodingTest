import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, k;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int cnt = 1;

        while(t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int arr[] = new int[n];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int i=1; i<=arr.length; i++) {
                comb(arr, new boolean[n], 0, i);
            }

            System.out.println("#" + cnt++ + " " + ans);

        }
    }

    public static void comb(int arr[], boolean visited[], int start, int r) {
        if(r == 0) {
            int sum = 0;

            for(int i=0; i<arr.length; i++) {
                if(visited[i])
                    sum += arr[i];
            }
            if(sum == k) ans ++;
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                comb(arr, visited, i + 1, r-1);
                visited[i] = false;
            }
        }
    }

}
