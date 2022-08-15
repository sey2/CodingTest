import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int complete[] = new int [progresses.length];
        boolean check[] = new boolean[progresses.length];
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            int nonClear = (100 - progresses[i]);
            complete[i] =  (nonClear % speeds[i] == 0) ? nonClear / speeds[i] : nonClear / speeds[i] + 1;
        }

        for(int i=0; i<complete.length; i++){
            if(!check[i]) {
                int count = 1;
                check[i] = true;

                for (int j = i + 1; j < complete.length; j++) {
                    if (complete[i] >= complete[j] && !check[j] && check[j-1]) {
                        count++;
                        check[j] = true;
                    }
                }

                answer.add(count);
            }
        }
        
        int arr[] = new int[answer.size()];
        
        for(int i=0; i<arr.length; i++) arr[i] = answer.get(i);

        return arr;
    }
}
