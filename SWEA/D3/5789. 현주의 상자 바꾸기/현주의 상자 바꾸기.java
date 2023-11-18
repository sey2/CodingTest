import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int arr[][] = new int[q][2];

            for(int i=0; i<q; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int gift[] = new int[n];

            for(int i=0; i<arr.length; i++){
                for(int j=arr[i][0]-1; j<arr[i][1]; j++) {
                    gift[j] = i+1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<gift.length; i++) sb.append(gift[i]+ " ");

            System.out.println("#" + cnt++ + " " + sb);
        }
    }

}
