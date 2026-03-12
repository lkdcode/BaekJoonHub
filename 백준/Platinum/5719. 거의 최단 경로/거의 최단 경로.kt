import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {

    while (true) {
        var st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        if (n == 0 && m == 0) return

        st = StringTokenizer(br.readLine())
        val s = st.nextToken().toInt()
        val d = st.nextToken().toInt()

        val roadMaps = ArrayList<ArrayList<Node>>()
        val reversRoadMaps = ArrayList<ArrayList<Node>>()

        for (i in 0 until n) {
            roadMaps.add(ArrayList())
            reversRoadMaps.add(ArrayList())
        }

        for (i in 0 until m) {
            st = StringTokenizer(br.readLine())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            val p = st.nextToken().toInt()

            roadMaps[u].add(Node(v, p))
            reversRoadMaps[v].add(Node(u, p))
        }

        val isBlocked = Array(n) { BooleanArray(n) { false } }

        val dist = dijkstra(n, s, roadMaps, isBlocked)
        if (dist[d] == Int.MAX_VALUE) {
            println(-1)
            continue
        }

        createBlockList(d, dist, reversRoadMaps, isBlocked)
        val nextDist = dijkstra(n, s, roadMaps, isBlocked)

        if (nextDist[d] == Int.MAX_VALUE) {
            println(-1)
        } else {
            println(nextDist[d])
        }
    }
}

fun createBlockList(
    d: Int,
    dist: IntArray,
    reversRoadMaps: ArrayList<ArrayList<Node>>,
    isBlocked: Array<BooleanArray>
) {
    val queue = PriorityQueue<Node>()

    queue.add(Node(d, dist[d]))
    val visited = BooleanArray(isBlocked.size)

    while (queue.isNotEmpty()) {
        val (currIndex, currCost) = queue.poll()

        for (map in reversRoadMaps[currIndex]) {
            val (preIndex, preCost) = map

            val preTotalCost = currCost - dist[preIndex]

            if (preCost == preTotalCost) {
                isBlocked[preIndex][currIndex] = true
                if (!visited[preIndex]) {
                    visited[preIndex] = true
                    queue.add(Node(preIndex, dist[preIndex]))
                }
            }
        }
    }
}

fun dijkstra(
    n: Int,
    s: Int,
    roadMaps: ArrayList<ArrayList<Node>>,
    isBlocked: Array<BooleanArray>,
): IntArray {
    val queue = PriorityQueue<Node>()

    queue.add(Node(s, 0))
    val dist = IntArray(n) { Int.MAX_VALUE }

    while (queue.isNotEmpty()) {
        val (index, cost) = queue.poll()

        if (dist[index] < cost) continue
        dist[index] = cost
        for (roadMap in roadMaps[index]) {
            val (nextIndex, nextCost) = roadMap
            if (isBlocked[index][nextIndex]) continue
            val sum = nextCost + cost

            if (dist[nextIndex] > sum) {
                dist[nextIndex] = sum
                queue.add(Node(nextIndex, sum))
            }
        }
    }

    return dist
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}