import kotlin.math.sqrt

class Solution {
    fun solution(n: Int): Int = 
        if(sqrt(n.toDouble()) == sqrt(n.toDouble()).toInt().toDouble()) 1 else 2
    
}