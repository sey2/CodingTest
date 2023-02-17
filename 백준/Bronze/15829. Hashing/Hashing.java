import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String input = br.readLine();

        int ans = 0;

        for(int i=0; i<input.length(); i++)
            ans += (input.charAt(i)-96) * Math.pow(31,i);

        System.out.println(ans % 1234567891);


    }

}

