class Solution {
    fun solution(my_string: String, indices: IntArray): String
        = my_string.mapIndexed {index, c -> if(indices.contains(index)) "" else "$c"}.joinToString("")
}