class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var token = s.split(" ")
        
        for(i in 0 until token.size){            
            if(token[i] != "Z") answer += token[i].toInt()
            else answer -= token[i-1].toInt()
            println("$answer")
        }
        
        return answer
    }
}