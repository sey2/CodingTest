import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> studentList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            studentList.add(Integer.parseInt(st.nextToken()));

        int result = 0;
        while (!studentList.isEmpty()) {
            int loopNum = Math.min(studentList.size(), K);

            boolean freshMan = false;
            boolean sophomore = false;

            for (int i = 0; i < loopNum; i++) {
                if (studentList.get(i) == 1 && !freshMan) {
                    freshMan = true;
                } else if (studentList.get(i) == 2 && !sophomore) {
                    sophomore = true;
                }
            }

            if (freshMan)
                removeFirst(studentList, 1);
            if (sophomore)
                removeFirst(studentList, 2);

            result++;
        }

        System.out.println(result);
    }

    static void removeFirst(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == target) {
                list.remove(i);
                return;
            }
        }
    }
}