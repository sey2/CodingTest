class Solution {
    fun solution(letter: String): String {
        var answer: String = ""

        var morse = listOf(
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        )


        val arr = letter.split(" ")

        loop@
        for(str in arr){
            for((i, v) in morse.withIndex()){
                if(str == v){
                    answer += 'a' + i
                    continue@loop
                }
            }
        }
        return answer
    }
}