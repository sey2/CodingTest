import java.util.HashMap

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val map = HashMap<String, Friend>()
        friends.forEach { friend -> map[friend] = Friend() }

        gifts.forEach { gift ->
            val parts = gift.split(" ")
            val giver = map[parts[0]]!!
            val receiver = map[parts[1]]!!

            giver.totalGive++
            giver.giveLog[parts[1]] = giver.giveLog.getOrDefault(parts[1], 0) + 1

            receiver.totalReceive++
            receiver.receiveLog[parts[0]] = receiver.receiveLog.getOrDefault(parts[0], 0) + 1
        }

        val nextMonth = HashMap<String, Int>()
        friends.forEach { friend -> nextMonth[friend] = 0 }

        for (i in 0 until friends.size - 1) {
            val a = map[friends[i]]!!

            for (j in i + 1 until friends.size) {
                val b = map[friends[j]]!!

                val aGive = a.giveLog.getOrDefault(friends[j], 0)
                val aReceive = a.receiveLog.getOrDefault(friends[j], 0)
                val aGiftScore = a.totalGive - a.totalReceive
                val bGiftScore = b.totalGive - b.totalReceive

                when {
                    aGive > aReceive -> nextMonth[friends[i]] = nextMonth.getOrDefault(friends[i], 0) + 1
                    aGive < aReceive -> nextMonth[friends[j]] = nextMonth.getOrDefault(friends[j], 0) + 1
                    bGiftScore > aGiftScore -> nextMonth[friends[j]] = nextMonth.getOrDefault(friends[j], 0) + 1
                    bGiftScore < aGiftScore -> nextMonth[friends[i]] = nextMonth.getOrDefault(friends[i], 0) + 1
                }
            }
        }

        return nextMonth.values.maxOrNull() ?: 0
    }
}

class Friend {
    var totalGive = 0
    var totalReceive = 0
    val giveLog = HashMap<String, Int>()
    val receiveLog = HashMap<String, Int>()
}