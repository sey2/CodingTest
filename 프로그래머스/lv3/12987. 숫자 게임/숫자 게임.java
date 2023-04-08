import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int ap = 0;
        int bp = 0;
        int re = 0;

        for(int i=0; i<A.length; i++, bp++){
            if(A[ap] >= B[bp])
                continue;
            
            ap++;
            re++;

        }

        return re;
    }
}
