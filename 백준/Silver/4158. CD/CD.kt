fun main() = with(System.`in`.bufferedReader()) {
    while(true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        if(n == 0 && m == 0) break

        val set = hashSetOf<Int>()

        repeat(n) {
            set.add(readLine().toInt())
        }

        var ans = 0
        repeat(m) {
            if (set.contains(readLine().toInt()))
                ans++
        }

        println(ans)
    }
}