import java.util.*;
class Solution {
    public static int solution(int[] numbers) {
        boolean check[] = new boolean[10];


        for(int i=0; i<numbers.length; i++)
            check[numbers[i]] = true;

        int answer = 0;

        for(int i=1; i<check.length; i++){
            if(check[i] == true) continue;
            answer += i;
        }

        return answer;
    }
}
