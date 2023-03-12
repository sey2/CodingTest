class Solution {
    fun solution(numbers: IntArray): Int =
        numbers.sorted().reversed().let {
            it[0]*it[1]
    }
}
