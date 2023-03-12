class Solution {
    fun solution(strlist: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        for(i in strlist.indices)
            answer.add(strlist.get(i).length)

        return answer.toIntArray()
    }
}