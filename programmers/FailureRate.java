import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Arrays.sort(stages);

        Map<Integer, Double> stageRatio = new HashMap<>();


        for(int i=1; i<=N; i++){
            int curStageNum = 0;
            int noClear = 0;

            if(i > stages[stages.length-1] )
                stageRatio.put(i, 0.0);
             else{
                for (int j = 0; j < stages.length; j++) {
                    if (stages[j] >= i) curStageNum++;

                    if (stages[j] == i && stages[j] >= i) noClear++;
                }
                stageRatio.put(i, (double) noClear / (double) curStageNum);
            }
        }

        List<Integer> keySetList = new ArrayList<>(stageRatio.keySet());
        Collections.sort(keySetList, (o1, o2) -> (stageRatio.get(o2).compareTo(stageRatio.get(o1))));

        int cnt  = 0;
        for(var a: keySetList)
            answer[cnt++] = a;


        return answer;
    }
}
