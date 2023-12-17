import java.io.BufferedReader
import java.io.InputStreamReader

var orders = mutableListOf<Order>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    repeat(n) {
        val input = br.readLine().split(" ")
        command(input)
    }
}

fun command(input: List<String>) {
    when (input[0]) {
        "order" -> orders.add(Order(input[1].toInt(), input[2].toInt()))
        "sort" -> orders = orders.sortedWith(compareBy({ it.time }, { it.table })).toMutableList()
        "complete" -> orders = orders.filter { it.table != input[1].toInt() }.toMutableList()
    }
    if (orders.isEmpty()) println("sleep")
    else println(orders.joinToString(" ") { it.table.toString() })
}

data class Order(val table: Int, val time: Int)
