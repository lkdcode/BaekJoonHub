import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val cityList = ArrayList<ArrayList<Node>>()

    for (i in 0..n) {
        cityList.add(ArrayList())
    }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        cityList[from].add(Node(to, cost))
    }

    val queue = PriorityQueue<Node>()

    val dist = Array(n + 1) { PriorityQueue<Int>(reverseOrder<Int>()) }
    dist[1].add(0)
    queue.add(Node(1, 0))

    while (queue.isNotEmpty()) {
        val (index, cost) = queue.poll()

        for (city in cityList[index]) {
            val (nextIndex, nextCost) = city
            val sum = nextCost + cost

            if (dist[nextIndex].size < k) {
                dist[nextIndex].add(sum)
                queue.add(Node(nextIndex, sum))
            } else if (dist[nextIndex].peek() > sum) {
                dist[nextIndex].poll()
                dist[nextIndex].add(sum)
                queue.add(Node(nextIndex, sum))
            }
        }
    }

    val result = StringBuilder()

    for (i in 1..n) {
        if (dist[i].size < k) {
            result.append("-1\n")
            continue
        }

        result.append("${dist[i].peek()}\n")
    }
    
    print(result)
}

data class Node(
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}