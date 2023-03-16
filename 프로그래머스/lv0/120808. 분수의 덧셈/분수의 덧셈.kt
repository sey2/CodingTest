class Solution {
    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        val a = numer1 * denom2 + numer2 * denom1
        val b = denom1 * denom2
        var max = 1
        
        for(i in 1..a){
            if(a%i == 0 && b%i == 0)
                max = i
        }
        
        
        return intArrayOf(a/max, b/max)
    }
}