import java.util.Arrays;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {

        int dp[][] = new int[152][152];

        for(int i=0; i<=151; i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);

        int alpMax = alp;
        int copMax = cop;

        for(int problem[] : problems){
            alpMax = Math.max(problem[0],alpMax);
            copMax = Math.max(problem[1],copMax);
        }
        
        dp[alp][cop] = 0;

        for(int i=alp; i<=150; i++){
            for(int j=cop; j<=150; j++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);

                for(int k=0; k< problems.length; k++){
                    int alq_rwd = (i + problems[k][2] > alpMax) ? alpMax : i+problems[k][2];
                    int cop_rwd = (j + problems[k][3] > copMax) ? copMax : j+problems[k][3];
                    int cost = problems[k][4];
                    
                    if(i >= problems[k][0] && j >= problems[k][1] ) 
                      dp[alq_rwd][cop_rwd] = Math.min(dp[alq_rwd][cop_rwd], dp[i][j] + cost);
                }
            }
        }
        return dp[alpMax][copMax];
    }
}
