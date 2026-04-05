import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()

    for (a in 0 until testCase) {
        var st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val t = st.nextToken().toInt()

        val nodeList = Array(n + 1) { ArrayList<Vertex>() }
        st = StringTokenizer(br.readLine())

        val s = st.nextToken().toInt()
        val g = st.nextToken().toInt()
        val h = st.nextToken().toInt()

        for (i in 0 until m) {
            st = StringTokenizer(br.readLine())

            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val d = st.nextToken().toInt()

            nodeList[a].add(Vertex(b, d, false))
            nodeList[b].add(Vertex(a, d, false))
        }

        val targetList = mutableListOf<Int>()
        for (i in 0 until t) {
            targetList.add(br.readLine().toInt())
        }

        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        dist[s] = 0
        val visited = BooleanArray(n + 1) { false }
        val queue: PriorityQueue<Vertex> = PriorityQueue()

        queue.add(Vertex(s, 0, false))

        while (queue.isNotEmpty()) {
            val (currentIndex, currentCost, currentVisited) = queue.poll()
            if (dist[currentIndex] < currentCost) continue

            for (node in nodeList[currentIndex]) {
                val nextIndex = node.index
                val totalCost = node.cost + currentCost
                val isGHEdge = (currentIndex == h && nextIndex == g) || (currentIndex == g && nextIndex == h)
                val isVisited = isGHEdge || currentVisited

                if (dist[nextIndex] > totalCost) {
                    dist[nextIndex] = totalCost
                    visited[nextIndex] = isVisited
                    queue.add(Vertex(nextIndex, totalCost, isVisited))
                } else if ((dist[nextIndex] == totalCost) && isVisited && !visited[nextIndex]) {
                    visited[nextIndex] = true
                    queue.add(Vertex(nextIndex, totalCost, true))
                }
            }
        }

        targetList.sort()
        val e = targetList
            .filter { visited[it] }
            .joinToString(" ")
        println(e)
    }
}

data class Vertex(
    val index: Int,
    val cost: Int,
    val visited: Boolean,
) : Comparable<Vertex> {
    override fun compareTo(other: Vertex): Int = this.cost.compareTo(other.cost)
}