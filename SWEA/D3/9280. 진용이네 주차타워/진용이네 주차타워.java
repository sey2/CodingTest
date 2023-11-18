import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // n개의 주차 공간
            int m = Integer.parseInt(st.nextToken());   // m 들어올 차량의 수

            int r[] = new int[n+1];   // 단위 무게당 요금 {2, 1, 3, 8} 첫 번쨰 주차 공간은 무게당 2원

            for(int i=1; i<=n; i++)
                r[i] = Integer.parseInt(br.readLine());

            int w[] = new int[m+1]; // 차량의 무게

            for(int i=1; i<=m; i++)
                w[i] = Integer.parseInt(br.readLine());

            int inCar[] = new int[m*2];

            for(int i=0; i<m*2; i++)
                inCar[i] = Integer.parseInt(br.readLine());

            int isParking[] = new int[n+1];

            int ans = 0;
            Queue<Integer> waitingQ = new LinkedList<>();
            for(int i=0; i<m*2; i++) {
                // 차량 번호
                int cur = inCar[i];
                
                // 차가 나가는 경우
                 if(cur < 0) {
                     int out = findCarNum(isParking, cur * -1);
                     isParking[out] = 0;
                     if(waitingQ.size() > 0)
                        cur = waitingQ.poll();
                     else
                         continue;
                 }

                int minArea = findMinCarArea(isParking);

                if(minArea == -1) { // 주차 구역이 없을 경우
                    waitingQ.add(cur);
                    continue;
                }

                isParking[minArea] = cur;
                ans += r[minArea] * w[cur];

            }

            System.out.println("#" + cnt++ + " " + ans);
        }
    }

    public static int findMinCarArea(int isParking[]) {
        for(int i=1; i<isParking.length; i++){
            if(isParking[i] == 0) return i;
        }

        return -1;
    }

    public static int findCarNum(int isParking[], int car) {
        for(int i=1; i<isParking.length; i++){
            if(isParking[i] == car) return i;
        }

        return -1;
    }
}

