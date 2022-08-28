import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') queue.add(')');
            else{
                if(queue.isEmpty()) return false;
                else queue.poll();
            }

        }

        return queue.isEmpty();
    }
}

/*
class Solution {
    boolean solution(String s) {
        int cnt=0;
      
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                while(i<s.length() && s.charAt(i) == ')'){
                    cnt --;
                    i++;
                }
                i--;
            }else {
                cnt ++;
                continue;
            }

            if(cnt < 0) return false;

        }

        return (cnt == 0) ? true : false;
    }
}
*/
