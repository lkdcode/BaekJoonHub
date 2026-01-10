import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var chessboard: Array<BooleanArray>
var size: Int = 0
var resultCount: Int = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    size = br.readLine().toInt()

    chessboard = Array(size) { BooleanArray(size) }

    dfs(0)

    println(resultCount)
}

fun dfs(stoneCount: Int) {
    if (stoneCount == size) {
//        println()
//        println("--------$-------------------")
//        chessboard
//            .forEach {
//                it.forEach { print(" $it") }
//                println()
//            }
//        println("---------------------------")
//        println()

        resultCount++
        return
    }

    for (i in 0 until size) {
        if (isValid(stoneCount, i)) {
            chessboard[stoneCount][i] = true

            dfs(stoneCount + 1)

            chessboard[stoneCount][i] = false
        }
    }
}

fun isValid(x: Int, y: Int): Boolean {
    var row = x - 1
    var col = y + 1

    while (row >= 0 && col < size) {
        if (chessboard[row][col]) return false
        row--
        col++
    }

    row = x + 1
    col = y - 1

    while (row < size && col >= 0) {
        if (chessboard[row][col]) return false
        row++
        col--
    }

    row = x - 1
    col = y - 1

    while (row >= 0 && col >= 0) {
        if (chessboard[row][col]) return false
        row--
        col--
    }

    row = x + 1
    col = y + 1

    while (row < size && col < size) {
        if (chessboard[row][col]) return false
        row++
        col++
    }

    for (i in 0 until size) {
        if (chessboard[x][i] || chessboard[i][y]) return false
    }

    return true
}