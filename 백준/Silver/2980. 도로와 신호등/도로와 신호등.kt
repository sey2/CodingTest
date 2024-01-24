fun main() = with(System.`in`.bufferedReader()) {
    val (N, L) = readLine().split(" ").map { it.toInt() }
    val trafficLights = mutableListOf<Triple<Int, Int, Int>>()

    repeat(N) {
        val (D, R, G) = readLine().split(" ").map { it.toInt() }
        trafficLights.add(Triple(D, R, G))
    }

    val time = calculateTimeToEnd(N, L, trafficLights)
    println(time)
}


fun calculateTimeToEnd(N: Int, L: Int, trafficLights: List<Triple<Int, Int, Int>>): Int {
    var time = 0
    var currentPosition = 0

    for ((D, R, G) in trafficLights) {
        time += D - currentPosition
        currentPosition = D

        val lightCycle = R + G
        val lightState = time % lightCycle
        if (lightState < R) {
            time += R - lightState
        }
    }

    time += L - currentPosition

    return time
}