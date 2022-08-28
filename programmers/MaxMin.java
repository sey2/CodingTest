
class Solution {
    public String solution(String s) {
        String str[] = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<str.length; i++){
            min = Math.min(min, Integer.parseInt(str[i]));
            max = Math.max(max, Integer.parseInt(str[i]));
        }

        return min+ " " + max;
    }
}

