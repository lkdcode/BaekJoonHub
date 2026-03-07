import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    var count = 1
    
    while (true) {
        var st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        if (n == 0) return

        val cave = Array(n) { IntArray(n) }
        val costList = Array(n) { IntArray(n) { Int.MAX_VALUE } }

        for (i in 0 until n) {
            st = StringTokenizer(br.readLine())
            for (j in 0 until n) {
                cave[i][j] = st.nextToken().toInt()
            }
        }

        val queue = ArrayDeque<Node>()

        queue.add(Node(0, 0, cave[0][0]))

        while (queue.isNotEmpty()) {
            val (x, y, cost) = queue.poll()

            if (costList[x][y] > cost) {
                costList[x][y] = cost
            }

            for (i in 0 until 4) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    val sum = cave[nextX][nextY] + cost

                    if (costList[nextX][nextY] > sum) {
                        costList[nextX][nextY] = sum
                        queue.add(Node(nextX, nextY, sum))
                    }
                }
            }
        }

        println("Problem ${count}: ${costList[n - 1][n - 1]}")
        count++
    }
}

data class Node(
    val x: Int,
    val y: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost - other.cost
}