class Solution {
    fun solution(str1: String, str2: String): String {
        return List(str1.length) { i -> "" + str1[i] + str2[i] }.joinToString(separator = "")
    }
}
