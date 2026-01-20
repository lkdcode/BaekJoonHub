import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val graph = ArrayList<ArrayList<MyNode>>()
    val br = BufferedReader(InputStreamReader(System.`in`))

    val size = br.readLine().toInt()
    val edgeCount = br.readLine().toInt()

    for (i in 0..size) {
        graph.add(ArrayList())
    }

    for (i in 0 until edgeCount) {
        val st = StringTokenizer(br.readLine())

        val start = st.nextToken().toInt()
        val next = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        graph[start].add(MyNode(next, cost))
    }

    val st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    val costList = dijkstra(size, start, graph)
    println(costList[end])
}

fun dijkstra(size: Int, start: Int, graph: List<List<MyNode>>): IntArray {
    val costList = IntArray(size + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<MyNode>()

    costList[start] = 0
    pq.offer(MyNode(start, 0))

    while (pq.isNotEmpty()) {
        val (nowIndex, nowCost) = pq.poll()

        if (costList[nowIndex] < nowCost) continue

        graph[nowIndex].forEach { (nextIndex, nextCost) ->
            val sumCost = nowCost + nextCost

            if (costList[nextIndex] > sumCost) {
                costList[nextIndex] = sumCost
                pq.offer(MyNode(nextIndex, sumCost))
            }
        }
    }
    return costList
}

data class MyNode(
    val index: Int,
    val cost: Int
) : Comparable<MyNode> {
    override fun compareTo(other: MyNode): Int = this.cost - other.cost
}