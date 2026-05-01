var ans = 0
var n = 0

fun main() {
    n = readln().toInt()
    dfs(0)
    println(ans)
}

fun dfs(depth: Int) {
    if (depth == n) {
        ans++
        return
    }

    for (num in 1..4) {
        if (depth + num <= n) {
            dfs(depth + num)
        }
    }
}