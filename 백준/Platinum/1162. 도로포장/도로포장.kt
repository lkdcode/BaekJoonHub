import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val roadMaps = ArrayList<ArrayList<Node>>()

    for (i in 0..n) {
        roadMaps.add(ArrayList())
    }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val cost = st.nextToken().toLong()

        roadMaps[from].add(Node(to, cost, 0))
        roadMaps[to].add(Node(from, cost, 0))
    }

    val dist = Array(n + 1) { LongArray(k + 1) { Long.MAX_VALUE } }
    dist[1][0] = 0
    val queue = PriorityQueue<Node>()
    queue.add(Node(1, 0, 0))

    while (queue.isNotEmpty()) {
        val (from, cost, kState) = queue.poll()

        if (dist[from][kState] < cost) continue

        for (road in roadMaps[from]) {
            val (to, nextCost, _) = road
            val sum = cost + nextCost
            val nextKState = kState + 1

            if (nextKState <= k) {
                if (dist[to][nextKState] > cost) {
                    dist[to][nextKState] = cost
                    queue.add(Node(to, cost, nextKState))
                }
            }

            if (dist[to][kState] > sum) {
                dist[to][kState] = sum
                queue.add(Node(to, sum, kState))
            }
        }
    }

    println(dist[n].min())
}

data class Node(
    val index: Int,
    val cost: Long,
    val kState: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        if (cost < other.cost) return -1
        if (cost > other.cost) return 1
        return 0
    }
}