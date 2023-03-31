class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer = ArrayList<Int>()

        for(i in photo.indices){
            var sum = 0
            for(j in photo[i].indices){
                var idx = name.indexOf(photo[i][j])
                sum += if(idx >= 0) yearning[idx] else 0
            }
            answer.add(sum)
        }

        return answer.toIntArray()
    }
}