import java.io.*;
import java.util.*;


class Solution {
    public Object[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();

        String [] todayToken = today.split("\\.");

        // curDay = today
        int curDay = parseYear(todayToken[0]) + parseMonth(todayToken[1]) + parseDay(todayToken[2]);
        HashMap<String, Integer> term = new HashMap<>();

        // init terms
        for(int i=0; i<terms.length; i++){
            String tmp[] = terms[i].split(" ");
            term.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        for(int i=0; i<privacies.length; i++){
            String tokenDate[] = privacies[i].split("\\.| ");
            int targetDay = parseYear(tokenDate[0]) + parseMonth(tokenDate[1])+ parseDay(tokenDate[2]);
            int dueDay = targetDay + (term.get(tokenDate[3]) * 28)-1; // expireDate

            if(curDay > dueDay) list.add(i+1);
        }

        return list.toArray(new Integer[0]);
    }

    public int parseYear(String year){
        return Integer.parseInt(year) * 336;
    }

    public int parseMonth(String month){
        return Integer.parseInt(month) * 28;
    }

    public int parseDay(String day){
        return Integer.parseInt(day);
    }
}
