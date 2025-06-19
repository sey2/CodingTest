import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> grade1 = new LinkedList<>();
        Queue<Integer> grade2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int grade = Integer.parseInt(st.nextToken());
            if (grade == 1) grade1.add(i);
            else grade2.add(i);
        }

        int time = 0;
        int processed = 0;

        while (processed < N) {
            // 현재 시점에서 처리 가능한 최대 인덱스
            int limit = processed + K;

            boolean has1 = !grade1.isEmpty() && grade1.peek() < limit;
            boolean has2 = !grade2.isEmpty() && grade2.peek() < limit;

            if (has1 && has2) {
                grade1.poll();
                grade2.poll();
                processed += 2;
            } else if (has1) {
                grade1.poll();
                processed++;
            } else if (has2) {
                grade2.poll();
                processed++;
            }

            time++;
        }

        System.out.println(time);
    }
}