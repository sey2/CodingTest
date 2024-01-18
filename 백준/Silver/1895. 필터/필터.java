import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int arr[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }

        int t = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-3; j++) {
                if(findMid(arr, i, j) >= t) ans ++;
            }
        }

        System.out.println(ans);
    }

    public static int findMid(int arr[][], int row, int col) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                list.add(arr[i+row][j+col]);
            }
        }

        Collections.sort(list);

        return list.get(4);
    }
}
