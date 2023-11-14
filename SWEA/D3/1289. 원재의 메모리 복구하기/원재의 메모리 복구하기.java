import java.io.*;
import java.util.*;

class Solution {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int tc = 0;

        while(tc++ < t) {
            String in = br.readLine();

            char c = '0';
            int ans = 0;
            for(int i=0; i<in.length(); i++) {
                if(in.charAt(i) != c) {
                    ans ++;
                    c = in.charAt(i);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

}
