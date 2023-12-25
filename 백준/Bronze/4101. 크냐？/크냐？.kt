fun main() {
    val br = System.`in`.bufferedReader()
    while (true) {
        val input = br.readLine().split(" ").map { it.toInt() }
        if(input[0] == 0 && input[1] == 0) break
        println(if (input[0] > input[1]) "Yes" else "No")
    }
}
