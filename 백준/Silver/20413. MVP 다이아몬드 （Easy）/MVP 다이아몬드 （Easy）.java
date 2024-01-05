import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static char[] mvp = {'B', 'S', 'G', 'P', 'D'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String in[] = br.readLine().split(" ");

        // 등급별 과금액 기준
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> index = new HashMap<>();
        map.put('B', 0);
        index.put('B', 0);

        // 등급별 과금액 기준 초기화
        for(int i=1; i<mvp.length; i++) {
            map.put(mvp[i], Integer.parseInt(in[i - 1]));
            index.put(mvp[i], i);
        }

        int ans = 0;
        int prev = 0;
        String sangMin = br.readLine();
        for(int i=0; i<n; i++) {
            char current = sangMin.charAt(i);

            if(current == 'D') {
                ans += map.get(current);
                prev = map.get(current);
            }
            else {
                ans += map.get(mvp[index.get(current) + 1]) - prev - 1;
                prev = map.get(mvp[index.get(current) + 1]) - prev - 1;
            }

        }

        System.out.println(ans);
    }
}
