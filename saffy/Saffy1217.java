import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        while(t-->0){
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int target = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            recursive(target, count, 1, tc);
        }

    }

    public static void recursive(int target, int count, int result, int tc){
        if(count == 0){
            System.out.println("#" + tc + " " + result);
        }else recursive(target, count-1, result * target, tc);
    }

}
