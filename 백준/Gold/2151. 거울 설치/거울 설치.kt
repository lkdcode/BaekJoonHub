import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min


val BR = BufferedReader(InputStreamReader(System.`in`))
const val WALL = "*"
const val START = "#"
const val CAN_MIRRORABLE = "!"
const val DIR_UP = 0
const val DIR_DOWN = 1
const val DIR_LEFT = 2
const val DIR_RIGHT = 3

fun main() {
    var st = StringTokenizer(BR.readLine())

    val n = st.nextToken().toInt()

    val map = Array(n) { Array(n) { "" } }
    val startList = IntArray(4)
    var startListCount = 0

    for (i in 0 until n) {
        val split = BR.readLine().split("").filter { it.isNotBlank() }

        for (j in 0 until n) {

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
    val distMirror = Array(n) { Array(n) { IntArray(4) { Int.MAX_VALUE } } }

    pq.add(Node(startX1, startY1, 0, DIR_UP))
    pq.add(Node(startX1, startY1, 0, DIR_DOWN))
    pq.add(Node(startX1, startY1, 0, DIR_LEFT))
    pq.add(Node(startX1, startY1, 0, DIR_RIGHT))

    while (pq.isNotEmpty()) {
        val (currentX, currentY, currentCost, currentDirection) = pq.poll()

        if (!(currentX >= 0 && currentX < n && currentY >= 0 && currentY < n)) continue
        if (map[currentX][currentY] == WALL) continue
        if (distMirror[currentX][currentY][currentDirection] < currentCost) continue

        distMirror[currentX][currentY][currentDirection] = currentCost

        when (currentDirection) {
            DIR_UP -> {
                val nextX = currentX - 1

                if (nextX >= 0) {
                    if (distMirror[nextX][currentY][DIR_UP] > currentCost && map[nextX][currentY] != WALL) {
                        pq.add(Node(nextX, currentY, currentCost, DIR_UP))
                    }
                }

                if (map[currentX][currentY] == CAN_MIRRORABLE) {
                    val nextLeft = currentY - 1
                    if (nextLeft >= 0 && distMirror[currentX][nextLeft][DIR_LEFT] > currentCost + 1 && map[currentX][nextLeft] != WALL) {
                        pq.add(Node(currentX, nextLeft, currentCost + 1, DIR_LEFT))
                    }

                    val nextRgiht = currentY + 1
                    if (nextRgiht < n && distMirror[currentX][nextRgiht][DIR_RIGHT] > currentCost + 1 && map[currentX][nextRgiht] != WALL) {
                        pq.add(Node(currentX, nextRgiht, currentCost + 1, DIR_RIGHT))
                    }
                }
            }

            DIR_DOWN -> {
                val nextX = currentX + 1

                if (nextX < n) {
                    if (distMirror[nextX][currentY][DIR_DOWN] > currentCost && map[nextX][currentY] != WALL) {
                        pq.add(Node(nextX, currentY, currentCost, DIR_DOWN))
                    }
                }

                if (map[currentX][currentY] == CAN_MIRRORABLE) {
                    val nextLeft = currentY - 1
                    if (nextLeft >= 0 && distMirror[currentX][nextLeft][DIR_LEFT] > currentCost + 1 && map[currentX][nextLeft] != WALL) {
                        pq.add(Node(currentX, nextLeft, currentCost + 1, DIR_LEFT))

                    }

                    val nextRgiht = currentY + 1
                    if (nextRgiht < n && distMirror[currentX][nextRgiht][DIR_RIGHT] > currentCost + 1 && map[currentX][nextRgiht] != WALL) {
                        pq.add(Node(currentX, nextRgiht, currentCost + 1, DIR_RIGHT))
                    }
                }
            }

            DIR_LEFT -> {
                val nextY = currentY - 1

                if (nextY >= 0) {
                    if (distMirror[currentX][nextY][DIR_LEFT] > currentCost && map[currentX][nextY] != WALL) {
                        pq.add(Node(currentX, nextY, currentCost, DIR_LEFT))
                    }
                }

                if (map[currentX][currentY] == CAN_MIRRORABLE) {
                    val nextUp = currentX - 1
                    if (nextUp >= 0 && distMirror[nextUp][currentY][DIR_UP] > currentCost + 1 && map[nextUp][currentY] != WALL) {
                        pq.add(Node(nextUp, currentY, currentCost + 1, DIR_UP))
                    }

                    val nextDown = currentX + 1
                    if (nextDown < n && distMirror[nextDown][currentY][DIR_DOWN] > currentCost + 1 && map[nextDown][currentY] != WALL) {
                        pq.add(Node(nextDown, currentY, currentCost + 1, DIR_DOWN))
                    }
                }
            }

            DIR_RIGHT -> {
                val nextY = currentY + 1

                if (nextY < n) {
                    if (distMirror[currentX][nextY][DIR_RIGHT] > currentCost && map[currentX][nextY] != WALL) {
                        pq.add(Node(currentX, nextY, currentCost, DIR_RIGHT))
                    }
                }

                if (map[currentX][currentY] == CAN_MIRRORABLE) {
                    val nextUp = currentX - 1
                    if (nextUp >= 0 && distMirror[nextUp][currentY][DIR_UP] > currentCost + 1 && map[nextUp][currentY] != WALL) {
                        pq.add(Node(nextUp, currentY, currentCost + 1, DIR_UP))
                    }

                    val nextDown = currentX + 1
                    if (nextDown < n && distMirror[nextDown][currentY][DIR_DOWN] > currentCost + 1 && map[nextDown][currentY] != WALL) {
                        pq.add(Node(nextDown, currentY, currentCost + 1, DIR_DOWN))
                    }
                }
            }
        }
    }

    println(
        min(
            distMirror[startX2][startY2][0],
            min(distMirror[startX2][startY2][2], min(distMirror[startX2][startY2][1], distMirror[startX2][startY2][3]))
        )
    )
}

data class Node(
    val x: Int,
    val y: Int,
    val cost: Int,
    val direction: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.cost.compareTo(other.cost)
}