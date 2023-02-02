import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        Time arr[] = new Time[book_time.length];

        for(int i=0; i<book_time.length; i++){
            String [] token = book_time[i][0].split(":");
            int start = parseTime(token);
            token = book_time[i][1].split(":");
            int end = parseTime(token);

            Time cur = new Time(start,end);
            arr[i] = cur;
        }

        Arrays.sort(arr);

        PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.end - o2.end;
            }
        });

        pq.add(arr[0]);

        for(int i=1; i<book_time.length; i++){
            Time cur = arr[i];

            while(!pq.isEmpty() && pq.peek().end + 10 < cur.start) {
                pq.poll();
            }

            pq.add(cur);

            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    public int parseTime(String time[]){
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Time o) {
        return this.start - o.start;
    }
}

public class Main {

    public static void main(String args[]) throws IOException {
        int ans = new Solution().solution(new String[][]{ {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}} );
        System.out.println(ans);
    }
}
