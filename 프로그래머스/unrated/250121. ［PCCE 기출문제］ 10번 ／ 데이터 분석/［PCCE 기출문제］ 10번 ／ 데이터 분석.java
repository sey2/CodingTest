import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int y = getIndex(sort_by);
        int[][] newData = newData(data, ext, val_ext);
        Arrays.sort(newData, (i1, i2) -> i1[y] - i2[y]);
        
        return newData;
    }
    
    public int[][] newData(int[][] data, String ext, int valExt) {
        int y = getIndex(ext);
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][y] < valExt) {
                list.add(data[i]);
            }
        }
        
        int[][] newData = new int[list.size()][data[0].length];
        
        for(int i = 0; i < list.size(); i++) {
            newData[i] = list.get(i);
        }
        return newData;
    }
    
    public int getIndex(String str) {
        switch(str) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return -1;
        }
    }
}