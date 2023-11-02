class Solution {
    boolean solution(String s) {
        int numP = 0;
        int numY = 0;
        
        String str = s.toUpperCase();
        for(int i=0; i<s.length(); i++) {
            if(str.charAt(i) == 'P')  numP ++;
            else if(str.charAt(i) == 'Y') numY++;
        }
        
        return (numP == numY) ? true : false;
    }
}