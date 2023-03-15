class Solution {
    fun solution(my_string: String): String = my_string.replace("a|e|i|o|u".toRegex(), "")
}