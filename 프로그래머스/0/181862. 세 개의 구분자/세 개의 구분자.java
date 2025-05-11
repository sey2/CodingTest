import java.util.*;

class Solution {
    // 예를 들어 주어진 문자열이 "baconlettucetomato"라면
    // 나눠진 문자열 목록은 ["onlettu", "etom", "to"]

    public String[] solution(String myStr) {
        List<String> answer = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myStr.length(); i++) {
            char current = myStr.charAt(i);

            if (current != 'a' && current != 'b' && current != 'c') {
                sb.append(current);
            } else {
                if (sb.length() > 0) {
                    answer.add(sb.toString());
                    sb = new StringBuilder();
                }

            }
        }
        
            
        if (sb.length() > 0) {
            answer.add(sb.toString());
        }
        
        if(answer.size() == 0) {
            answer.add("EMPTY");
        }     
            
        String[] answerList = answer.toArray(String[]::new);
            
        return answerList;
    }
}