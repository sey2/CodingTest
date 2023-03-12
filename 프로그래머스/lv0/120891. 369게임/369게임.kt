class Solution {
    fun solution(order: Int): Int =
        order.toString().count{it == '3' || it == '6' || it == '9'}
      
}