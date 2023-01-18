import java.io.*;
import java.util.*;

class Solution {
    public Object[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();

        String [] todaySplit = today.split("\\.");

        int curDay = (Integer.parseInt(todaySplit[0]) * 336) + (Integer.parseInt(todaySplit[1])  * 28)+ Integer.parseInt(todaySplit[2]);
        HashMap<String, Integer> term = new HashMap<>();

        // init terms
        for(int i=0; i<terms.length; i++){
            String tmp[] = terms[i].split(" ");
            term.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        for(int i=0; i<privacies.length; i++){
            String parseDay[] = privacies[i].split("\\.| ");
            int targetDay = (Integer.parseInt(parseDay[0]) * 336) + (Integer.parseInt(parseDay[1]) * 28) + Integer.parseInt(parseDay[2]);
            int expDay = targetDay + (term.get(parseDay[3]) * 28)-1;

            if(curDay > expDay) list.add(i+1);
        }

        return list.toArray(new Integer[0]);
    }
}
