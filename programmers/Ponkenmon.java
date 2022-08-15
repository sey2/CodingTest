class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length/2;
        boolean check[] = new boolean[200001];
        
        for(int number : nums){
            if(answer >= N) break;
            
            if(!check[number]){
                answer ++;
                check[number] = true;
            }    
        }
        
        
        return answer;
    }
}
