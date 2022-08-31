import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            System.out.println("#" + cnt++ + " " + Integer.parseInt(st.nextToken())/3);
        }
	}
}
