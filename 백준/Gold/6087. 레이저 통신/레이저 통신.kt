import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val BR = BufferedReader(InputStreamReader(System.`in`))
const val WALL = "*"
const val START = "C"

fun main() {
    var st = StringTokenizer(BR.readLine())

    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    val map = Array(h) { Array(w) { "" } }
    val startList = IntArray(4)
    var startListCount = 0

    for (i in 0 until h) {
        val split = BR.readLine().split("").filter { it.isNotBlank() }

        for (j in 0 until w) {

            if (split[j] == START) {
                startList[startListCount++] = i
                startList[startListCount++] = j
            }
            map[i][j] = split[j]
        }
    }

    val startX1 = startList[0]
    val startY1 = startList[1]
    val startX2 = startList[2]
    val startY2 = startList[3]

    val pq = PriorityQueue<Node>()
    val dist = Array(h) { IntArray(w) { Int.MAX_VALUE } }

    Direction.entries.forEach {
        pq.add(Node(startX1, startY1, 0, it))
    }

    while (pq.isNotEmpty()) {
        val (currentX, currentY, currentCost, currentDirection) = pq.poll()

        if (!(currentX >= 0 && currentX < h && currentY >= 0 && currentY < w)) continue
        if (map[currentX][currentY] == WALL) continue
        if (dist[currentX][currentY] < currentCost) continue

        dist[currentX][currentY] = currentCost

        when (currentDirection) {
            Direction.UP -> {
                val nextX = currentX + 1

                if (nextX < h) {
                    if (dist[nextX][currentY] > currentCost && map[nextX][currentY] != WALL) {
                        pq.add(Node(nextX, currentY, currentCost, Direction.UP))
                    }
                }

                if (currentY - 1 >= 0) {
                    if (dist[currentX][currentY - 1] > currentCost + 1 && map[currentX][currentY - 1] != WALL) {
                        pq.add(Node(currentX, currentY - 1, currentCost + 1, Direction.LEFT))
                    }
                }
                if (currentY + 1 < w) {
                    if (dist[currentX][currentY + 1] > currentCost + 1 && map[currentX][currentY + 1] != WALL) {
                        pq.add(Node(currentX, currentY + 1, currentCost + 1, Direction.RIGHT))
                    }
                }
            }

            Direction.DOWN -> {
                val nextX = currentX - 1

                if (nextX >= 0) {
                    if (dist[nextX][currentY] > currentCost && map[nextX][currentY] != WALL) {
                        pq.add(Node(nextX, currentY, currentCost, Direction.DOWN))
                    }
                }

                if (currentY - 1 >= 0) {
                    if (dist[currentX][currentY - 1] > currentCost + 1 && map[currentX][currentY - 1] != WALL) {
                        pq.add(Node(currentX, currentY - 1, currentCost + 1, Direction.LEFT))
                    }
                }
                if (currentY + 1 < w) {
                    if (dist[currentX][currentY + 1] > currentCost + 1 && map[currentX][currentY + 1] != WALL) {
                        pq.add(Node(currentX, currentY + 1, currentCost + 1, Direction.RIGHT))
                    }
                }
            }

            Direction.LEFT -> {
                val nextY = currentY - 1

                if (nextY >= 0) {
                    if (dist[currentX][nextY] > currentCost && map[currentX][nextY] != WALL) {
                        pq.add(Node(currentX, nextY, currentCost, Direction.LEFT))
                    }
                }

                if (currentX - 1 >= 0) {
                    if (dist[currentX - 1][currentY] > currentCost + 1 && map[currentX - 1][currentY] != WALL) {
                        pq.add(Node(currentX - 1, currentY, currentCost + 1, Direction.DOWN))
                    }
                }

                if (currentX + 1 < h) {
                    if (dist[currentX + 1][currentY] > currentCost + 1 && map[currentX + 1][currentY] != WALL) {
                        pq.add(Node(currentX + 1, currentY, currentCost + 1, Direction.UP))
                    }
                }
            }

            Direction.RIGHT -> {
                val nextY = currentY + 1

                if (nextY < w) {
                    if (dist[currentX][nextY] > currentCost && map[currentX][nextY] != WALL) {
                        pq.add(Node(currentX, nextY, currentCost, Direction.RIGHT))
                    }
                }
                if (currentX - 1 >= 0) {
                    if (dist[currentX - 1][currentY] > currentCost + 1 && map[currentX - 1][currentY] != WALL) {
                        pq.add(Node(currentX - 1, currentY, currentCost + 1, Direction.DOWN))
                    }
                }

                if (currentX + 1 < h) {
                    if (dist[currentX + 1][currentY] > currentCost + 1 && map[currentX + 1][currentY] != WALL) {
                        pq.add(Node(currentX + 1, currentY, currentCost + 1, Direction.UP))
                    }
                }
            }
        }
    }

    println(dist[startX2][startY2])
}

data class Node(
    val x: Int,
    val y: Int,
    val cost: Int,
    val direction: Direction,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}