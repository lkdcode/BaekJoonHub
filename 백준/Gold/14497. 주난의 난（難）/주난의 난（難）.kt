import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val BR = BufferedReader(InputStreamReader(System.`in`))
val DX = intArrayOf(+1, -1, 0, 0)
val DY = intArrayOf(0, 0, +1, -1)

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { Array(m) { "" } }

    st = StringTokenizer(BR.readLine())

    val startX = st.nextToken().toInt()
    val startY = st.nextToken().toInt()

    val endX = st.nextToken().toInt()
    val endY = st.nextToken().toInt()

    for (i in 0 until n) {
        val split = BR.readLine().split("").filter { it.isNotBlank() }

        for (j in 0 until m) {
            map[i][j] = split[j]
        }
    }

    val pq = PriorityQueue<Node>()
    val dist = Array(n) { IntArray(m) { Int.MAX_VALUE } }

    pq.add(Node(startX - 1, startY - 1, 0))

    while (pq.isNotEmpty()) {
        val (x, y, cost) = pq.poll()
        if (dist[x][y] < cost) continue
        dist[x][y] = cost

        for (i in 0..3) {
            val nextX = DX[i] + x
            val nextY = DY[i] + y

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (map[nextX][nextY] == "1") {
                    if (dist[nextX][nextY] > cost + 1) {
                        dist[nextX][nextY] = cost + 1
                        pq.add(Node(nextX, nextY, cost + 1))
                    }
                } else {
                    if (dist[nextX][nextY] > cost) {
                        dist[nextX][nextY] = cost
                        pq.add(Node(nextX, nextY, cost))
                    }
                }
            }
        }
    }

    println(dist[endX - 1][endY - 1] + 1)
}

data class Node(
    val x: Int,
    val y: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}