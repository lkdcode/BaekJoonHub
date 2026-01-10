import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

data class Point(val x: Int, val y: Int)

val pointList = mutableListOf<Point>()
val sudoku = Array(9) { IntArray(9) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    for (i in 0 until 9) {
        val numbers = br.readLine().split(" ")
        for (j in 0 until 9) {
            val number = numbers[j].toInt()
            sudoku[i][j] = number
            if (number == 0) {
                pointList.add(Point(i, j))
            }
        }
    }

    dfs(0)
}

fun dfs(depth: Int) {
    if (depth == pointList.size) {

        sudoku.forEach {
            val e = it.joinToString(" ")
            println(e)
        }

        exitProcess(0)
    }

    val (x, y) = pointList[depth]

    for (i in 1..9) {
        if (check(x, y, i)) {
            sudoku[x][y] = i
            dfs(depth + 1)
            sudoku[x][y] = 0
        }
    }
}

fun check(row: Int, col: Int, value: Int): Boolean {
    for (i in 0..8) {
        if (sudoku[row][i] == value) return false
    }

    for (i in 0..8) {
        if (sudoku[i][col] == value) return false
    }

    val startRow = (row / 3) * 3
    val startCol = (col / 3) * 3

    for (i in startRow until startRow + 3) {
        for (j in startCol until startCol + 3) {
            if (sudoku[i][j] == value) return false
        }
    }

    return true
}