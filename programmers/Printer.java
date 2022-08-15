import java.util.*;

class Job{
    int id;
    int priority;

    public Job(int id, int priority){this.id = id; this.priority = priority;}
}

class Solution {
    public static int solution(int[] priorities, int location) {
        int priority = priorities.length-1;
        Queue<Job> printerList = new LinkedList<>();

        for(int i=0; i<priorities.length; i++)
            printerList.add(new Job(i,priorities[i]));

        Arrays.sort(priorities);

        int answer = 1;
        while(!printerList.isEmpty()){

            if(printerList.peek().priority >= priorities[priority]){
                Job curJob = printerList.poll();

                if(curJob.id == location) return answer;

                answer++;
                priority--;
            }
            else{
                printerList.add(printerList.poll());
            }
        }

        return answer;
    }
}
