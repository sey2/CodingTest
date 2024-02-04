fun main() = with(System.`in`.bufferedReader()) {
    while(true) {
        val n = readLine().toInt()

        if(n == 0) break

        val set = mutableSetOf<Int>()
        val inputs = readLine().split(",")

        var ans = 0
        for(i in 0 until inputs.size) {
            val split = inputs[i].split("-").map{ it.toInt() }
            var end = if(split.size == 1) split[0]else split[1]
            end = if(end > n) n else end

            for(j in split[0] .. end) {
                if(set.contains(j)) continue
                ans ++
                set.add(j)
            }
        }
        println(ans)
    }


}
