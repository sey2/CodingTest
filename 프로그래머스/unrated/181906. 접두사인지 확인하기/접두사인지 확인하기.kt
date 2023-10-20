class Solution {
    fun solution(my_string: String, is_prefix: String): Int {
        return if(my_string.indexOf(is_prefix) == 0) 1 else 0 
    }
}