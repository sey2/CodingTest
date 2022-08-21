import java.io.IOException;
import java.util.HashMap;


class Solution {
    char type [] = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i< type.length; i++) map.put(type[i],0);

        for(int i=0; i< survey.length; i++){
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);

            int score = 4 - choices[i];

            if(score > 0) map.put(a, map.getOrDefault(a,0) + score);
            else if(score < 0) map.put(b, map.getOrDefault(b,0) + (score * -1));
        }

        for(int i=0; i<type.length-1; i++){
            int a = map.get(type[i]);
            int b = map.get(type[i+1]);

            if(a > b) answer += type[i];
            else if(a < b) answer += type[i+1];
            else if (a == b) answer += (type[i] > type[i+1]) ? type[i+1] : type[i];

            i++;

        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        String ans = new Solution().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5,3,2,7,5});

        System.out.println(ans);

    }
    
}
