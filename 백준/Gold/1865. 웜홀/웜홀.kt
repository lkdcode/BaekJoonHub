import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val inputTc = br.readLine().toInt()

    for (a in 0 until inputTc) {

        val (inputN, inputM, inputW) = br.readLine().split(" ")
        val n = inputN.toInt()
        val m = inputM.toInt()
        val w = inputW.toInt()

        val list = LongArray(n + 1) { 0 }

        val edges = mutableListOf<Edge>()

        for (b in 0 until m) {
            val (inputS, inputE, inputT) = br.readLine().split(" ")
            val s = inputS.toInt()
            val e = inputE.toInt()
            val t = inputT.toInt()

            edges.add(Edge(s, e, t))
            edges.add(Edge(e, s, t))
        }

        for (b in 0 until w) {
            val (inputS, inputE, inputT) = br.readLine().split(" ")
            val s = inputS.toInt()
            val e = inputE.toInt()
            val t = -inputT.toInt()

            edges.add(Edge(s, e, t))
        }

        for (b in 0 until (m * 2) + w - 1) {
            for (edge in edges) {
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

        for (edge in edges) {
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
            println("YES")
        } else {
            println("NO")
        }
    }
}

data class Edge(
    val from: Int,
    val to: Int,
    val cost: Int,
)