class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        var input: String = my_string.replace("[a-z|A-Z]".toRegex(), " ")
        val arr = input.split(" ")
        
        for(i in 0 until arr.size){
            if(arr[i] ==" " || arr[i] =="") continue
            answer += arr[i].toInt()
        }
        
        print(arr)
        
        return answer
    }
}