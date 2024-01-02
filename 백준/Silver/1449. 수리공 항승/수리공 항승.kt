fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var arr = Array(n) { 0 }

    val input = br.readLine().split(" ").map { it.toInt() }
    repeat(n) {
        arr[it] = input[it]
    }

    arr = arr.sorted().toTypedArray()

    var ans = 1
    var tmp = arr[0]
    for(i in 1 until arr.size) {
        if(arr[i] - tmp >= m) {
            ans ++
            tmp = arr[i]
        }
    }

    println(ans)
}
