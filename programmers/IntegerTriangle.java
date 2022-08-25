class Solution {
    public int solution(int[][] triangle) {

        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0; j< triangle[i].length; j++){
                int sum1 = triangle[i+1][j] + triangle[i][j];
                int sum2 = triangle[i+1][j+1] + triangle[i][j];

                triangle[i][j] = Math.max(sum1,sum2);
            }
        }

        return triangle[0][0];
    }
}
