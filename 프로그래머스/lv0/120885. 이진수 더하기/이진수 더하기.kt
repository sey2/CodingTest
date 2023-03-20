class Solution {
    fun solution(bin1: String, bin2: String) = 
        Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2))
}