class Solution {
    fun solution(n: Int) = List(n+1, {i->i}).filter{it % 2 != 0}
    
}