import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1,s.length()-1).replace("{","").replace(","," ");
        String str[] = s.split("}");
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<str.length; i++) {
            StringTokenizer st = new StringTokenizer(str[i]);

            while(st.hasMoreTokens()) {
                int key = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        ArrayList<Integer> answer = new ArrayList<>();

        for(var entry : entryList){
            answer.add(entry.getKey());
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
