import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val s = st.nextToken().toInt()

    val edges = mutableListOf<Edge>()
    val costList = LongArray(n) { Long.MAX_VALUE }
    val parent = IntArray(n) { Int.MAX_VALUE }
    costList[s] = 0

    var hasNegativeCycle = false
    var negativeStart = Int.MAX_VALUE

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        edges.add(
            Edge(
                st.nextToken().toInt(),
                st.nextToken().toInt(),
                st.nextToken().toLong(),
            )
        )
    }

    bellmanFord@ for (i in 0 until n) {
        var isUpdated = false

        for (edge in edges) {
            val from = edge.from
            val to = edge.to
            val cost = edge.cost

            val nextCost = costList[from] + cost

            if (costList[from] == Long.MIN_VALUE) {
                costList[to] = Long.MIN_VALUE
                continue
            }

            if (costList[from] == Long.MAX_VALUE) {
                continue
            }

            if (costList[to] > nextCost) {
                isUpdated = true
                costList[to] = nextCost
                parent[to] = from

                if (i == n - 1) {
                    hasNegativeCycle = true
                    negativeStart = to
                    break@bellmanFord
                }
            }
        }
        if (!isUpdated) break
    }

    if (hasNegativeCycle) {
        println("CYCLE")
        var start = negativeStart

        for (i in 0 until n) {
            start = parent[start]
        }

        val result = mutableListOf<Int>()
        var cur = start
        while (true) {
            result.add(cur)
            cur = parent[cur]
            if (cur == start) break
        }

        result.reverse()
        result.add(result.first())
        println(result.size - 1)
        println(result.joinToString(" "))

    } else {
        println("PATH")
        println(costList.joinToString(" "))
    }
}

data class Edge(
    val from: Int,
    val to: Int,
    val cost: Long,
)