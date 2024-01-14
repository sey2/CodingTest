import java.io.BufferedReader
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val viewModel = ParkingViewModel(ParkingRepository(), CarRepository(), n to m, br)

    repeat(m * 2) { i ->
        val command = br.readLine().toInt()

        // 입차
        if (command > 0) {
            // 여유가 있으면
            if (viewModel.fetchParkingSpace() > 0)
                viewModel.actionInCar(command)
            // 여유가 없으면
            else
                viewModel.waitingCar(command)
        }  // 출차
        else
            viewModel.actionExitCar(command * -1)

    }

    println(viewModel.fetchAnswer())
}

data class Parking(val num: Int, val cost: Int, var carNum: Int = -1)

interface IRepository {
    fun save(size: Int, br: BufferedReader)
}

class ParkingRepository : IRepository {
    private var _parking = mutableListOf<Parking>()
    val parking = _parking

    private var _waitingQ: Queue<Int> = LinkedList()
    val waitingQ = _waitingQ

    var _space = 0

    override fun save(size: Int, br: BufferedReader) {
        _space = size

        repeat(size) {
            _parking.add(Parking(it, br.readLine().toInt()))
        }
    }

    fun addWaitingQ(carNum: Int) {
        _waitingQ.add(carNum)
    }

    fun entrance(carNum: Int) {
        _space--
        var available = _parking.find { it.carNum == -1 }
        available?.carNum = carNum
        _parking[available!!.num] = available
    }

    fun exitCar(carNum: Int): Int {
        _space++
        val tmp = _parking.find { it.carNum == carNum }
        return tmp!!.num
    }

    fun vacate(areaNum: Int) {
        var area = parking[areaNum]
        area.carNum = -1
        _parking[areaNum] = area
    }

    fun fetchParkingCost(areaNum: Int)
        = parking[areaNum].cost

    fun fetchWaitingQSize(): Int
        = waitingQ.size

    fun pollWaitingQ(): Int
        = _waitingQ.poll()

}

class CarRepository : IRepository {
    private var _cars = mutableListOf<Int>()
    val cars = _cars

    override fun save(size: Int, br: BufferedReader) {
        repeat(size) {
            _cars.add(br.readLine().toInt())
        }
    }

    fun fetchCarCost(carNum: Int)
        = cars[carNum]
}

class ParkingViewModel(
    private val parkingRepository: ParkingRepository,
    private val carRepository: CarRepository,
    size: Pair<Int, Int>,
    br: BufferedReader
) {
    private var _revenueState: Int = 0

    init {
        parkingRepository.save(size.first, br)
        carRepository.save(size.second, br)
    }

    fun waitingCar(carNum: Int) {
        parkingRepository.addWaitingQ(carNum)
    }

    fun actionInCar(carNum: Int) {
        parkingRepository.entrance(carNum)
    }

    fun actionExitCar(carNum: Int) {
        val area = parkingRepository.exitCar(carNum)
        _revenueState += carRepository.fetchCarCost(carNum - 1) * parkingRepository.fetchParkingCost(area)
        parkingRepository.vacate(area)

        if(parkingRepository.fetchWaitingQSize() > 0)
            parkingRepository.entrance(parkingRepository.pollWaitingQ())
    }

    fun fetchParkingSpace(): Int
        = parkingRepository._space

    fun fetchAnswer(): Int
        = _revenueState

}