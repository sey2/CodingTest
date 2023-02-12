import java.util.HashMap;


class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;


        for(int i=0; i<=discount.length-10; i++){
            HashMap<String, Integer> tmp = initHashMap(want, number);

           // 현재일로 부터 10일 이후까지 원하는 물품이 있는지 검사 
            for(int j=i; j<10+i; j++){

               // 원하는 물품이 있으면 해쉬맵에서 값을 -1한다.
                if(tmp.containsKey(discount[j])) {
                    tmp.put(discount[j], tmp.get(discount[j]) - 1);
                  
                  // 만약 원하는 물품을 모두 구했으면 해쉬맵에서 키 값을 지운다. 
                    if(tmp.get(discount[j]) == 0)
                      tmp.remove(discount[j]);
                }

            }

           // 해쉬맵 크기가 0 이면 원하는 물품을 모두 구매한 것이며 answer +1 해준다.
            if(tmp.size() == 0) answer ++;

        }

        return answer;
    }

    // 필요한 물품을 해쉬맵에 담음
    public HashMap<String, Integer> initHashMap(String[] want, int[] number){
        HashMap<String, Integer> wantMap = new HashMap<>();

        for(int i=0; i<want.length; i++)
            wantMap.put(want[i], number[i]);

        return wantMap;
    }

}
