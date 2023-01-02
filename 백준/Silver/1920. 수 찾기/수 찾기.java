import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static int arr[];
    public static int target[];

    public static void main(String args[]) throws IOException {

        initInput();

        for(int i=0; i<target.length; i++)
            System.out.println(binarySearch(target[i]));


    }

    public static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int [n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        target = new int[m];
        for(int i=0; i<m; i++)
            target[i] = Integer.parseInt(st.nextToken());
    }

    public static int binarySearch(int find){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == find) return 1;
            else if(arr[mid] < find) start = mid+1;
            else end = mid-1;
        }

        return 0;
    }
}
