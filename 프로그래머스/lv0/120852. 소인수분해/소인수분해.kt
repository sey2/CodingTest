
class Solution {
    var set: HashSet<Int> = HashSet<Int>()

    fun solution(n: Int): IntArray{
        factorization(n)
        return set.toIntArray().sortedArray()
    }

    fun factorization(n: Int){
        var N = n

        var i = 2
        while (N >= 2) {
            if (N % i == 0) {
                set.add(i)
                N /= i
            } else {
                i++
            }
        }
    }
}