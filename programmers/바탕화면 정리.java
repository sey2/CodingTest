class Solution {
    public int[] solution(String[] wallpaper) {
        int lux, luy, rdx, rdy;
        
        lux = luy = Integer.MAX_VALUE;
        rdx = rdy = Integer.MIN_VALUE;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    lux = Math.min(lux, j);
                    luy = Math.min(luy, i);
                    rdx = Math.max(rdx, j);
                    rdy = Math.max(rdy, i);
                }
            }
        }
        return new int[]{luy, lux, rdy+1, rdx+1};
    }
}
