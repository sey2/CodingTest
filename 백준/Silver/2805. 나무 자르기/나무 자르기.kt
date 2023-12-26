fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toLong() }

    val arr = br.readLine().split(" ").map { it.toLong() }

    var low: Long = 0 
    var high: Long = arr.maxOrNull() ?: 0 
    var max: Long = 0 

    while (low <= high) {
        val mid: Long = (low + high) / 2
        var sum: Long = 0

        for (height in arr) {
            if (height > mid) sum += (height - mid)
        }

        if (sum >= m) {
            max = mid 
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    println(max)
}
