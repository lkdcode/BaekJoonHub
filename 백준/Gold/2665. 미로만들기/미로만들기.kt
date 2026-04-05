import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val BR = BufferedReader(InputStreamReader(System.`in`))
val DX = intArrayOf(+1, -1, 0, 0)
val DY = intArrayOf(0, 0, +1, -1)

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()

    val map = Array(n) { IntArray(n) }
    val costList = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    for (i in 0 until n) {
        val input = BR.readLine().map { it.digitToInt() }
        for (j in 0 until n) {
            map[i][j] = input[j].toInt()
        }
    }

    val queue: Queue<Node> = LinkedList()
    queue.add(Node(0, 0, 0))

    while (queue.isNotEmpty()) {
        val (x, y, cost) = queue.poll()

        if (costList[x][y] <= cost) continue
        costList[x][y] = cost

        for (i in 0..3) {
            val nextX = x + DX[i]
            val nextY = y + DY[i]

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (map[nextX][nextY] == 1) {
                    queue.add(Node(nextX, nextY, cost))
                } else {
                    queue.add(Node(nextX, nextY, cost + 1))
                }
            }
        }
    }

    println(costList[n - 1][n - 1])
}

data class Node(
    val x: Int,
    val y: Int,
    val cost: Int
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}