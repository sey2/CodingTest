import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0;
        int zeroCnt = 0; 

        for(int i=0; i<win_nums.length; i++){
            for(int j=0; j<lottos.length; j++){
                
                if(lottos[j] == 0 && i == 0){
                    zeroCnt++;
                    continue;
                }
                else if(lottos[j] == win_nums[i]) correct++;
            }
        }


        int[] answer = new int[2];
        
        answer[1] = rank(correct);
        correct += zeroCnt;
        answer[0] = rank(correct);

        return answer;
    }

    public static int rank(int correct){
        switch(correct){
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
