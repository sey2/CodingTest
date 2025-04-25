import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0

        val game = Game(
            server = LinkedList(),
            players = players,
            capacityPerServer = m,
            serverLifetime = k
        )

        GameServerScheduler(game).executeSchedule(
            duration = SchedulerDuration.DAY,
            serverAddCallBack = { answer++ }
        )

        return answer
    }
}

private interface GameScheduler {
    fun executeSchedule(
        duration: SchedulerDuration,
        serverAddCallBack: (() -> Unit)?
    )
}

enum class SchedulerDuration(val repeatCount: Int) {
    DAY(repeatCount = 24);
}

private class GameServerScheduler(private val game: Game) : GameScheduler {
    override fun executeSchedule(
        duration: SchedulerDuration,
        serverAddCallBack: (() -> Unit)?,
    ) {
        repeat(duration.repeatCount) { currentTime ->
            game.refreshServer(currentTime)
            val needCapability: Int = (game.players[currentTime] / game.capacityPerServer) - game.server.size

            repeat(needCapability) {
                game.server.add(Server(currentTime + game.serverLifetime - 1))
                serverAddCallBack?.invoke()
            }
        }
    }
}

private class Game(
    val server: Queue<Server>,
    val players: IntArray,
    val capacityPerServer: Int,
    val serverLifetime: Int
) {
    fun refreshServer(currentTime: Int) =
        server.removeAll { server -> server.expiredAt < currentTime }
}

private data class Server(val expiredAt: Int)