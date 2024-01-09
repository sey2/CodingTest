import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { 0L }

    val input = br.readLine().split(" ").map{ it.toLong() }
    repeat(n) {
        arr[it] = input[it]
    }

    var ans = 1

    for(i in 0 until arr.size) {
        var sum = arr[i]
        var count = 1

        for(j in i+1 until n) {
            if(sum >= arr[j]) {
                sum += arr[j]
                count++
            }
        }

        ans = max(ans, count)
    }

    println(ans)

}
