class Solution {
    fun solution(num_list: IntArray, n: Int) = num_list.filterIndexed{idx, s -> idx % n == 0}
}