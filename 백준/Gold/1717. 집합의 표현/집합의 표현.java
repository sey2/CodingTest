import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int parent[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i=0; i<parent.length; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c == 0)
                union(a, b);
            else{
                if(find(a) != find(b)) bw.write("NO\n");
                else  bw.write("YES\n");
            }
        }

        bw.close();
    }


    // union 연산
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        parent[y] = x;
        return  false;
    }

    // find 연산
    public static int find(int x) {
        if(parent[x] == x)
            return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

}