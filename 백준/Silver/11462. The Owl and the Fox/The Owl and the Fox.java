import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("END")) break;

            int N = Integer.parseInt(line);
            int targetSum = digitSum(N) - 1;
            
            for (int i = N - 1; i >= 0; i--) {
                if (digitSum(i) == targetSum) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}