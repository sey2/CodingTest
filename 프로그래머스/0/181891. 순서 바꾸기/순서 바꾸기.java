class Solution {
    public int[] solution(int[] num_list, int n) {
        int listSize = num_list.length;
        int[] answer = new int[listSize];
        
        int idx = 0;
        
        while (idx < listSize) {
            answer[idx] = num_list[(n++) % listSize];
            idx++;
        }
        
        
        return answer;
    }
}