import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val a = br.readLine()
    val b = br.readLine()
    val c = br.readLine()

    println("${a.toInt() + b.toInt() - c.toInt()}")
    println("${(a + b).toInt() - c.toInt()}")
}