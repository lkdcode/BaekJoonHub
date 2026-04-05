import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val costList = Array(n + 1) { ArrayList<Node>() }

    for (i in 0 until m) {
        st = StringTokenizer(BR.readLine())

        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val c = st.nextToken().toLong()

        costList[s].add(Node(e, c))
        costList[e].add(Node(s, c))
    }

    val dist = LongArray(n + 1) { Long.MAX_VALUE }

    val pq = PriorityQueue<Node>()
    pq.add(Node(1, 0))

    while (pq.isNotEmpty()) {
        val (index, cost) = pq.poll()

        if (dist[index] < cost) continue
        dist[index] = cost

        costList[index].forEach {
            val nextIndex = it.index
            val sumCost = it.cost + cost
            if (dist[nextIndex] > sumCost) {
                pq.add(Node(nextIndex, sumCost))
            }
        }
    }

    println(dist[n])
}

data class Node(
    val index: Int,
    val cost: Long
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}