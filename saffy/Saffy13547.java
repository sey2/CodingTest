import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(t-->0){
            String score = br.readLine();
            int ans = 0;

            for(int i=0; i<15; i++){
                if(score.length()-1 < i) ans++;
                else if(score.charAt(i) == 'o') ans++;
            }

            if(ans >= 8)
                System.out.println("#" + cnt++ + " YES");
            else
                System.out.println("#" + cnt++ + " NO");
        }

	}
}
