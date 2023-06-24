import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}

public class Main {
    public static void main(String args[]) throws IOException{
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        int cnt = 0;
        int ans = 0;
        int n = sc.nextInt();   // 멀티 탭 구멍 개수
        int k = sc.nextInt();   // 전기용품 총 사용 횟수
        int [] order = new int[k];
        boolean [] plugin = new boolean[k+1];

        for(int i=0; i<k; i++)
            order[i] = sc.nextInt();

        for(; cnt!=n && idx<k;){
            int cur = order[idx++];

            if(!plugin[cur]){
                plugin[cur] = true;
                cnt ++;
            }
        }

        while(idx < k){

            if(!plugin[order[idx]]){
                List<Integer> list = new ArrayList<>();
                for(int i= idx; i<k; i++){
                    if(plugin[order[i]] && !list.contains(order[i])){
                        list.add(order[i]);
                    }
                }

                if(list.size() == n){
                    int remove = list.get(list.size() - 1);
                    plugin[remove] = false;
                }else{
                    for(int j = 1; j<=k; j++){
                        if(plugin[j] && !list.contains(j)){
                            plugin[j] = false;
                            break;
                        }
                    }
                }

                plugin[order[idx]] = true;
                ans ++;
            }
            idx ++;
        }
        bw.write(Integer.toString(ans));
        bw.close();
    }

}

