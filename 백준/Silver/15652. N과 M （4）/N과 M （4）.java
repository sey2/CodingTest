import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int end;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        end = m;
        for(int i=1; i<=n; i++) arr[i-1] = i;

        comb(new int[n], 0,0, m);

        bw.close();

    }

    public static void comb(int out[], int start, int idx, int r) throws IOException {
        if(r == 0){
            for(int i=0; i<end; i++)
                    bw.write(out[i] + " ");
            bw.write("\n");
            return;
        }

        for(int i=idx; i<arr.length; i++){
            out[start] = arr[i];
            comb(out,start+1, i,r-1);
        }
    }

}