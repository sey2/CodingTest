fun main() {
    Solution().solution(intArrayOf(1, 1, 1, 1, 0), 3)
}

class Solution {
    fun solution(arr: IntArray, idx: Int): Int = arr.find(idx)

    private fun IntArray.find(idx: Int): Int {
        for (i in indices) {
            if (idx <= i && this[i] == 1) {
                return i
            }
        }
        return -1
    }
}