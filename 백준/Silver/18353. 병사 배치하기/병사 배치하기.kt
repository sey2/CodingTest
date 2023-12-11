import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()

    var n = br.readLine().toInt()
    val arr = IntArray(n)

    val input = br.readLine().split(" ").map { it.toInt() }
    for(i in 0 until n)
        arr[i] = input[i]

    var a = n;
    val ans = IntArray(n)
    for(i in 1 until n) {
        for(j in 0 until i ) {
            if(arr[j] > arr[i])
                ans[i] = max(ans[i], ans[j] + 1)
            a = min(a, n - ans[i] - 1)
        }
    }

    println(if(a == n) 0 else a)
}