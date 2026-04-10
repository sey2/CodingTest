fun main() {
    val (n, t) = readln().split(" ").map(String::toInt)
    val topRow = readln().split(" ").map(String::toInt).toMutableList()
    val bottomRow = readln().split(" ").map(String::toInt).toMutableList()

    repeat(t) {
        val topLast = topRow.removeAt(n - 1)
        val bottomLast = bottomRow.removeAt(n - 1)

        topRow.add(0, bottomLast)
        bottomRow.add(0, topLast)
    }

    println(topRow.joinToString(" "))
    println(bottomRow.joinToString(" "))
}