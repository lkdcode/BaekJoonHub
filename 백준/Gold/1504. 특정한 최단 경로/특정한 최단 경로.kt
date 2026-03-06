import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min


val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val nodes = ArrayList<ArrayList<Node>>()

    for (i in 0..n) {
        nodes.add(ArrayList())
    }

    for (i in 0 until e) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        nodes[a].add(Node(b, c))
        nodes[b].add(Node(a, c))
    }

    st = StringTokenizer(br.readLine())

    val v1 = st.nextToken().toInt()
    val v2 = st.nextToken().toInt()

    val costList = IntArray(n + 1) { Int.MAX_VALUE }

    val queue = PriorityQueue<Node>()
    queue.add(Node(1, 0))

    while (queue.isNotEmpty()) {
        val (to, cost) = queue.poll()
        if (costList[to] < cost) continue
        costList[to] = cost

        for (node in nodes[to]) {
            val (nextTo, nextCost) = node
            val sum = cost + nextCost

            if (costList[nextTo] > sum) {
                costList[nextTo] = sum
                queue.add(Node(nextTo, sum))
            }
        }
    }

    val v1CostList = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(Node(v1, 0))

    while (queue.isNotEmpty()) {
        val (to, cost) = queue.poll()
        if (v1CostList[to] < cost) continue
        v1CostList[to] = cost

        for (node in nodes[to]) {
            val (nextTo, nextCost) = node
            val sum = cost + nextCost

            if (v1CostList[nextTo] > sum) {
                v1CostList[nextTo] = sum
                queue.add(Node(nextTo, sum))
            }
        }
    }

    val v2CostList = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(Node(v2, 0))

    while (queue.isNotEmpty()) {
        val (to, cost) = queue.poll()
        if (v2CostList[to] < cost) continue
        v2CostList[to] = cost

        for (node in nodes[to]) {
            val (nextTo, nextCost) = node
            val sum = cost + nextCost

            if (v2CostList[nextTo] > sum) {
                v2CostList[nextTo] = sum
                queue.add(Node(nextTo, sum))
            }
        }
    }

    if (n <= 2 && (v1CostList[n] == Int.MAX_VALUE || v2CostList[n] == Int.MAX_VALUE)) {
        println("-1")
        return
    }

    if ((v2CostList[n] == Int.MAX_VALUE && v1CostList[n] == Int.MAX_VALUE)
        || min(v1CostList[n], v2CostList[n]) == Int.MAX_VALUE
    ) {
        println("-1")
        return
    }

    println(
        min(
            costList[v1] + v1CostList[v2] + v2CostList[n],
            costList[v2] + v2CostList[v1] + v1CostList[n]
        )
    )
}

data class Node(
    val to: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}