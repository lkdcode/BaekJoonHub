import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val nodeList = Array(n + 1) { ArrayList<Node>() }

    for (i in 0 until m) {
        st = StringTokenizer(BR.readLine())

        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val c = st.nextToken().toLong()

        nodeList[v].add(Node(u, u, c))
    }

    st = StringTokenizer(BR.readLine())

    val startList = mutableListOf<Int>()
    val pq = PriorityQueue<Node>()
    val dist = LongArray(n + 1) { Long.MAX_VALUE }

    for (i in 0 until k) {
        val s = st.nextToken().toInt()
        startList.add(s)

        pq.add(Node(s, s, 0))
    }

    while (pq.isNotEmpty()) {
        val (start, currentIndex, currentCost) = pq.poll()
        if (dist[currentIndex] < currentCost) continue
        dist[currentIndex] = currentCost

        for (node in nodeList[currentIndex]) {
            val (_, nextIndex, nextCost) = node
            val sum = currentCost + nextCost
            if (dist[nextIndex] > sum) {
                dist[nextIndex] = sum
                pq.add(Node(start, nextIndex, sum))
            }
        }
    }

    var number = 0
    var minCost = Long.MIN_VALUE
    var cost = LongArray(n + 1) { Long.MAX_VALUE }

    for (index in 1..n) {
            val value = dist[index]
            if (cost[index] > value) {
                cost[index] = value
            }
    }

    for (i in 1..n) {
        if (cost[i] > minCost) {
            minCost = cost[i]
            number = i
        }
    }

    println(number)
    println(minCost)
}

data class Node(
    val start: Int,
    val index: Int,
    val cost: Long,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return if (this.start != other.start) {
            this.start.compareTo(other.start)
        } else {
            this.cost.compareTo(other.cost)
        }
    }
}