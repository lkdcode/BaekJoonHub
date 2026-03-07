import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()

    val busList = ArrayList<ArrayList<Node>>()

    for (i in 0..n) {
        busList.add(ArrayList())
    }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        busList[from].add(Node(to, cost))
    }

    st = StringTokenizer(br.readLine())

    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    val costList = IntArray(n + 1) { Int.MAX_VALUE }
    val pathList = IntArray(n + 1) { Int.MAX_VALUE }

    val queue = PriorityQueue<Node>()

    queue.add(Node(start, 0))

    while (queue.isNotEmpty()) {
        val (index, cost) = queue.poll()

        if (costList[index] < cost) continue

        costList[index] = cost

        for (bus in busList[index]) {
            val (nextIndex, nextCost) = bus
            val sum = cost + nextCost

            if (costList[nextIndex] > sum) {
                costList[nextIndex] = sum
                pathList[nextIndex] = index
                queue.add(Node(nextIndex, sum))
            }
        }
    }

    val result = mutableListOf<Int>()
    var index = end

    while (index != start) {
        result.add(index)
        index = pathList[index]
    }

    result.add(start)

    println(costList[end])
    println(result.size)
    println(result.reversed().joinToString(" "))
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}