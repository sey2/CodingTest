
class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        for(i in 0 until commands.size){
            var sort = array.slice(commands[i][0]-1 .. commands[i][1]-1)
            answer.add(sort.sorted()[commands[i][2]-1])
        }
        return answer.toIntArray()
    }
}