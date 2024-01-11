fun main(args: Array<String>) {
    println( readLine()!!.map { char ->
        when {
            char.isUpperCase() -> char.toLowerCase()
            char.isLowerCase() -> char.toUpperCase()
            else -> char
        }
    }.joinToString(""))
}

