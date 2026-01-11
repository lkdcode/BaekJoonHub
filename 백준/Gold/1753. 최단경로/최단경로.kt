import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val inputSize = StringTokenizer(br.readLine())
    val nodeCount = inputSize.nextToken().toInt()
    val edgeCount = inputSize.nextToken().toInt()
    val startNode = br.readLine().toInt()

    val graph = ArrayList<ArrayList<Node>>()
    for (i in 0..nodeCount) {
        graph.add(ArrayList())
    }

    for (i in 0 until edgeCount) {
        val (node, nextNode, cost) = br.readLine().split(" ")

        graph[node.toInt()].add(Node(nextNode.toInt(), cost.toInt()))
    }

    val result = dijkstra(nodeCount, startNode, graph)
    
    for (i in 1..nodeCount) {
        if (result[i] == Int.MAX_VALUE) {
            println("INF")
        } else {
            println(result[i])
        }
    }
}

fun dijkstra(size: Int, start: Int, graph: ArrayList<ArrayList<Node>>): IntArray {
    val list = IntArray(size + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Node>()

    list[start] = 0
    queue.offer(Node(start, 0))

    while (queue.isNotEmpty()) {
        val (nowIndex, nowCost) = queue.poll()

        if (list[nowIndex] < nowCost) continue

        for (node in graph[nowIndex]) {
            val (nextIndex, nextCost) = node
            val sumCost = nowCost + nextCost

            if (list[nextIndex] > sumCost) {
                list[nextIndex] = sumCost
                queue.offer(Node(nextIndex, sumCost))
            }
        }
    }

    return list
}

data class Node(
    val nextIndex: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}