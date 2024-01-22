fun main() {
    val br = System.`in`.bufferedReader()

    while(true) {
        val input = br.readLine()

        if(input == "end") break

        println("<${input}> is " + if(check(input)) "acceptable." else "not acceptable.")

    }
}

fun check(input: String): Boolean {
    val vowels = arrayOf('a','e','i','o','u')
    var vowelsNum = 0
    var consonantsNum = 0
    var check = false
    var tmp = '!'


    for(i in 0 until input.length) {
        if(vowels.contains(input[i])) {
            check = true
            consonantsNum = 0
            vowelsNum++
        }
        else {
            vowelsNum = 0
            consonantsNum++
        }

        if(input[i] != 'e' && input[i] != 'o' && tmp == input[i]) return false
        if(consonantsNum >= 3 || vowelsNum >= 3) return false

        tmp = input[i]
    }

    return check
}