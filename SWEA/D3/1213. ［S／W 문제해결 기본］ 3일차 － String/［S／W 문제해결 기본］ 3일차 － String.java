import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());

            String target = br.readLine();
            String in = br.readLine();

            int ans = 0;
            while(in.contains(target)) {
                in = in.replaceFirst(target, "");
                ans ++;
            }


            System.out.println("#" + n + " " +  ans);
        }
    }


}
