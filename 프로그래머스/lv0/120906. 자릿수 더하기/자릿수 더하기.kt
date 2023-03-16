class Solution {
    fun solution(n: Int) = n.toString().toCharArray().toList().map{it - '0'}.toTypedArray().sum()
}