import java.util.*;

class Solution {
    public Integer[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, HashSet<String>> map = new HashMap();

        // [신고 당한 사람, 신고한 사람]
        for(int i=0; i<id_list.length; i++)
            map.put(id_list[i], new HashSet<>());

        for(int i=0; i<report.length; i++){
            String key = report[i].split(" ")[1];
            String value = report[i].split(" ")[0];

            map.get(key).add(value);
        }

        HashMap<String, Integer> mail = new HashMap<>();

        for(int i=0; i<id_list.length; i++)
            mail.put(id_list[i], 0);

        for(int i=0; i<id_list.length; i++){
            if(map.get(id_list[i]).size() >= k){
                for(String value : map.get(id_list[i])){
                    mail.put(value, mail.getOrDefault(value, 0) + 1);
                }
            }
        }

        for(String str : id_list)
            answer.add(mail.get(str));

        return answer.toArray(new Integer[0]);
    }
}
