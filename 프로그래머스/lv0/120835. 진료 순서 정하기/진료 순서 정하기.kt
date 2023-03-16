class Solution {
    fun solution(emergency: IntArray): IntArray {
        var arr = emergency.sorted().reversed()
        var answer = IntArray(emergency.size)

        for(i in 0 until emergency.size)
            answer[i] = arr.indexOf(emergency[i]) + 1

        return answer
    }
}