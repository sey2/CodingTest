import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static int arr[];
    public static String n;

    public static void main(String args[]) throws IOException {

        initInput();

        for(int i=0; i<n.length(); i++) {
            int idx = n.charAt(i) - 48;

            if(idx == 9 || idx == 6){
                if(arr[9] > arr[6]) arr[6] ++;
                else arr[9]++;
                continue;
            }

            arr[n.charAt(i) - 48]++;
        }

        System.out.println(Arrays.stream(arr).max().getAsInt());



    }

    public static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        arr = new int[10];

    }


}
