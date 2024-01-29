fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = hashMapOf<Int, Int>()
    val bw = System.`out`.bufferedWriter()

    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }
        when (input[0]) {
            1 -> map[input[2]] = input[1]
            2 -> bw.write("${map[input[1]]}\n")
        }
    }
    bw.close()
}