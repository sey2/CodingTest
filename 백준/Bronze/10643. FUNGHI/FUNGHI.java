import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] pizza = new int[8];

        for (int i = 0; i < pizza.length; i++)
            pizza[i] = Integer.parseInt(br.readLine());

        int max = 0;

        for (int i = 0; i < pizza.length; i++) {
            int sum = pizza[getSafeIndex(i)] +
                    pizza[getSafeIndex(i + 1)] +
                    pizza[getSafeIndex(i + 2)] +
                    pizza[getSafeIndex(i + 3)];

            max = Math.max(sum, max);
        }
        System.out.println(max);
    }

    static int getSafeIndex(int currentIndex) {
        return currentIndex % 8;
    }
}