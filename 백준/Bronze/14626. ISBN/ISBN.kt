import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    var result = 0
    val e = br.readLine()
        .toCharArray()

    var total = 0
    var check = 0

    for (i in 0 until e.size) {
        val ch = e[i]

        if (ch == '*') {
            check = i % 2
            continue
        }

        total += if (i % 2 == 0) {
            ch.toString().toInt() * 1
        } else {
            ch.toString().toInt() * 3
        }
    }

    for (i in 0..9) {
        if (check == 0) {
            val result = total + (i * 1)
            if (result % 10 == 0) println(i)
        } else {
            val result = total + (i * 3)
            if (result % 10 == 0) println(i)
        }
    }
}