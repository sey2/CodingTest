class Solution {
    fun solution(my_string: String, index_list: IntArray): String
        = index_list.map { index -> my_string[index] }.joinToString("")
}

