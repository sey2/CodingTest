class Solution {
    fun solution(code: String): String {
        var answer: String = ""
        var mode = 0

        for(i in code.indices){
            when (mode) {
                0 -> if(code[i] == '1')
                    mode = 1
                else if(code[i] != '1' && i % 2 == 0)
                    answer += code[i]
                1 -> if(code[i] == '1')
                    mode = 0
                else if(code[i] != '1' && i % 2 != 0)
                    answer += code[i]
            }
        }

        if(answer.length == 0) return "EMPTY"
        return answer
    }
}