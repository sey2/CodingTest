fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    repeat(n) {
        val input = readLine()

        if ("lol" in input)
            println(0)
         else if ("lo" in input || "ol" in input || "ll" in input || ('a'..'z').any { "l${it}l" in input })
            println(1)
         else if ("l" in input || "o" in input)
            println(2)
        else
            println(3)
    }
}
