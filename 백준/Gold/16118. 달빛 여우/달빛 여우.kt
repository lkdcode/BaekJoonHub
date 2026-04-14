import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min


val BR = BufferedReader(InputStreamReader(System.`in`))
const val RUN = 0
const val REST = 1
const val FOX = 2

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val nodeList = Array(n + 1) { ArrayList<Node>() }

    for (i in 0 until m) {
        st = StringTokenizer(BR.readLine())

        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val c = st.nextToken().toLong() * 2

        nodeList[u].add(Node(v, v, c))
        nodeList[v].add(Node(u, u, c))
    }

    val pq = PriorityQueue<Node>()
    val dist = Array(3) { LongArray(n + 1) { Long.MAX_VALUE } }

    dist[RUN][1] = 0L
    dist[FOX][1] = 0L

    pq.add(Node(RUN, 1, 0))
    pq.add(Node(FOX, 1, 0))

    while (pq.isNotEmpty()) {
        val (status, currentIndex, currentCost) = pq.poll()
        if (dist[status][currentIndex] < currentCost) continue
        dist[status][currentIndex] = currentCost

        if (status == RUN) {
            for (node in nodeList[currentIndex]) {
                val (_, nextIndex, nextCost) = node
                val sum = currentCost + (nextCost / 2)
                if (dist[REST][nextIndex] > sum) {
                    dist[REST][nextIndex] = sum
                    pq.add(Node(REST, nextIndex, sum))
                }
            }
        }
        if (status == REST) {
            for (node in nodeList[currentIndex]) {
                val (_, nextIndex, nextCost) = node
                val sum = currentCost + (nextCost * 2)
                if (dist[RUN][nextIndex] > sum) {
                    dist[RUN][nextIndex] = sum
                    pq.add(Node(RUN, nextIndex, sum))
                }
            }
        }
        if (status == FOX) {
            for (node in nodeList[currentIndex]) {
                val (_, nextIndex, nextCost) = node
                val sum = currentCost + nextCost
                if (dist[FOX][nextIndex] > sum) {
                    dist[FOX][nextIndex] = sum
                    pq.add(Node(FOX, nextIndex, sum))
                }
            }
        }
    }

    for (i in 2..n) {
        dist[RUN][i] = min(dist[RUN][i], dist[REST][i])
    }

    var count = 0
    for (i in 2..n) {
        if (dist[RUN][i] > dist[FOX][i]) count++
    }

    println(count)
}

data class Node(
    val status: Int,
    val index: Int,
    val cost: Long,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}
