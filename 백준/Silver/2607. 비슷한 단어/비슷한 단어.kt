import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val arr = Array(n) { "" }

    repeat(n) {
        arr[it] = br.readLine()
    }

    var ans = 0

    for (i in 1 until n) {
        if (compare(arr[0], arr[i])) ans++

    }

    println(ans)

}

fun compare(target: String, compare: String): Boolean {
    val targetHashMap = target.getCharNum()
    val compareHashMap = compare.getCharNum()

    var diff = 0

    val big = if (targetHashMap.values.sum() >= compareHashMap.values.sum()) targetHashMap else compareHashMap
    val small = if (targetHashMap.values.sum() < compareHashMap.values.sum()) targetHashMap else compareHashMap

    big.forEach { key, value ->
        if (!small.containsKey(key)) diff += value
        else diff += abs(big[key]!! - small[key]!!)
    }

    if(diff == 2 && target.length == compare.length) {
        diff = 0
        val a = target.toCharArray().sorted()
        val b = compare.toCharArray().sorted()
        for(i in 0 until a.size) {
            if(a[i] != b[i]) diff++
        }
        return diff <= 2
    }

    return diff <= 1
}

fun String.getCharNum(): HashMap<Char, Int> {
    val hashMap = hashMapOf<Char, Int>()

    this.forEach { ch ->
        hashMap[ch] = hashMap.getOrDefault(ch, 0) + 1
    }

    return hashMap
}