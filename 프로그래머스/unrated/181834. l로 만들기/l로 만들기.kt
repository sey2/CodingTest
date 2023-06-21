class Solution {
    fun solution(myString: String) = myString.map{ char -> if(char < 'l') 'l' else char}.joinToString("")
}