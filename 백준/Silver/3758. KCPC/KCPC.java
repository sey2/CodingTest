import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            String[] input = br.readLine().split(" ");

            int teamNum = Integer.parseInt(input[0]);
            int proNum = Integer.parseInt(input[1]);
            int myTeam = Integer.parseInt(input[2]);
            int logEntry = Integer.parseInt(input[3]);

            Team teams[] = new Team[teamNum];
            for(int i=1; i<=teamNum; i++) teams[i-1] = new Team(i);

            for(int i=0; i<logEntry; i++) {
                // 팀 번호, 문제 번호, 획득 점수
                input = br.readLine().split(" ");

                int teamIndex = Integer.parseInt(input[0]);
                int proKey = Integer.parseInt(input[1]);
                int proScore = Integer.parseInt(input[2]);

                Team tmp = teams[teamIndex-1];
                tmp.score.put(proKey, Math.max(tmp.score.getOrDefault(proKey, 0), proScore));
                tmp.setLast(i);
                tmp.incSubmit();

                teams[teamIndex-1] = tmp;
            }

            Arrays.sort(teams);

            System.out.println(findMyTeam(myTeam, teams));

        }
    }

    public static int findMyTeam(int myTeam, Team[] teams) {
        for(int i=0; i<teams.length; i++) {
            if(teams[i].teamId == myTeam) return i+1;
        }
        return -1;
    }
}

class Team implements Comparable<Team> {
    int teamId;
    HashMap<Integer, Integer> score = new HashMap<>();
    int last = -1;
    int totalScore = 0;
    int submit = 0;

    public Team(int teamId) {
        this.teamId = teamId;
    }

    public void setLast(int last) {
        this.last = last;

        int sum = 0;
        for(int key: score.keySet()) {
            sum += score.get(key);
        }
        totalScore = sum;
    }

    public void incSubmit() {
        this.submit += 1;
    }

    @Override
    public int compareTo(Team o) {
        if(this.totalScore == o.totalScore) {
            if(this.submit == o.submit) {
                return this.last - o.last;
            }
            return this.submit - o.submit;
        }

        return o.totalScore - this.totalScore;
    }
}
