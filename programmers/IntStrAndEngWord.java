import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        String numbers[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<=9; i++)
           s =  s.replace(numbers[i], Integer.toString(i));

        answer = Integer.parseInt(s);

        return answer;
    }
}
