import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var arr = Array(n) { 0L }

    val input = br.readLine().split(" ").map { it.toLong() }
    repeat(n) { index ->
        arr[index] = input[index]
    }

    arr = arr.sorted().toTypedArray()

    if(n == 1) {
        println(arr[0])
        return
    }

    var ans = 0L
    val last = if(n % 2 == 0) arr.size / 2 else (arr.size / 2) + 1
    val index = if(n % 2 == 0) arr.size-1 else arr.size-2
    for(i in 0 until last) {
        ans = max(arr[i] + arr[index-i], ans)
    }

    println(max(ans, arr[n-1]))

}
