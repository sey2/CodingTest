class Solution {
    fun solution(my_string: String): Array<String> =
        my_string.mapIndexed { index, c -> 
            my_string.substring(index until my_string.length)
        }.toTypedArray().sortedArray()
}
