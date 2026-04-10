import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val BR = BufferedReader(InputStreamReader(System.`in`))
const val WALL = "*"
const val START = "#"
const val CAN_MIRRORABLE = "!"

fun main() {
    var st = StringTokenizer(BR.readLine())

    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val p = st.nextToken().toInt()

    val nodeList = Array(v + 1) { ArrayList<Node>() }

    for (i in 0 until e) {
        st = StringTokenizer(BR.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toLong()

        nodeList[a].add(Node(b, c))
        nodeList[b].add(Node(a, c))
    }

    val queue = PriorityQueue<Node>()

    val firstDist = LongArray(v + 1) { Long.MAX_VALUE }
    val secondDist = LongArray(v + 1) { Long.MAX_VALUE }

    queue.add(Node(1, 0))

    while (queue.isNotEmpty()) {
        val (currentIndex, currentCost) = queue.poll()
        if (firstDist[currentIndex] < currentCost) continue
        firstDist[currentIndex] = currentCost

        for (node in nodeList[currentIndex]) {
            val (nextIndex, nextCost) = node
            val totalCost = nextCost + currentCost

            if (firstDist[nextIndex] > totalCost) {
                firstDist[nextIndex] = totalCost
                queue.add(Node(nextIndex, totalCost))
            }
        }
    }

    queue.add(Node(p, firstDist[p]))

    while (queue.isNotEmpty()) {
        val (currentIndex, currentCost) = queue.poll()
        if (secondDist[currentIndex] < currentCost) continue
        secondDist[currentIndex] = currentCost

        for (node in nodeList[currentIndex]) {
            val (nextIndex, nextCost) = node
            val totalCost = nextCost + currentCost

            if (secondDist[nextIndex] > totalCost) {
                secondDist[nextIndex] = totalCost
                queue.add(Node(nextIndex, totalCost))
            }
        }
    }

    if (firstDist[v] == secondDist[v]) {
        println("SAVE HIM")
    } else {
        println("GOOD BYE")
    }
}

data class Node(
    val index: Int,
    val cost: Long,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}

data class Vertex(
    val index: Int,
    val cost: Int,
    val parent: Int,
) : Comparable<Vertex> {
    override fun compareTo(other: Vertex): Int = this.cost.compareTo(other.cost)
}