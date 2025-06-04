import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /// 객체의 최대 번호
        final int n = Integer.parseInt(st.nextToken());
        /// 포인터 수
        final int m = Integer.parseInt(st.nextToken());
        /// 명령 수
        final int q = Integer.parseInt(st.nextToken());

        ArrayList<Pointer> pointers = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            final Pointer pointer = new Pointer(i + 1, Integer.parseInt(br.readLine()));
            pointers.add(pointer);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            final String command = st.nextToken();
            switch (command) {
                case "assign": {
                    final int pointerNum = Integer.parseInt(st.nextToken()) - 1;
                    final int assignObject = pointers.get(Integer.parseInt(st.nextToken()) - 1).object;
                    pointers.get(pointerNum).object = assignObject;
                    break;
                }
                case "swap": {
                    final int swapPointer1 = Integer.parseInt(st.nextToken()) - 1;
                    final int swapPointer2 = Integer.parseInt(st.nextToken()) - 1;
                    final int tmpPointerObject = pointers.get(swapPointer1).object;
                    pointers.get(swapPointer1).object = pointers.get(swapPointer2).object;
                    pointers.get(swapPointer2).object = tmpPointerObject;
                    break;
                }
                case "reset": {
                    final int pointerNum = Integer.parseInt(st.nextToken()) - 1;
                    pointers.get(pointerNum).object = 0;
                    break;
                }
            }
        }

        final Set<Integer> set = new HashSet<>();
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < pointers.size(); i++) {
            final int current = pointers.get(i).object;

            if (!set.contains(current) && current != 0) {
                pq.add(current);
                set.add(current);
            }
        }

        System.out.println(set.size());

        while (!pq.isEmpty()) {
            final int current = pq.poll();
            System.out.println(current);
        }

    }
}

class Pointer {
    int number = 0;
    int object = 0;

    Pointer(int number, int object) {
        this.number = number;
        this.object = object;
    }
}