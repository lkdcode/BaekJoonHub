import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val BR = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var st = StringTokenizer(BR.readLine())

    val testCase = st.nextToken().toInt()

    for (a in 0 until testCase) {
        st = StringTokenizer(BR.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val nodeList = Array(n + 1) { ArrayList<Node>() }

        for (i in 0 until m) {
            st = StringTokenizer(BR.readLine())

            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val c = st.nextToken().toInt()

            nodeList[a].add(Node(a, b, c))
            nodeList[b].add(Node(b, a, c))
        }

        st = StringTokenizer(BR.readLine())
        val k = st.nextToken().toInt()

        st = StringTokenizer(BR.readLine())

        val startList = mutableListOf<Int>()
        val pq = PriorityQueue<Node>()
        val dist = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

        for (i in 0 until k) {
            val s = st.nextToken().toInt()
            startList.add(s)

            pq.add(Node(s, s, 0))
        }

        while (pq.isNotEmpty()) {
            val (start, currentIndex, currentCost) = pq.poll()
            if (dist[start][currentIndex] < currentCost) continue
            dist[start][currentIndex] = currentCost

            for (node in nodeList[currentIndex]) {
                val (_, nextIndex, nextCost) = node
                val sum = currentCost + nextCost
                if (dist[start][nextIndex] > sum) {
                    dist[start][nextIndex] = sum
                    pq.add(Node(start, nextIndex, sum))
                }
            }
        }

        var total = Int.MAX_VALUE
        var roomNumber = Int.MAX_VALUE

        for (i in 1..n) {
            var valid = true
            var sum = 0
            for (j in 0 until startList.size) {
                val friend = startList[j]
                val cost = dist[friend][i]
                if (cost == Int.MAX_VALUE) {
                    valid = false
                    break
                }

                sum += cost
            }
            if (valid) {
                if (total > sum) {
                    total = sum
                    roomNumber = i
                }
            }
        }

        println(roomNumber)
    }
}

data class Node(
    val start: Int,
    val index: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return if (this.start != other.start) {
            this.start.compareTo(other.start)
        } else {
            this.cost.compareTo(other.cost)
        }
    }
}