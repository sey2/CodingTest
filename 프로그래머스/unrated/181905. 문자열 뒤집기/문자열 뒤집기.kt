class Solution {
    fun solution(my_string: String, s: Int, e: Int): String 
        = my_string.substring(0 .. s-1) +
            my_string.substring(s..e).reversed() + my_string.substring(e+1 until my_string.length)
}