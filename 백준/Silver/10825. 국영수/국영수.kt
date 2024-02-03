fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val list = mutableListOf<Score>()
    repeat(n) {
        val input = readLine().split(" ")
        list.add(Score(input[0], input[1].toInt(), input[2].toInt(), input[3].toInt()))
    }
    val sortedList = list.sortedWith(compareBy({ -it.korea }, { it.english }, { -it.math }, { it.name }))
    sortedList.forEach { println(it.name) }

}

data class Score(
    val name: String,
    val korea: Int,
    val english: Int,
    val math: Int
)