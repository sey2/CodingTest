import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String arr[] = polynomial.split(" ");
        
        int xNum = 0;
        int num = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].contains("x") == true) 
                xNum += getX(arr[i]);
            else if(!arr[i].equals("+"))
                num += Integer.parseInt(arr[i]);    
        }
        
        if(num == 0 && xNum > 1)
            return String.valueOf(xNum) + "x";
        else if(xNum == 0)
            return String.valueOf(num);
        else if(xNum == 1 && num == 0) 
            return "x";
        
        String x = (xNum == 1) ? "x" : xNum + "x";
        
        return x + " + " + String.valueOf(num);
    }
    
    public int getX(String x) {
        int num = (x.equals("x") == true) ? 1 : Integer.parseInt(x.replaceAll("x", ""));
        return num;
    }
}