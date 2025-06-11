import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int repeatNum = n;

        final PriorityQueue<Player> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.solvedNum == o2.solvedNum) {
                return o1.penalty - o2.penalty;
            }

            return o2.solvedNum - o1.solvedNum;
        });

        while (repeatNum-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String teamName = st.nextToken();

            int penaltyNum = 0;
            int solvedNum = 0;

            for(int i=0; i<4; i++) {
                final int tryNum = Integer.parseInt(st.nextToken());
                final int time = Integer.parseInt(st.nextToken());

                if(time == 0) {
                    continue;
                }

                penaltyNum += (tryNum - 1) * 20 + time;
                solvedNum++;
            }
            pq.add(new Player(teamName, penaltyNum, solvedNum));
        }

        if(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

class Player {
    String name;
    int penalty;
    int solvedNum;

    Player(String name, int penalty, int solvedNum) {
        this.name = name;
        this.penalty = penalty;
        this.solvedNum = solvedNum;
    }

    @Override
    public String toString() {
        return name + " " + solvedNum + " " + penalty;
    }
}