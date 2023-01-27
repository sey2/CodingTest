import java.util.PriorityQueue;
class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));

        for(int i=0; i<numbers.length; i++){
            int cur = numbers[i];

            while(!pq.isEmpty() && pq.peek()[1] < cur)
                numbers[pq.poll()[0]] = cur;

            pq.add(new int[] {i, cur});
        }


        while(!pq.isEmpty())
            numbers[pq.poll()[0]] = -1;

        return numbers;
    }
}