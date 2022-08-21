import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        Integer T = Integer.parseInt(br.readLine());
 
        int cnt = 1;
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
 
            int a = ((d+1)*2) -1;
            int mok = n / a;
            int ans = (n % a == 0) ? mok : mok+1;
 
            System.out.println("#" + cnt++ + " " + ans);
        }
 
    }
}
