
class Solution {
    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        var boardX = 0
        var boardY = 0
        for((i, v) in keyinput.withIndex()){
            when(v){
                "left" -> {
                    if (boardX <= -(board[0] / 2))
                        continue
                    boardX -= 1
                }
                "right" -> {
                    if (boardX >= board[0] / 2)
                        continue
                    boardX += 1
                }
                "up" -> {
                    if (boardY >= board[1] / 2)
                        continue
                    boardY += 1
                }

                "down" ->{
                    if (boardY <= -(board[1] / 2)) {
                        continue
                    }
                    boardY -= 1
                }
            }
        }
        return intArrayOf(boardX, boardY)
    }
}