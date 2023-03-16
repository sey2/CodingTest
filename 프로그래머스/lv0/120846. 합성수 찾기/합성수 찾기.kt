class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0

        for(i in 4..n){
            if(check(i)) answer ++
        }

        return answer
    }

    fun check(num: Int): Boolean{
        var cnt = 0
        for(i in 1..num){
            if(num % i == 0) cnt ++
            if(cnt == 3) return true
        }
        return false
    }
}