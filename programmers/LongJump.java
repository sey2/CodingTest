class Solution {
    public long solution(int n) {
        long dp[] = new long[20001];
        dp[1] = 1; dp[2]=2; dp[3]=3;
        
        if(n<=3) return dp[n];
        
        for(int i=4; i<=n; i++)
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        
        return dp[n];
    }
}
