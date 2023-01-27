import java.util.ArrayList;


class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder("");
        ArrayList<Character> lower = new ArrayList<>();
        ArrayList<Character> upper = new ArrayList<>();

        for(char i='a'; i<='z'; i++) lower.add(i);
        for(char i='A'; i<='Z'; i++) upper.add(i);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z')
                answer.append(lower.get((lower.indexOf(c) + n) % lower.size()));
            else if(c >= 'A' && c <= 'Z')
                answer.append(upper.get((upper.indexOf(c) + n) % upper.size()));
            else
                answer.append(" ");
        }


        return answer.toString();
    }
}
