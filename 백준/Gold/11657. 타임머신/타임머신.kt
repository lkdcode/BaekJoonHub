
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (inputN, inputM) = br.readLine().split(" ")
    val n = inputN.toInt()
    val m = inputM.toInt()

    val edgeList = mutableListOf<Edge>()
    val list = LongArray(n + 1) { Long.MAX_VALUE }
    list[1] = 0

    for (i in 0 until m) {
        val (inputFrom, inputTo, inputCost) = br.readLine().split(" ")
        val from = inputFrom.toInt()
        val to = inputTo.toInt()
        val cost = inputCost.toInt()
        edgeList.add(Edge(from, to, cost))
    }

    for (i in 0 until m) {
        for (edge in edgeList) {
            val from = edge.from
            val to = edge.to
            val cost = edge.cost
            val nextCost = list[from] + cost

            if (list[from] != Long.MAX_VALUE && list[to] > nextCost) {
                list[to] = nextCost
            }
        }
    }

    var hasNativeCycle = false

    for (edge in edgeList) {
        val from = edge.from
        val to = edge.to
        val cost = edge.cost
        val nextCost = list[from] + cost

        if (list[from] != Long.MAX_VALUE && list[to] > nextCost) {
            hasNativeCycle = true
            break
        }
    }

    if (hasNativeCycle) {
        println(-1)
    } else {
        for (i in 2..n) {
            val cost = list[i]
            if (cost == Long.MAX_VALUE) {
                println(-1)
            } else {
                println(cost)
            }
        }
    }
}

data class Edge(
    val from: Int,
    val to: Int,
    val cost: Int,
)