import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public  int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>();  // 신고당한 횟수
        String stopUser [] = new String[id_list.length];        // 정지 당해야할 유저
        HashMap<String, ArrayList<String>> user_rpList = new HashMap<>();
        int cnt = 0;


        int[] answer = new int[id_list.length];

        // 유저별 신고 당한 횟수 담는 맵
        for(var id : id_list) {
            map.put(id, 0);
            user_rpList.put(id, new ArrayList<>());
        }


        LoopOut:
        for(int i=0; i < report.length; i++){
            boolean check = false;
             StringTokenizer st = new StringTokenizer(report[i]," ");
             String user = st.nextToken();
             String rp_user = st.nextToken();

             var tmp = user_rpList.get(user);


             for(var name: tmp) {
                 if(name.equals(rp_user))
                     check = true;
             }

             if(check == false) {
                 user_rpList.get(user).add(rp_user);
                 map.replace(rp_user, map.get(rp_user)+1);
             }


        }

        for(int i=0; i<id_list.length; i++) {
            if (map.get(id_list[i]) >= k)
                stopUser[cnt++] = id_list[i];
        }

        for(int i=0; i< id_list.length; i++){
            var tmp = user_rpList.get(id_list[i]);

            for(var name : tmp){
                for(int j=0; j< stopUser.length; j++){
                    if(name.equals(stopUser[j])){
                        answer[i]++;
                    }
                }
            }
        }


        return answer;
    }
}
