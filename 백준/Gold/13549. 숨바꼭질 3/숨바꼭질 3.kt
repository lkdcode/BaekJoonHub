import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    if (start == end) {
        println(0)
        return
    }

    if (end == 0) {
        println(start)
        return
    }

    val result = dijkstra(start, 100_000)

    println(result[end])
}

fun dijkstra(start: Int, size: Int): IntArray {
    val costList = IntArray(size + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Node>()

    costList[0] = start
    costList[start] = 0
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val (nowIndex, nowCost) = pq.poll()
        if (costList[nowIndex] < nowCost) continue

        costList[nowIndex] = nowCost

        if ((nowIndex + 1) < 100_001) {
            if (costList[nowIndex + 1] > nowCost + 1) {
                pq.offer(Node(nowIndex + 1, nowCost + 1))
            }
        }
        if ((nowIndex - 1) > 0) {
            if (costList[nowIndex - 1] > nowCost + 1) {
                pq.offer(Node(nowIndex - 1, nowCost + 1))
            }
        }
        if ((nowIndex * 2) < 100_001) {
            if (costList[nowIndex * 2] > nowCost) {
                pq.offer(Node(nowIndex * 2, nowCost))
            }
        }
    }
    return costList
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}