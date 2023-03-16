class Solution {
    fun solution(letter: String): String {
        var answer: String = ""

        var morse = listOf(
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        )


        val arr = letter.split(" ")

        for(str in arr)
            answer += 'a' + morse.indexOf(str)
        
        return answer
    }
}