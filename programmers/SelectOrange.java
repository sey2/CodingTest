import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> orange = new HashMap<>();

        for(int i=0; i<tangerine.length; i++)
            orange.put(tangerine[i], orange.getOrDefault(tangerine[i], 0) + 1);

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(orange.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        int answer = 0;
        for(int i=entryList.size()-1; i>=0; i--){
            if(k <= 0) break;
            k -= entryList.get(i).getValue();
            answer ++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(new Solution().solution(6, new int[]{1,3,2,5,4,5,2,3}));

    }
}
