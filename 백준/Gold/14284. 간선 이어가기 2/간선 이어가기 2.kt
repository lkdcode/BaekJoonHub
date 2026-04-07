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

    val pq = PriorityQueue<Node>()

    st = StringTokenizer(BR.readLine())

    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    val dist = IntArray(n + 1) { Int.MAX_VALUE }
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
                pq.add(Node(nextIndex, totalCost))
            }
        }
    }

    println(dist[end])
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}