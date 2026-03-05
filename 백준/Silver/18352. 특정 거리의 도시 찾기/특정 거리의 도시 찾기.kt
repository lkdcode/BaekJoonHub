import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val nodes = ArrayList<ArrayList<Node>>()
    for (i in 0..n) {
        nodes.add(ArrayList())
    }
    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()

        nodes[from].add(Node(to, 1))
    }

    val queue = PriorityQueue<Node>()
    val costList = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(Node(x, 0))

    while (queue.isNotEmpty()) {
        val (index, cost) = queue.poll()
        if (costList[index] < cost) continue
        costList[index] = cost

        for (node in nodes[index]) {
            val (nextIndex, nextCost) = node
            val sum = cost + nextCost
            if (costList[nextIndex] > sum) {
                costList[nextIndex] = sum
                queue.add(Node(nextIndex, sum))
            }
        }
    }

    val result = mutableListOf<Int>()

    for (i in 1..n) {
        if (costList[i] == k) {
            result.add(i)
        }
    }

    if (result.isEmpty()) {
        println("-1")
        return
    }

    result.sort()
    result.forEach { println(it) }
}

data class Node(
    val to: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}