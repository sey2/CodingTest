class Solution {
    fun solution(my_string: String): Int {
        val token = my_string.split(" ")
        var answer = Integer.parseInt(token[0])

        for(i in 1 until token.size-1 step 2){
            when(token[i]){
                "+" -> answer += Integer.parseInt(token[i+1])
                "-" -> answer -= Integer.parseInt(token[i+1])
            }
        }
        return answer
    }
}