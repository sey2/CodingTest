import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int v[] = new int[n];   // 물건의 부피
            int c[] = new int[n];   // 물건의 가치

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            int arr[][] = new int[n+1][k+1];
            int max = 0;

            for(int i=1; i<=n; i++) {
                for(int j=1; j<=k; j++) {
                    if(v[i-1] <= j)
                        arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j -v[i-1] ] + c[i-1]);
                    else
                        arr[i][j] = arr[i-1][j];

                    max = Math.max(arr[i][j], max);
                }
            }

            System.out.println("#" + cnt++ + " " +  max);
        }
    }


}
