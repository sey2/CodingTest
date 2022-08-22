import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            long q1Sum = 0;
            long q2Sum = 0;
            for(int i=0; i<queue1.length; i++){
                q1.add(queue1[i]);
                q1Sum += queue1[i];

                q2.add(queue2[i]);
                q2Sum += queue2[i];
            }

            long mid = (q1Sum + q2Sum) / 2;

            int answer = 0;
            for(int i=0; i< queue1.length*3; i++){
                if(q1Sum > q2Sum){
                    q1Sum -= q1.peek();
                    q2Sum += q1.peek();
                    q2.add(q1.poll());
                    answer++;
                }else if(q1Sum < q2Sum){
                    q1Sum += q2.peek();
                    q2Sum -= q2.peek();
                    q1.add(q2.poll());
                    answer++;
                }

                if(q1Sum == mid && q2Sum == mid) return answer;
            }

            return -1;
    }
}
