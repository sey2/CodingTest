import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int opnum[];
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        opnum = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            opnum[i] = Integer.parseInt(st.nextToken());

        dfs(arr[0], 1);

        System.out.println(max + "\n" + min);

    }

    public static void dfs(int num, int idx){
        if(idx == n){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for(int i=0; i<4; i++){
            if(opnum[i] > 0){
                opnum[i]--;

                switch (i){
                    case 0: dfs(num + arr[idx], idx + 1); break;
                    case 1: dfs(num - arr[idx], idx + 1); break;
                    case 2: dfs(num * arr[idx], idx + 1); break;
                    case 3: dfs(num / arr[idx], idx + 1); break;
                }

                opnum[i]++;
            }
        }
    }

}

