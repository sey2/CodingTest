fun main() = with(System.`in`.bufferedReader()) {
    val inputs = readLine().split(" ")
    val n = inputs[0].toInt()
    val m = when(inputs[1]) {
        "Y" -> 1
        "F" -> 2
        "O" -> 3
        else -> 0
    }

    val set = mutableSetOf<String>()
    repeat(n) {
        set.add(readLine())
    }

    println(set.size/m)
}
