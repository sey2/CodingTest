import java.util.*;

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerList = players.toMutableList()
        val playerIndexMap: MutableMap<String, Int> = players.withIndex().associate { it.value to it.index }.toMutableMap()

        callings.forEach { calling ->
            val index = playerIndexMap[calling] ?: return@forEach
            if (index > 0) {
                Collections.swap(playerList, index, index - 1)
                playerIndexMap[playerList[index - 1]] = index - 1
                playerIndexMap[playerList[index]] = index
            }
        }
        return playerList.toTypedArray()
    }
}
