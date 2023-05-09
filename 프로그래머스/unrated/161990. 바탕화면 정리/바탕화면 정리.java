class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int minX, minY;
        int maxX, maxY;
        
        minX = minY = 51;
        maxX = maxY = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(j, minX);
                    minY = Math.min(i, minY);
                    maxX = Math.max(j, maxX);
                    maxY = Math.max(i, maxY);
                }
            }
        }
        
        
        return new int[]{minY, minX, maxY+1, maxX+1};
    }
}

class Cor{
    int y, x;

    Cor(int y, int x){
        this.y = y;
        this.x = x;
    }
}