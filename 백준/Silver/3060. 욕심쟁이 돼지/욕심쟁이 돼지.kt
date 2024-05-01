fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        var ans = 1
        val n = readLine().toInt()
        var arr = readLine().split(" ").map { it.toLong() }.toMutableList()

        while (true) {
            var totalFeed = arr.sum() 
            if (totalFeed > n) break 

            val temp = MutableList(6) { 0L }
            
            for (i in 0..5) {
                val left = if (i == 0) 5 else i - 1
                val right = if (i == 5) 0 else i + 1
                val across = (i + 3) % 6
                temp[i] = arr[i] + (arr[left] + arr[right] + arr[across])
            }

            arr = temp
            ans++
        }
        println(ans)
    }
}
