class Solution {
    fun solution(numbers: IntArray, n: Int): Int = run { 
        var sum = 0
        numbers.forEach { 
            sum += it 
            if(sum > n) return sum
        }
        return sum
    }
}