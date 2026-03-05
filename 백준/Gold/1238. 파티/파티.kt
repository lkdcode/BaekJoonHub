import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val start = st.nextToken().toInt()

    val nodes = ArrayList<ArrayList<Node>>()
    val reverseNodes = ArrayList<ArrayList<Node>>()
    for (i in 0..n) {
        nodes.add(ArrayList())
        reverseNodes.add(ArrayList())
    }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())

        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        nodes[from].add(Node(from, to, cost))
        reverseNodes[to].add(Node(to, from, cost))
    }

    val queue = PriorityQueue<Node>()
    val costList = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    queue.add(Node(start, start, 0))

    while (queue.isNotEmpty()) {
        val (from, to, cost) = queue.poll()

        if (costList[from][to] < cost) continue
        costList[from][to] = cost

        for (node in nodes[to]) {
            val (_, nextTo, nextCost) = node
            val sum = cost + nextCost

            if (costList[from][nextTo] > sum) {
                costList[from][nextTo] = sum
                queue.add(Node(from, nextTo, sum))
            }
        }
    }

    queue.add(Node(start, start, 0))
    val reverseCostList = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    while (queue.isNotEmpty()) {
        val (from, to, cost) = queue.poll()

        if (reverseCostList[from][to] < cost) continue
        reverseCostList[from][to] = cost

        for (node in reverseNodes[to]) {
            val (_, nextTo, nextCost) = node
            val sum = cost + nextCost

            if (reverseCostList[from][nextTo] > sum) {
                reverseCostList[from][nextTo] = sum
                queue.add(Node(from, nextTo, sum))
            }
        }
    }
    var result = Int.MIN_VALUE

    for (i in 1..n) {
        result = max(costList[start][i] + reverseCostList[start][i], result)
    }

    println(result)
}

data class Node(
    val from: Int,
    val to: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}