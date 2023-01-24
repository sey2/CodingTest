import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> answer = new ArrayList<>();

        for(var s : strings) answer.add(s);

        Collections.sort(answer, (o1,o2)->{return o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) :o1.charAt(n) - o2.charAt(n);});

        return answer.toArray(new String[0]);
    }
}
