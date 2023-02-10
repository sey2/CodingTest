import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int arr[] = new int[10000001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        n = (n == 1) ? 2 : n;

        findPrime(n, m);

        for(int i=n; i<=m; i++){
            if(arr[i] != 0) bw.write(i + "\n");
        }

        bw.flush();

    }

    public static void findPrime(int n, int m) {
        for(int i=2; i<=m; i++) arr[i] = i;

        for(int i=2; i<=m; i++){
            if(arr[i] == 0) continue;

            for(int j=2*i; j<=m; j+=i){
                arr[j] = 0;
            }
        }
    }
}
