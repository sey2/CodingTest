import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Report{
    int score;
    int time;

    public Report(int score, int time){this.score = score; this.time = time;}
}

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int time = Integer.parseInt(br.readLine());
        Stack<Report> stack = new Stack<>();

        int score = 0;
        for(int i=0; i<time; i++){
            st = new StringTokenizer(br.readLine());

            // 1: new report, 0: no report
            int addReport = Integer.parseInt(st.nextToken());

            if(addReport == 1)
                stack.push(new Report(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1));
            else if (!stack.isEmpty()){
                Report top = stack.pop();
                stack.push(new Report(top.score, top.time-1));
            }

            if(stack.isEmpty()) continue;

            if(stack.peek().time <= 0){
                score += stack.peek().score;
                stack.pop();
            }

        }

        System.out.println(score);

    }

}

