fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toLong() }.sorted()

    var start = 0
    var end = n-1
    var ans = 0L

    while(start < end) {
        if(arr[start] + arr[end] <= k) {
            start++
            ans++
        }
        end--
    }

    println(ans)
}