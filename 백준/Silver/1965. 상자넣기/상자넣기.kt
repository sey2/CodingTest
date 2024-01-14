import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map{ it.toInt() }
    val dp = IntArray(n) {0}

    for(i in 0 until arr.size) {
        dp[i] = 1
        for(j in 0 until i) {
            if(arr[j] < arr[i]) dp[i] = max(dp[i], dp[j] +1)
        }
    }

    println(dp.max())
}
