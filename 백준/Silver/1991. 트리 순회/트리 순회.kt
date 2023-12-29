import java.io.BufferedReader
import java.io.InputStreamReader

val hashmap = HashMap<Char, Tree>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var root = 'A'
    repeat(n) {
        val input = br.readLine().split(" ")
        val cur = input[0][0]
        val left = input[1][0]
        val right = input[2][0]

        if(it == 0) root = cur

        hashmap[cur] = Tree(cur, Tree(left, null, null), Tree(right, null, null))
    }

    preorder(cur = root)
    println()
    inorder(cur = root)
    println()
    postorder(cur = root)
}

fun preorder(cur: Char) {
    if(cur == '.') return
    val v = hashmap[cur]

    print("$cur")
    preorder(v!!.left!!.cur)
    preorder(v.right!!.cur)
}

fun inorder(cur: Char) {
    if(cur == '.') return
    val v = hashmap[cur]!!

    inorder(v.left!!.cur)
    print("${v.cur}")
    inorder(v.right!!.cur)
}

fun postorder(cur: Char) {
    if(cur == '.') return
    val v = hashmap[cur]!!

    postorder(v.left!!.cur)
    postorder(v.right!!.cur)
    print("${v.cur}")
}

data class Tree(
    var cur: Char,
    var left: Tree?,
    var right: Tree?
)