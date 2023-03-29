class Solution {
    public int solution(int[][] sizes) {

        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;


        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1])
                sizes = swap(sizes, i);

            width = Math.max(width, sizes[i][0]);
            height = Math.max(height, sizes[i][1]);
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