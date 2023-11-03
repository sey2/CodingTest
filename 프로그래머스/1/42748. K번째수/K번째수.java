import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int copyArr[] = getArray(commands[i][0], commands[i][1], array);
            Arrays.sort(copyArr);
            answer[i] = copyArr[commands[i][2]-1];
        }
        
        return answer;
    }
    
    public int[] getArray(int start, int end, int target[]) {
        int arr[] = new int[end - start + 1];
        
        for(int i=0; i<end - start + 1; i++) {
            arr[i] = target[start - 1 + i];
        }
        return arr;
    }
}