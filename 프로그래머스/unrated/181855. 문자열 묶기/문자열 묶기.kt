class Solution {
    fun solution(strArr: Array<String>): Int {
        var answer: Int = Int.MIN_VALUE
        var map = HashMap<Int, Int>()

        for(i in strArr.indices){
            val key = strArr[i].length
            val value = map.getOrDefault(key, 0) + 1;
            map[key] = value
            answer = answer.coerceAtLeast(value)
        }

        return answer
    }
}

