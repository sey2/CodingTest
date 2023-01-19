import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer arr[] = new Integer[n];

        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        long ans = 0;
        for(int i=0; i<n; i++) {
            int tip = arr[i] - i;
            ans += (tip > 0) ? tip : 0;
        }

        System.out.println(ans);
    }
}
