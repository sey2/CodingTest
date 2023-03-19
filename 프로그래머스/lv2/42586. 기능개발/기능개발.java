import java.util.ArrayList;
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public Object[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int complete[] = new int[progresses.length];

        for(int i=0; i<progresses.length; i++){
            int nClear = 100 - progresses[i];
            complete[i] = nClear % speeds[i] == 0 ? nClear / speeds[i] : nClear / speeds[i] + 1;
        }

        int cnt = 1;
        int cur = complete[0];
        for(int i=1; i<complete.length; i++){
            if(cur >= complete[i]){
                cnt ++;
            }else{
                list.add(cnt);
                cur = complete[i];
                cnt = 1;
            }
        }
        list.add(cnt);

        return list.toArray();
    }
}