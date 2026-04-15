import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

var n = 0
var p = 0
var k = 0
lateinit var graph: Array<MutableList<Node>>

fun main() {
    var st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    p = st.nextToken().toInt()
    k = st.nextToken().toInt()

    graph = Array(n + 1) { mutableListOf() }

    for (i in 0 until p) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        graph[u].add(Node(v, w))
        graph[v].add(Node(u, w))
    }

    var low = 0
    var high = 1_000_000
    var result = -1

    while (low <= high) {
        val mid = (low + high) / 2

        if (dijkstra(mid)) {
            result = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    println(result)
}

fun dijkstra(limit: Int): Boolean {
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Node>()

    dist[1] = 0
    pq.offer(Node(1, 0))

    while (pq.isNotEmpty()) {
        val (currentIndex, currentCost) = pq.poll()

        if (dist[currentIndex] < currentCost) continue

        for (node in graph[currentIndex]) {
            val (nextIndex, nextCost) = node

            val nextWeight = if (nextCost > limit) 1 else 0
            val sum = currentCost + nextWeight

            if (sum < dist[nextIndex]) {
                dist[nextIndex] = sum
                pq.offer(Node(nextIndex, sum))
            }
        }
    }

    return dist[n] <= k
}

data class Node(
    val index: Int,
    val cost: Int
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}