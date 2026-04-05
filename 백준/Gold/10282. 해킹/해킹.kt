import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val testCase = st.nextToken().toInt()

    for (t in 0 until testCase) {
        st = StringTokenizer(BR.readLine())

        val n = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val visited = BooleanArray(n + 1) { false }
        var count = 0
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val nodeList = Array(n + 1) { ArrayList<Node>() }

        for (i in 0 until d) {
            st = StringTokenizer(BR.readLine())

            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val s = st.nextToken().toInt()

            nodeList[b].add(Node(a, s))
        }

        val queue: Queue<Node> = LinkedList()
        queue.add(Node(c, 0))

        while (queue.isNotEmpty()) {
            val (index, cost) = queue.poll()

            if (!visited[index]) {
                visited[index] = true
                count++
            }

            if (dist[index] < cost) continue
            dist[index] = cost

            nodeList[index].forEach {
                val nextIndex = it.index
                val totalCost = it.cost + cost

                if (dist[nextIndex] > totalCost) {
                    queue.add(Node(nextIndex, totalCost))
                }
            }
        }
        var last = -1

        visited.forEachIndexed { index, value ->
            if (value) {
                last = max(dist[index], last)
            }
        }

        println("$count $last")
    }
}

data class Node(
    val index: Int,
    val cost: Int
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}