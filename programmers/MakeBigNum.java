import java.io.IOException;


class Solution {
    public String solution(String number, int k) {
        int num[] = new int[10];

        for (int i = 0; i < number.length(); i++)
            num[number.charAt(i) - 48]++;

        StringBuilder sb = new StringBuilder(number);

        int target = 0;

        loopOut:
        while(k > 0){
            int cnt = 0;
            for(int i=target+1; i<sb.length() && cnt <k; i++){
                if(sb.charAt(target) - 48 < sb.charAt(i) - 48) {
                    sb = sb.deleteCharAt(target);
                    k--;
                    continue loopOut;
                }
                cnt ++;
            }

            target++;

            if(target >= sb.length()) return sb.substring(0, sb.length() - k);
        }


        return sb.toString();
    }
}

