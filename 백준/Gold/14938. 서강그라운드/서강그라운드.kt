import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()

    val itemCounts = IntArray(n + 1) { 0 }

    st = StringTokenizer(br.readLine())

    for (i in 1..n) {
        itemCounts[i] = st.nextToken().toInt()
    }

    val maps = ArrayList<ArrayList<Node>>()
    for (i in 0..n) {
        maps.add(ArrayList())
    }

    for (i in 0 until r) {
        st = StringTokenizer(br.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        maps[a].add(Node(b, cost))
        maps[b].add(Node(a, cost))
    }

    val queue = PriorityQueue<Node>()
    val costList = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    for (start in 1..n) {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        queue.add(Node(start, 0))

        while (queue.isNotEmpty()) {
            val (index, cost) = queue.poll()

            if (dist[index] < cost) continue
            dist[index] = cost

            for (map in maps[index]) {
                val (nextIndex, nextCost) = map
                val sum = cost + nextCost
                if (dist[nextIndex] > sum) {
                    dist[nextIndex] = sum
                    queue.add(Node(nextIndex, sum))
                }
            }
        }

        for (i in 1..n) {
            costList[start][i] = dist[i]
        }
    }
    var result = 0

    costList.map {
        result = max(it.mapIndexed { index, cost -> if (cost <= m) itemCounts[index] else 0 }.sum(), result)
    }

    println(result)
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}