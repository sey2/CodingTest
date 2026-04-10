fun main() {
    val (n, t) = readln().trim().split(" ").map { it.toInt() }
    val l = readln().trim().split(" ").map { it.toInt() }.toMutableList()
    val r = readln().trim().split(" ").map { it.toInt() }.toMutableList()
    val d = readln().trim().split(" ").map { it.toInt() }.toMutableList()

    repeat(t) {
        val lr = l.removeAt(n - 1)
        val rr = r.removeAt(n - 1)
        val dl = d.removeAt(n -     1)

        l.add(0, dl)
        r.add(0, lr)
        d.add(0, rr)
    }

    println(l.joinToString(" "))
    println(r.joinToString(" "))
    println(d.joinToString(" "))
}