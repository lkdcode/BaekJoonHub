import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val BR = BufferedReader(InputStreamReader(System.`in`))
const val WALL = "*"
const val START = "#"
const val CAN_MIRRORABLE = "!"

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val nodeList = Array(n + 1) { ArrayList<Node>() }

    for (i in 0 until m) {
        st = StringTokenizer(BR.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        nodeList[a].add(Node(b, c))
        nodeList[b].add(Node(a, c))
    }

    val pq = PriorityQueue<Vertex>()
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val parent = IntArray(n + 1) { Int.MAX_VALUE }

    pq.add(Vertex(1, 0, 1))

    while (pq.isNotEmpty()) {
        val (currentIndex, currentCost, currentParent) = pq.poll()
        if (dist[currentIndex] < currentCost) continue
        parent[currentIndex] = currentParent
        dist[currentIndex] = currentCost

        for (node in nodeList[currentIndex]) {
            val (nextIndex, nextCost) = node
            val totalCost = nextCost + currentCost

            if (dist[nextIndex] > totalCost) {
                dist[nextIndex] = totalCost
                pq.add(Vertex(nextIndex, totalCost, currentIndex))
            }
        }
    }

    println(n - 1)
    for (i in 2..n) {
        println("$i ${parent[i]}")
    }
}

data class Node(
    val index: Int,
    val cost: Int,
)

data class Vertex(
    val index: Int,
    val cost: Int,
    val parent: Int,
) : Comparable<Vertex> {
    override fun compareTo(other: Vertex): Int = this.cost.compareTo(other.cost)
}