import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val nodeList = Array(n + 1) { ArrayList<Node>() }

    for (abc in 0 until m) {
        st = StringTokenizer(BR.readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        nodeList[s].add(Node(e, c))
        nodeList[e].add(Node(s, c))
    }

    for (start in 1..n) {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val firstNode = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Node>()
        pq.add(Node(start, 0))

        while (pq.isNotEmpty()) {
            val (currentIndex, currentCost) = pq.poll()
            if (dist[currentIndex] < currentCost) continue
            dist[currentIndex] = currentCost

            for (node in nodeList[currentIndex]) {
                val (nextIndex, nextCost) = node
                val totalCost = currentCost + nextCost
                if (dist[nextIndex] > totalCost) {
                    dist[nextIndex] = totalCost

                    if (start == currentIndex) {
                        firstNode[nextIndex] = nextIndex
                    } else {
                        firstNode[nextIndex] = firstNode[currentIndex]
                    }

                    pq.add(Node(nextIndex, totalCost))
                }
            }
        }

        println(
            (1..n).joinToString(" ") {
                if (it == start) "-" else firstNode[it].toString()
            }
        )
    }
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}
