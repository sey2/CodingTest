class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val complete = mutableListOf<Int>()

        for(i in 0 until progresses.size){
            val nonClear = 100 - progresses[i]
            val pr = if(nonClear % speeds[i] == 0) nonClear/speeds[i] else nonClear/speeds[i] + 1
            complete.add(pr)
        }

        var cnt = 1
        var cur = complete.get(0)
        for(i in 1 until complete.size){
            if(complete.get(i) <= cur)
                cnt++
            else{
                answer.add(cnt)
                cnt = 1
                cur = complete.get(i)
            }
        }
        answer.add(cnt)

        return answer.toIntArray()
    }
}