class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0

        val sortedTargets = targets.sortedBy { it[1] }

        var current = Int.MIN_VALUE
        for((s, e) in sortedTargets) {
            if(current <= s) {
                answer ++
                current = e
            }
        }

        return answer
    }
}
