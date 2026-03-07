import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(br.readLine())

    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val maze = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
    val costList = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    val dx = intArrayOf(-1, +1, 0, 0)
    val dy = intArrayOf(0, 0, -1, +1)

    for (i in 1..n) {
        val e = br.readLine().map { it.digitToInt() }
        for (j in 1..m) {
            maze[j][i] = e[j - 1]
        }
    }

    val queue = ArrayDeque<Node>()

    queue.add(Node(1, 1, 0))

    while (queue.isNotEmpty()) {
        val (x, y, cost) = queue.poll()

        if (costList[x][y] > cost) {
            costList[x][y] = cost
            for (i in 0 until 4) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                if (nextX >= 0 && nextX <= m && nextY >= 0 && nextY <= n) {
                    if (maze[nextX][nextY] == 1) {
                        queue.add(Node(nextX, nextY, cost + 1))
                    }

                    if (maze[nextX][nextY] == 0) {
                        queue.add(Node(nextX, nextY, cost))
                    }
                }
            }
        }
    }

    println(costList[m][n])
}

data class Node(
    val x: Int,
    val y: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}