fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sortedDescending()

    var big = arr[0] + arr[1]
    var answer = big

    for(i in 2 until n)
        answer += arr[0] + arr[i]

    println(answer)
}