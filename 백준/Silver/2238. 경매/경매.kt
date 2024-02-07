import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (U, N) = br.readLine().split(" ").map { it.toInt() }
    val bids = mutableListOf<Pair<String, Int>>()
    val priceCount = mutableMapOf<Int, Int>()

    repeat(N) {
        val (name, price) = br.readLine().split(" ")
        val priceInt = price.toInt()
        if (priceInt <= U) {
            bids.add(Pair(name, priceInt))
            priceCount[priceInt] = priceCount.getOrDefault(priceInt, 0) + 1
        }
    }

    val leastBids = priceCount.filter { it.value == priceCount.values.minOrNull() }
    val validPrices = bids.filter { it.second in leastBids.keys }
    val lowestPrice = validPrices.minByOrNull { it.second }?.second ?: return
    val winner = validPrices.first { it.second == lowestPrice }

    println("${winner.first} ${winner.second}")
}
