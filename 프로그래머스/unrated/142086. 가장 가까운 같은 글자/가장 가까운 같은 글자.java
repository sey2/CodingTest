class Solution {
    public int[] solution(String s) {
        int answer [] = new int[s.length()];
        
        loop:
        for(int i=0; i<s.length(); i++){
            for(int j=i-1; j>=0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    answer[i] = i-j;
                    continue loop;
                }
            }
            answer[i] = -1;
        }
        return answer;
    }
}