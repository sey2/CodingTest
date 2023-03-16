class Solution {
    fun solution(n: Int) = n.toString().
                            toCharArray().  
                            map{it - '0'}.
                            toTypedArray().sum()
}