import kotlin.math.min

fun main() {
    val A = readln()
    var ans = A.encoding().length

    var a = A
    repeat(A.length) {
        val last = a.last()

        a = last + a.substring(0, a.length-1)
        ans = min(ans, a.encoding().length)
    }

    print(ans)
}

fun String.encoding(): StringBuilder {
    val encoding: StringBuilder = StringBuilder()

    var tmp = this.first()
    var count = 1

    for(i in 1 .. this.length -1) {
        if (this[i] == tmp) {
            count ++
            continue
        }

        encoding.append("$tmp$count")
        tmp = this[i]
        count = 1
    }

    encoding.append("$tmp$count")

    return encoding
}