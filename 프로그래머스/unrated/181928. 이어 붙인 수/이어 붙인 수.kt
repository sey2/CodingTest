class Solution {
    fun solution(num_list: IntArray): Int {
        var odd = num_list.filter { it % 2 != 0 }
        var even = num_list.filter {it % 2 == 0}

        var a = odd.joinToString("")
        var b = even.joinToString("")

        return a.toInt() + b.toInt()
    }
}