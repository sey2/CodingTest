import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        int cnt = 1;
        while(T-->0) {
            int n = Integer.parseInt(br.readLine());

            int ans = 0;
            char arr[][] = new char[100][100];

            for(int i=0; i<100; i++) {
                String in[] = br.readLine().split(" ");
                for(int j=0; j<100; j++) {
                    arr[i][j] = in[j].charAt(0);
                }
            }

            for(int i=0; i<100; i++) {
                boolean check = false;

                for(int j=0; j<100; j++) {
                    if(arr[j][i] == '1') check = true;
                    if(arr[j][i] == '2' && check) {
                        ans ++;
                        check = false;
                    }
                }
            }

            System.out.println("#" + cnt++ + " " +  ans);
        }
    }

}
