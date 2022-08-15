
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(isPrime(nums[i] + nums[j] + nums[k])) answer ++;
                }
            }
        }

        return answer;
    }

    boolean isPrime(int number) {
        if(number == 0 || number ==1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
