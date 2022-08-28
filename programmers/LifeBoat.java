import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int cnt = 0;
        for(int i=people.length-1; i>=0 && cnt <= i; i--){
            int sum = people[i];

            while(true){
                if(sum + people[cnt] <= limit)
                    sum += people[cnt++];
                else break;
            }

            answer++;

        }


        return answer;
    }
}
