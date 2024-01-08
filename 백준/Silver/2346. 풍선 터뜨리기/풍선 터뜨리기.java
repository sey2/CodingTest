import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int numbers[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = burstBalloons(n, numbers);
        
        System.out.println(sb);
    }

    public static StringBuilder burstBalloons(int n, int[] numbers) {
        boolean[] balloons = new boolean[n];
        StringBuilder sb = new StringBuilder();
        int current = 0;

        for (int i = 0; i < n; i++) {
            balloons[current] = true;
            sb.append(current + 1).append(" ");

            if (i < n - 1) {
                int steps = numbers[current];
                while (steps != 0) {
                    current = (current + (steps > 0 ? 1 : -1) + n) % n;
                    if (!balloons[current]) {
                        steps += steps > 0 ? -1 : 1;
                    }
                }
            }
        }
        return sb;
    }
}