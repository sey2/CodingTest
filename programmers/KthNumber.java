import java.util.*; 

class Solution {
    public static int[] solution(int[] array, int[][] commands) {

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<commands.length; i++){
            int arr[] = new int[(commands[i][1] - commands[i][0])+1];
            int cnt = 0;

            for(int j=commands[i][0]-1; j<commands[i][1]; j++)
                arr[cnt++] = array[j];


            Arrays.sort(arr);

            answer.add(arr[commands[i][2]-1]);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
