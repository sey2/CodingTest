class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean check[] = new boolean[n+1];

        long cur = -1;
        for(int i=0; i<section.length; i++){
            if(section[i] <= cur) continue;

            cur = section[i] + (m-1);

            answer ++;

        }

        return answer;
    }
}
