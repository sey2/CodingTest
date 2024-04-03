class Main {
    fun solution(n: Int): Int {
        var digit = 1L
        var count = 9L
        var current = 1L
        var position = n.toLong()

        while (position > digit * count) {
            position -= digit * count
            digit += 1
            count *= 10
            current *= 10
        }

        current += (position - 1) / digit
        val numberAsString = current.toString()

        return numberAsString[((position - 1) % digit).toInt()].digitToInt()
    }
}

fun calculateTotalLength(n: Int): Long {
    var totalLength = 0L
    var digit = 1L
    var count = 9L
    var num = 1L

    while (num <= n) {
        if (num + count > n) {
            totalLength += (n - num + 1) * digit
            break
        } else {
            totalLength += count * digit
            num += count
            digit += 1
            count *= 10
        }
    }

    return totalLength
}

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map(String::toInt)
    val totalLength = calculateTotalLength(n)

    if (totalLength < k) {
        println(-1)
    } else {
        println(Main().solution(k))
    }
}
