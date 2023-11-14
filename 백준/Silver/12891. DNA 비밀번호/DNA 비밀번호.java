import java.io.*;
import java.util.*;

class Main {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        String str = br.readLine();
        in = br.readLine().split(" ");

        int[] need = {Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]), Integer.parseInt(in[3])};
        int[] count = new int[4]; 
        int ans = 0;

        for (int i = 0; i < m; i++) {
            count[getIndex(str.charAt(i))]++;
        }

        if (check(count, need)) ans++;

        for (int i = m; i < n; i++) {
            count[getIndex(str.charAt(i - m))]--; 
            count[getIndex(str.charAt(i))]++; // 새로운 문자 카운트 증가

            if (check(count, need)) ans++; 
        }

        System.out.println(ans);
        br.close();
    }

    public static int getIndex(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }

    public static boolean check(int[] count, int[] need) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < need[i]) return false;
        }
        return true;
    }
}
