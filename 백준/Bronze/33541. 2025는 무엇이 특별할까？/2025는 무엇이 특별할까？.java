import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine()) + 1;

        for(int i=input; i<=9999; i++) {
            String current = String.valueOf(i);
            int prefix = Integer.parseInt(current.substring(0, 2));
            int suffix = Integer.parseInt(current.substring(2, 4));

            int result = (prefix + suffix) * (prefix + suffix);
            if(result == Integer.parseInt(current)) {
                System.out.println(result);
                return;
            }
        }

        System.out.println(-1);
    }
}
