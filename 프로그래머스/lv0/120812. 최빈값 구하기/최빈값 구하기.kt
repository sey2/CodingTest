class Solution {
    fun solution(array: IntArray): Int {
        var map = mutableMapOf<Int, Int>()

        for((i, v) in array.withIndex())
            map[v] = map.getOrDefault(v, 0) + 1

        val result = map.toList().sortedBy { (_, value) -> value }.reversed()

        return if(result.size != 1 && result.get(0).second == result.get(1).second) -1
               else result.get(0).first
    }
}