import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val d = st.nextToken().toInt()

    val dist = IntArray(d + 1) { Int.MAX_VALUE }

    val nodeList = Array(d + 1) { ArrayList<Node>() }

    for (i in 0 until n) {
        st = StringTokenizer(BR.readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        if (e > d || s > d || c > d) continue

        val sameEnd = nodeList[s].firstOrNull { it.index == e }
        if (sameEnd == null) {
            nodeList[s].add(Node(e, c))
        } else {
            if (sameEnd.cost > c) nodeList[s].add(Node(e, c))
        }
    }

    val queue: Queue<Node> = LinkedList()

    queue.add(Node(0, 0))
    while (queue.isNotEmpty()) {
        val (currentIndex, currentCost) = queue.poll()

        if (currentIndex > d) continue
        if (dist[currentIndex] < currentCost) continue
        dist[currentIndex] = currentCost
        queue.add(Node(currentIndex + 1, currentCost + 1))

        nodeList[currentIndex].forEach {
            val nextIndex = it.index
            val totalCost = it.cost + currentCost

            queue.add(Node(nextIndex, totalCost))
        }
    }

    println(dist[d])
}

data class Node(
    val index: Int,
    val cost: Int
)