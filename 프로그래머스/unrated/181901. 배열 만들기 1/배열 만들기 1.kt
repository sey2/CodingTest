class Solution {
    fun solution(n: Int, k: Int): IntArray 
        = (1..n).toMutableList().filter { it % k == 0 }.toIntArray()
}