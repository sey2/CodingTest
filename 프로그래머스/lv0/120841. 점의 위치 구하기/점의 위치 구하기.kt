class Solution {
    fun solution(dot: IntArray) = when{
        (dot[0] < 0 && dot[1] >=0) -> 2
        (dot[0] < 0 && dot[1] < 0) -> 3
        (dot[0] >=0 && dot[1] >=0) -> 1
        (dot[0] >=0 && dot[1] < 0) -> 4
        else -> -1
    }
}