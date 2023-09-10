fun main(args: Array<String>){
    val repository: Repository = RoomRepository()

    val answer = repository.fetchLayDownData()
    println("${answer.first} ${answer.second}")
}

interface Repository {
    fun fetchRoomData(): Array<CharArray>
    fun fetchLayDownData(): Pair<Int, Int>
}

class RoomRepository() : Repository {
    private val inputService = InputService()
    private val findService = FindLayDownService()

    override fun fetchRoomData(): Array<CharArray> {
        return inputService.inputData()
    }

    override fun fetchLayDownData(): Pair<Int, Int> {
        return findService.findLayDown(fetchRoomData())
    }
}

class InputService() {
    fun inputData(): Array<CharArray>{
        var br = System.`in`.bufferedReader()

        val n = br.readLine().toInt()
        var arr = Array(n) {CharArray(n)}

        for(i in 0 until n) {
            val input = br.readLine()
            for(j in 0 until n){
                arr[i][j] = input[j]
            }
        }

        return arr
    }
}

class FindLayDownService() {
    fun findLayDown(room: Array<CharArray>): Pair<Int, Int>{
        val n = room.size
        var horizontal = 0
        var vertical = 0

        for (i in 0 until n) {
            var countH = 0
            var countV = 0
            for (j in 0 until n) {
                countH = if (room[i][j] == '.') countH + 1 else 0
                countV = if (room[j][i] == '.') countV + 1 else 0

                if (countH == 2) horizontal++
                if (countV == 2) vertical++
            }
        }

        return Pair(horizontal, vertical)
    }
}