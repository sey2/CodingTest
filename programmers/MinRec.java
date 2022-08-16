class Solution {
    public int solution(int[][] sizes) {
        
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1])  sizes = swap(sizes, i);
            
            // 가로 sizes[i][0], 세로 sizes[i][1];
            width = width < sizes[i][0] ? sizes[i][0] : width;
            height = height < sizes[i][1] ? sizes[i][1] : height;
        }
        
        
        return width * height;
    }
    
    public int[][] swap(int [][] sizes, int i){
        int tmp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = tmp;
        
        return sizes;
    }
}


/*
  문제를 보면 가로x세로 길이를 명시해 놓았지만 간단히 생각하면,
  사실 어떤 모서리든 가로가 될 수도 있고 세로도 될 수가 있다.
  
   ex) 명함 2 | 가로 30 | 세로 70 | 라고 문제에 명시 되어 있지만 아래와 같이 변경할 수 있다.
       명함 2 | 가로 70 | 세로 30 | 
 
  위 예제처럼 모서리를 가로로 정하면 다른 모서리는 세로가 된다. 
 
  두 개의 모서리를 비교하여 큰 값을 전부 가로, 작은 값을 전부 세로로 둔 후
  각 모서리의 길이의 최댓값을 구하여 곱해주면 답이 된다.
*/

/*

번호	가로  세로                번호  가로  세로        
 1	  60	  50                1    60    50
 2	  30	  70         ->     2    70    30     -> 가로 최대 값 80,   세로 최대 값 50
 3	  60	  30                3    60    30         = 80 * 50 = 4000
 4	  80	  40                4    80    40

*/
