import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val visited = BooleanArray(n) { false }

    st = StringTokenizer(BR.readLine())

    for (i in 0 until n) {
        visited[i] = st.nextToken() == "0"
    }

    visited[n - 1] = true

    val nodeList = Array(n + 1) { ArrayList<Node>() }
    for (i in 0 until m) {
        st = StringTokenizer(BR.readLine())

        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val c = st.nextToken().toLong()

        if ((visited[s] && visited[e]) && (s != n && e != n)) {
            nodeList[s].add(Node(e, c))
            nodeList[e].add(Node(s, c))
        }
    }

    val pq = PriorityQueue<Node>()

    val dist = LongArray(n + 1) { Long.MAX_VALUE }
    pq.add(Node(0, 0))

    while (pq.isNotEmpty()) {
        val (currentIndex, currentCost) = pq.poll()
        if (dist[currentIndex] < currentCost) continue
        dist[currentIndex] = currentCost

        for (node in nodeList[currentIndex]) {
            val (nextIndex, nextCost) = node
            val totalCost = nextCost + currentCost
            if (dist[nextIndex] > totalCost) {
                dist[nextIndex] = totalCost
                pq.add(Node(nextIndex, totalCost))
            }
        }
    }

    if (dist[n - 1] == Long.MAX_VALUE) {
        println("-1")
    } else {
        println(dist[n - 1])
    }
}

data class Node(
    val index: Int,
    val cost: Long,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost).toInt()
}