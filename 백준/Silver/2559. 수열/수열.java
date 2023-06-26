import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=0; i<m; i++)
            sum += arr[i];

        int ans = sum;
        for(int i=m; i<arr.length; i++){
            sum = sum - arr[i - m] + arr[i];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);

    }
}
