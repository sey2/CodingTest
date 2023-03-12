class Solution {
    fun solution(array: IntArray): IntArray = array.maxOrNull().let{
        intArrayOf(it?:0, array.indexOf(it?:0))
    }

}