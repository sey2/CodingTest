import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 채팅방의 기록 수
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        boolean reset = false;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String chat = br.readLine();

            if (chat.equals("ENTER")) {
                ans += set.size();
                set = new HashSet<>();
                continue;
            }

            set.add(chat);
        }

        ans+= set.size();
        System.out.println(ans);
    }
}

