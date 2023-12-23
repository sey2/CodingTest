class Solution {
    fun solution(names: Array<String>): Array<String> 
        = names.filterIndexed { index, s -> index % 5 == 0 || index == 0 }.toTypedArray()
}