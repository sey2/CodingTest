import java.io.*;
import java.util.StringTokenizer;


public class Main
{
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for(int i=1; i<=n; i++) arr[i-1] = i;
        comb(arr, new int[m], 0, 0, m, bw);


        bw.close();

    }

    public static void comb(int arr[], int out[], int start,  int depth, int r, BufferedWriter bw) throws IOException {
        if(r == 0) {
            for(int i=0; i<out.length; i++) {
                bw.write(out[i] + " ");

            }
            bw.write("\n");
            return;
        }

        for(int i=start; i<arr.length; i++) {
            out[depth] = arr[i];
            comb(arr, out ,i, depth +1 ,r-1, bw);
        }
    }

}