class Solution {
    fun solution(numLog: IntArray): String {
        val answer = StringBuilder()

        for(i in 1 until numLog.size) {
            val char = when(numLog[i]) {
                numLog[i-1] - 1 -> 's'
                numLog[i-1] + 1 -> 'w'
                numLog[i-1] - 10 -> 'a'
                numLog[i-1] + 10 -> 'd'
                else -> {}
            }
            answer.append(char)
        }

        return answer.toString()
    }
}
