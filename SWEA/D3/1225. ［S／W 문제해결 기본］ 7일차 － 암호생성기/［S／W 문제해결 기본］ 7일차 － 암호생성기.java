import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=10; i++) {
            int n = Integer.parseInt(br.readLine());

            String in[] = br.readLine().split(" ");
            int arr[] = new int[8];

            for(int j=0; j<in.length; j++)
                arr[j] = Integer.parseInt(in[j]);

            System.out.println("#" + i + " " + sol(arr));
        }
    }

    public static String sol(int arr[]) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<arr.length; i++)
            q.add(arr[i]);

        int cnt = 1;
        boolean run = true;

        while(run) {
            int num = q.poll() - cnt++;
            if(num <= 0) {
                num = 0;
                run = false;
            }
            q.add(num);
            if(cnt == 6) cnt = 1;
        }

        String ans = "";
        for(int i=0; i<arr.length; i++) {
            ans += q.poll() + " ";
        }

        return ans.trim();
    }

}

