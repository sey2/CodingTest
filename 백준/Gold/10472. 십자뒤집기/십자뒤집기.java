import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static HashSet<String> set;
    static int next[][] = {{0, 1, 3}, {1, 0, 2, 4}, {2, 1, 5},
            {3, 0, 4, 6}, {4, 1, 3, 5, 7}, {5, 2, 4, 8},
            {6, 3, 7}, {7, 4, 6, 8}, {8, 5, 7}
    };

    static char in[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            in = makeArray(br);

            set = new HashSet<>();

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(new char[]{'.' , '.' , '.', '.' , '.' , '.', '.' , '.' , '.'}, 0));
        set.add(new String(new char[]{'.' , '.' , '.', '.' , '.' , '.', '.' , '.' , '.'}));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(toString(in).equals(new String(cur.arr))) return cur.num;

            for (int i = 0; i < 9; i++) {
                char[] flipped = flip(i, cur.arr.clone());

                String flippedString = new String(flipped);
                if(!set.contains(flippedString)) {
                    set.add(flippedString);
                    q.add(new Node(flipped, cur.num + 1));
                }
            }
        }

        return -1;
    }

    public static char[] flip(int nextIndex, char[] arr) {
        for(int i = 0; i < next[nextIndex].length; i++){
            int index = next[nextIndex][i];
            arr[index] = arr[index] == '*' ? '.' : '*';
        }

        return arr;
    }

    public static char[][] makeArray(BufferedReader br) throws IOException {
        char arr[][] = new char[3][3];

        for (int i = 0; i < 3; i++) {
            String line = br.readLine();

            for (int j = 0; j < 3; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        return arr;
    }

    public static String toString(char[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
        }

        return sb.toString();
    }

    static class Node {
        char[] arr;
        int num;

        public Node(char[] arr, int num) {
            this.arr = arr;
            this.num = num;
        }
    }
}
