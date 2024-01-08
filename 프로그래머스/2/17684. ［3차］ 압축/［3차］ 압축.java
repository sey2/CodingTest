import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    HashMap<String, Integer> dic = new HashMap<>();
    public int[] solution(String msg) {
        int index = 1;

        ArrayList<Integer> list = new ArrayList<>();
        for(char c = 'A'; c <= 'Z'; c++)
            dic.put(c + "", index++);

        loopOut:
        for(int i=0; i<msg.length(); i++) {

            String prev = "";
            for(int j=1; i+j<=msg.length(); j++) {
                String str = msg.substring(i, i + j);

                if(!dic.containsKey(str)) {
                    dic.put(str, index++);
                    list.add(dic.get(prev));
                    i += j-2;
                    break;
                }else if(dic.containsKey(str) && i+j == msg.length()) {
                    list.add(dic.get(str));
                    break loopOut;
                }

                prev = str;

            }
        }
        
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}