import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main
{

    static int n, m;
    static String problemSet = "";
    static boolean visited[];
    static String c[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) problemSet += i;

        c = new String[m][n];
        for(int i=0; i<m; i++){
            String [] in = br.readLine().split(" ");

            for(int j=1; j<in.length; j++)
                c[i][j-1] = in[j];
        }

        visited = new boolean[m];

        for(int i=1; i<=m; i++) combination(0, i, i);
        System.out.println("-1");

    }

    public static void combination(int start, int depth, int r){
        if(depth == 0){
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<m; i++){
                if(visited[i]){
                    for(int j=0; j<c[i].length; j++){
                        if(c[i][j] != null)
                             set.add(c[i][j]);
                    }
                }
            }

            String str = "";
            for(String ch : set) str += ch;

            if(str.equals(problemSet)){
                System.out.println(r);
                System.exit(0);
            }

            return;
        }

        for(int i=start; i<m; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1, depth - 1, r);
                visited[i] = false;
            }
        }
    }



}






