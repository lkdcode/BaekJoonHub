import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

var count = 0
lateinit var graph: Array<IntArray>
var result = Int.MAX_VALUE
lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    count = br.readLine().toInt()
    visited = BooleanArray(count)


    graph = Array(count) { IntArray(count) }

    for (i in 0 until count) {
        val st = StringTokenizer(br.readLine())

        for (j in 0 until count) {
            graph[i][j] = st.nextToken().toInt()
        }
    }

    dfs(0, 0)
    println(result)
}

fun dfs(memberNumber: Int, depth: Int) {
    if ((count / 2) == depth) {
        calculate()
        return
    }

    for (i in memberNumber until count) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i + 1, depth + 1)
            visited[i] = false
        }
    }
}

fun calculate() {
    var startTotalPoint = 0
    var linkTotalPoint = 0

    for (i in 0 until count) {
        for (j in i + 1 until count) {
            val first = visited[i]
            val second = visited[j]

            if (first && second) {
                startTotalPoint += graph[i][j] + graph[j][i]
            }

            if ((!first) && (!second)) {
                linkTotalPoint += graph[i][j] + graph[j][i]
            }
        }
    }

    result = min(result, abs(startTotalPoint - linkTotalPoint))
}