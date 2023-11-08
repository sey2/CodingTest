import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++) {
            String input = br.readLine();

            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=0; j<input.length(); j++)
                map.put(input.charAt(j), map.getOrDefault(input.charAt(j), 0) + 1);

            Set<Character> keySet = map.keySet();
            ArrayList<Character> list = new ArrayList<>();
            for(char c : keySet) {
                if(map.get(c) % 2 != 0) {
                    list.add(c);
                }
            }

            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(char c : list)
                sb.append(c);

            if(sb.toString().equals(""))
                sb = new StringBuilder("Good");

            System.out.println("#" + i + " " + sb);
        }
    }
}

