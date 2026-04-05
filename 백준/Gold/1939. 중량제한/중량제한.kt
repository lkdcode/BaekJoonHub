import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val dist = LongArray(n + 1) { Long.MIN_VALUE }
    val costList = Array(n + 1) { ArrayList<Node>() }

    for (i in 0 until m) {
        st = StringTokenizer(BR.readLine())

        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val c = st.nextToken().toLong()

        costList[s].add(Node(e, c))
        costList[e].add(Node(s, c))
    }

    st = StringTokenizer(BR.readLine())

    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    val pq = PriorityQueue<Node>()
    pq.add(Node(start, Long.MAX_VALUE))

    while (pq.isNotEmpty()) {
        val (index, cost) = pq.poll()

        if (dist[index] >= cost) continue
        dist[index] = cost

        costList[index].forEach {
            val nextIndex = it.index
            val nextCost = it.cost

            val cal = min(nextCost, cost)
            if (dist[nextIndex] < cal) {
                pq.add(Node(nextIndex, cal))
            }
        }
    }

    println(dist[end])
}

data class Node(
    val index: Int,
    val cost: Long
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = other.cost.compareTo(this.cost)
}