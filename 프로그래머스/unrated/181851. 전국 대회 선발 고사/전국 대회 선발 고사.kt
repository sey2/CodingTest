import java.util.PriorityQueue

class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {

        var pq = PriorityQueue<Student>(Comparator { o1, o2 ->  o1.rank - o2.rank})

        for(i in rank.indices){
            if(attendance[i])
                pq.add(Student(i, rank[i]))
        }

        return (10000 * pq.poll().num) + (100 * pq.poll().num) + pq.poll().num
    }
}

data class Student(val num: Int, val rank: Int)