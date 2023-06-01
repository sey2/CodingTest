import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> passport = new HashSet<>();

        while(n --> 0){
            passport.add(br.readLine());
        }

        int m = Integer.parseInt(br.readLine());

        int ans = 0;
        while(m --> 0){
            if(passport.contains(br.readLine())) ans ++;
        }

        System.out.println(ans);
    }

}