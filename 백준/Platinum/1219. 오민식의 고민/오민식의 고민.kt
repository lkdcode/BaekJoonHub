
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (inputN, inputStart, inputEnd, inputM) = br.readLine().split(" ")
    val n = inputN.toInt()
    val start = inputStart.toInt()
    val end = inputEnd.toInt()
    val m = inputM.toInt()

    val list = LongArray(n) { Long.MIN_VALUE }
    list[start] = 0

    val edges = mutableListOf<Edge>()

    for (i in 0 until m) {
        val (inputFrom, inputTo, inputCost) = br.readLine().split(" ")
        val from = inputFrom.toLong()
        val to = inputTo.toLong()
        val cost = inputCost.toLong()
        edges.add(Edge(from, to, cost))
    }

    val inputProfit = br.readLine().split(" ")
    val profitList = LongArray(n)

    for ((index, profit) in inputProfit.withIndex()) {
        profitList[index] = profit.toLong()
    }

    list[start] = profitList[start]

    for (i in 0 until n * 2) {
        for (edge in edges) {
            val from = edge.from.toInt()
            val to = edge.to.toInt()
            val cost = edge.cost
            val profit = profitList[to]

            val amount = list[from] - cost + profit

            if (list[from] == Long.MIN_VALUE) continue

            if (list[from] == Long.MAX_VALUE) {
                list[to] = Long.MAX_VALUE
                continue
            }

            if (list[to] < amount) {
                list[to] = amount

                if (i >= n - 1) {
                    list[to] = Long.MAX_VALUE
                }
            }
        }
    }

    val result = list[end]
    if (result == Long.MAX_VALUE) {
        println("Gee")
    } else if (result == Long.MIN_VALUE) {
        println("gg")
    } else {
        println(result)
    }
}

data class Edge(
    val from: Long,
    val to: Long,
    val cost: Long,
)