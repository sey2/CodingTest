class Solution {

    var max = Integer.MIN_VALUE
    fun solution(numbers: IntArray): Int {
        combination(numbers, BooleanArray(numbers.size), 0, 2 )
        return max
    }

    fun combination(arr: IntArray, visited: BooleanArray, start: Int, r: Int){
        if(r == 0){
            var sum = 1
            for(i in 0 until arr.size){
                if(visited[i])
                    sum *= arr[i]
            }
            max = Math.max(sum, max)
            return
        }

        for(i in 0 until arr.size){
            if(!visited[i]){
                visited[i] = true
                combination(arr, visited, start + 1, r - 1)
                visited[i] = false
            }
        }
    }
}
fun main(){
    var ans = Solution().solution(intArrayOf(1, 2, -3, 4, -5));
    print(ans)
}
