class Solution {
    fun solution(score: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        val avgArr = score.map{ listOf(it[0],it[1]).average()}
        val sortedArr = avgArr.sorted().reversed()

        for((i, v) in sortedArr.withIndex()){
            answer.add(sortedArr.indexOf(avgArr[i]) + 1)
        }

        return answer.toIntArray()
    }
}