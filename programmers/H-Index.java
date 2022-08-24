import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp,Collections.reverseOrder());

        int len = tmp.length;

        for(int i=0; i<len; i++){
            if(tmp[i] <= i) return i;
        }

        return len;
    }
}
