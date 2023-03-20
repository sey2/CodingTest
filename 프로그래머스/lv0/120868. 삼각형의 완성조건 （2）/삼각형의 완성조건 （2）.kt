class Solution {
    fun solution(sides: IntArray): Int {
        val max = Math.max(sides[0],sides[1])
        val min = Math.min(sides[0], sides[1])

        return (max - (max - min) + 1) + (max + min - max-2)
    }
}