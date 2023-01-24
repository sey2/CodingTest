
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++){
            if(isEven(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public boolean isEven(int num){
        int divisorNum = 0 ;

        for(int i=1; i<=num; i++)
            if(num % i == 0) divisorNum ++;

        return (divisorNum % 2 == 0) ? true : false;
    }
}