class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var map = HashMap<String, Int>()

        for(i in players.indices)
            map[players[i]] = i;

        for(i in callings.indices){
            var idx = map[callings[i]]
            map[callings[i]] = idx!!-1

            // swap
            var tmp = players[idx-1]
            players[idx-1] = players[idx]
            players[idx] = tmp

            map[tmp] = idx

        }



        return players
    }
}