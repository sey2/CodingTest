
class Solution {
    public int solution(int n) {
        int oneNum1 = binaryConverter(n);

        for(int i=n+1; i<1000000; i++) {
            int oneNum2 = binaryConverter(i);

            if(oneNum1 == oneNum2) return i;
        }

        return 0;
    }

    public int binaryConverter(int n){
        int oneNum = 0;
        while(n >= 1){
            int divisor = n % 2;
            n /= 2;

            if(divisor == 1) oneNum ++;
        }
        return oneNum;
    }
}
