import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    while (true) {
        var st = StringTokenizer(br.readLine())
        val w = st.nextToken().toInt()
        val h = st.nextToken().toInt()

        if (w == 0 && h == 0) break

        val isTombstone = Array(w) { BooleanArray(h) { false } }

        st = StringTokenizer(br.readLine())
        val g = st.nextToken().toInt()

        for (i in 0 until g) {
            st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            isTombstone[x][y] = true
        }


        st = StringTokenizer(br.readLine())
        val e = st.nextToken().toInt()

        val isPortal = Array(w) { BooleanArray(h) { false } }
        val portalList = HashMap<Node, Edge>()

        for (i in 0 until e) {
            st = StringTokenizer(br.readLine())
            val x1 = st.nextToken().toInt()
            val y1 = st.nextToken().toInt()

            val x2 = st.nextToken().toInt()
            val y2 = st.nextToken().toInt()

            val t = st.nextToken().toInt()

            isPortal[x1][y1] = true
            val from = Node(x1, y1)
            portalList.put(from, Edge(from, Node(x2, y2), t))
        }

        val edges = ArrayList<Edge>()

        for (x in 0 until w) {
            for (y in 0 until h) {
                if (isTombstone[x][y] || (x == w - 1 && y == h - 1)) continue
                val from = Node(x, y)

                val right = x + 1
                val left = x - 1
                val up = y + 1
                val down = y - 1

                if (isPortal[x][y]) {
                    edges.add(portalList.get(from)!!)
                    continue
                }

                if (right < w && !isTombstone[right][y]) {
                    val to = Node(right, y)
                    edges.add(Edge(from, to, cost = 1))
                }

                if (left >= 0 && !isTombstone[left][y]) {
                    val to = Node(left, y)
                    edges.add(Edge(from, to, cost = 1))
                }

                if (up < h && !isTombstone[x][up]) {
                    val to = Node(x, up)
                    edges.add(Edge(from, to, cost = 1))
                }

                if (down >= 0 && !isTombstone[x][down]) {
                    val to = Node(x, down)
                    edges.add(Edge(from, to, cost = 1))
                }
            }
        }

        bellmanFord(w, h, edges)
    }
}

fun bellmanFord(
    w: Int,
    h: Int,
    edges: ArrayList<Edge>
) {
    val dist = Array(w) { IntArray(h) { Int.MAX_VALUE } }
    dist[0][0] = 0

    for (i in 0 until (w * h) * 2) {
        for (edge in edges) {
            val from = edge.from
            val to = edge.to
            val cost = edge.cost

            val fromDist = dist[from.x][from.y]
            val toDist = dist[to.x][to.y]

            val nextCost = fromDist + cost

            if (fromDist == Int.MAX_VALUE) continue
            if (fromDist == Int.MIN_VALUE) continue

            if (toDist > nextCost) {
                dist[to.x][to.y] = nextCost
                if (i > (w * h) - 1) {
                    println("Never")
                    return
                }
            }
        }
    }

    if (dist[w - 1][h - 1] == Int.MAX_VALUE) {
        println("Impossible")
    } else {
        println(dist[w - 1][h - 1])
    }
}

data class Edge(
    val from: Node,
    val to: Node,
    val cost: Int,
)

data class Node(
    val x: Int,
    val y: Int,
)