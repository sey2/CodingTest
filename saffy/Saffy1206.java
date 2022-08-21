import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
        final int check [] = {-2,-1, 1,2};
 
        int cnt = 1;
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int arr[] = new int [n];
            int ans =0;
 
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
 
            for(int i=2; i<n-2; i++){
                int min = Integer.MAX_VALUE;
 
                for(int j=0; j<4; j++){
                    int next = i + check[j];
 
                    if(arr[next] >= arr[i]) {
                        min = 0; break;
                    }
 
                    min = Math.min(min, arr[i] - arr[next]);
                }
 
                ans += (min == Integer.MAX_VALUE) ? 0 : min;
            }
 
            System.out.println("#" + cnt++ + " " + ans);
        }
    }
}
