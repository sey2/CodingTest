class Solution {
    lateinit var visited: BooleanArray
    var cnt = 0
    
    fun solution(balls: Int, share: Int): Int {
        visited = BooleanArray(balls)
        combination(0, share, balls)

        return cnt
    }

    fun combination(start: Int, r: Int, n: Int){
        if(r == 0) {
            cnt ++
            return
        }

        for(i in start .. n-1){
            if(!visited[i]){
                visited[i] = true
                combination(i + 1, r - 1, n)
                visited[i] = false
            }
        }
    }
}