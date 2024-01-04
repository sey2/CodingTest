import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Friend> map = new HashMap<>();

        for(int i=0; i<friends.length; i++) map.put(friends[i], new Friend());

        for(int i=0; i<gifts.length; i++) {
            String gift[] = gifts[i].split(" ");

            Friend a = map.get(gift[0]);
            Friend b = map.get(gift[1]);

            a.totalGive += 1;
            a.giveLog.put(gift[1], a.giveLog.getOrDefault(gift[1], 0) + 1);

            b.totalReceive += 1;
            b.receiveLog.put(gift[0], b.receiveLog.getOrDefault(gift[0], 0) + 1);

            map.put(gift[0], a);
            map.put(gift[1], b);
        }

        HashMap<String, Integer> nextMonth = new HashMap<>();
        for(String key: map.keySet()) nextMonth.put(key, 0);

        for(int i=0; i<friends.length-1; i++) {
            Friend a = map.get(friends[i]);

            for(int j=i+1; j< friends.length; j++) {
                Friend b = map.get(friends[j]);

                if(a.giveLog.getOrDefault(friends[j], 0) > a.receiveLog.getOrDefault(friends[j], 0)) {
                    nextMonth.put(friends[i], nextMonth.getOrDefault(friends[i], 0) + 1);
                }else if((a.giveLog.getOrDefault(friends[j], 0) < a.receiveLog.getOrDefault(friends[j], 0))) {
                    nextMonth.put(friends[j], nextMonth.getOrDefault(friends[j], 0) + 1);
                }else {
                   int aGiftScore = a.totalGive - a.totalReceive;
                   int bGiftScore = b.totalGive - b.totalReceive;

                   if(a.giveLog.getOrDefault(friends[j], 0) - a.receiveLog.getOrDefault(friends[j], 0) == 0) {
                       if(bGiftScore > aGiftScore)  nextMonth.put(friends[j], nextMonth.getOrDefault(friends[j], 0) + 1);
                       else if(bGiftScore < aGiftScore) nextMonth.put(friends[i], nextMonth.getOrDefault(friends[i], 0) + 1);
                   }
                }
            }
        }

        for(String key: nextMonth.keySet()) {
            answer = Math.max(nextMonth.getOrDefault(key, 0), answer);
        }


        return answer;
    }
}

class Friend {
    int totalGive = 0;
    int totalReceive = 0;
    HashMap<String, Integer> giveLog = new HashMap<>();
    HashMap<String, Integer> receiveLog = new HashMap<>();
}
