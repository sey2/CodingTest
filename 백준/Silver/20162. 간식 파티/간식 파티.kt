import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    var n = br.readLine().toInt()
    val arr = IntArray(n)
    var dp = IntArray(n)

    for(i in 0 until n) {
        arr[i] = br.readLine().toInt()
        dp[i] = arr[i]
    }

    var max = 0
    for(i in 0 until n) {
        for(j in 0 until i) {
            if(arr[i] > arr[j])
                dp[i] = max(dp[j] + arr[i], dp[i])
        }
        max = max(dp[i], max)
    }

    println(max)

}