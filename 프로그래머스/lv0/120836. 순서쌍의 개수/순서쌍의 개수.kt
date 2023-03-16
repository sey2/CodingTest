class Solution {
    fun solution(n: Int) = List(n+1, {i->i}).count{it != 0 && n % it == 0}
}
