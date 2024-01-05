import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 객체 생성
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        while (n-- > 0) {
            String[] in = br.readLine().split(" ");
            int command = Integer.parseInt(in[0]);
            int element;
            switch (command) {
                case 1:
                    element = Integer.parseInt(in[1]);
                    deque.addFirst(element);
                    break;
                case 2:
                    element = Integer.parseInt(in[1]);
                    deque.addLast(element);
                    break;
                case 3:
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                    break;
                case 4:
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                    break;
                case 5:
                    sb.append(deque.size()).append('\n');
                    break;
                case 6:
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7:
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                    break;
                case 8:
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                    break;
            }
        }
        
        System.out.print(sb.toString()); // 최종 결과를 한 번에 출력
    }
}
