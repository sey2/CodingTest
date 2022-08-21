import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){
            String str = br.readLine();
            str.replace(".", "");

            int ans = 0;

            for(int j=0; j<str.length(); j++){
                if(j < str.length() -1 &&str.charAt(j) == '(' && str.charAt(j+1) == ')'){
                    j++;
                    ans++;
                }
                else if(str.charAt(j) == ')' || str.charAt(j) == '(') ans ++;
            }

            System.out.println("#" + i + " " + ans);

        }
     
	}
}