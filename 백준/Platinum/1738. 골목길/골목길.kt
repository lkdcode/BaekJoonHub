import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (inputN, inputM) = br.readLine().split(" ")
    val n = inputN.toInt()
    val m = inputM.toInt()

    val edges = mutableListOf<Edge>()

    val list = LongArray(n + 1) { Long.MIN_VALUE }
    list[1] = 0

    val dist = IntArray(n + 1)

    for (i in 0 until m) {
        val (inputU, inputV, inputW) = br.readLine().split(" ")
        val u = inputU.toInt()
        val v = inputV.toInt()
        val w = inputW.toLong()

        edges.add(Edge(u, v, w))
    }

    for (i in 0 until n * 2) {
        for (edge in edges) {
            val from = list[edge.from]
            val to = edge.to
            val cost = edge.cost
            val nextCost = from + cost

            if (from == Long.MIN_VALUE) {
                continue
            }

            if (from == Long.MAX_VALUE) {
                list[to] = Long.MAX_VALUE
                continue
            }

            if (list[to] < nextCost) {
                list[to] = nextCost
                dist[to] = edge.from
                if (i >= n - 1) {
                    list[to] = Long.MAX_VALUE
                }
            }
        }
    }

    if (list[n] == Long.MAX_VALUE || list[n] == Long.MIN_VALUE) {
        println("-1")
    } else {
        val result = mutableListOf<Int>()
        result.add(n)
        var i = n
        while (i > 1) {
            val node = dist[i]
            result.add(node)
            i = node
        }

        println(result.reversed().joinToString(" "))
    }
}

data class Edge(
    val from: Int,
    val to: Int,
    val cost: Long,
)