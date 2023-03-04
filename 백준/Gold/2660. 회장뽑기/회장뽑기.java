import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static final int INF = 99999;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int map[][] = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        while(true){
            String input[] = br.readLine().split(" ");

            if(input[0].equals("-1") && input[1].equals("-1")) break;

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map[a][b] = map[b][a] = 1;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        int minScore = INF;
        int score[] = new int[n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                score[i] = Math.max(score[i], map[i][j]);
            }
            minScore = Math.min(minScore, score[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(minScore == score[i]) list.add(i);
        }

        System.out.println(minScore + " " + list.size());
        for(int num : list) System.out.print(num + " ");


    }
}


