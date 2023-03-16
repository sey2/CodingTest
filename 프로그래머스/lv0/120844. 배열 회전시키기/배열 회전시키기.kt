class Solution {
    fun solution(numbers: IntArray, direction: String) =
        if(direction == "left") numbers.slice(1 until numbers.size).plus(numbers[0])
        else intArrayOf(numbers[numbers.size-1]).plus(numbers.slice(0 until numbers.size-1))
}
