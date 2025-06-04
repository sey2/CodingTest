import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int limit = Integer.parseInt(st.nextToken());
        final int num = Integer.parseInt(st.nextToken());
        final int upCost = Integer.parseInt(st.nextToken());
        final int forwardCost = Integer.parseInt(st.nextToken());
        final int downCost = Integer.parseInt(st.nextToken());

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < num; i++) {
            char command = br.readLine().charAt(0);

            switch (command) {
                case 'u':
                case 'd':
                    sum += upCost + downCost;
                    break;
                default:
                    sum += forwardCost * 2;
                    break;
            }

            if (sum > limit) {
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }

}