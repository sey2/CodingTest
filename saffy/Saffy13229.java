import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution
{
	public static void main(String args[]) throws Exception
	{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        final String[] days = {"SAT", "FRI", "THU", "WED", "TUE", "MON", "SUN"};

        int cnt = 1;
        while(t-->0){
            String s = br.readLine();

            for(int i=0; i<days.length; i++){
                if(s.equals(days[i])) System.out.println("#" + cnt++ + " " + (i+1));
            }
        }

	}
}

