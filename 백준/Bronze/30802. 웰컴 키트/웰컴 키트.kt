
import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val inputN = br.readLine()
    val inputSize = br.readLine().split(" ")
    val (inputT, inputP) = br.readLine().split(" ")

    val t = inputT.toInt()
    val p = inputP.toInt()

    val n = inputN.toInt()
    var totalT = 0

    for (size in inputSize) {
        val x = size.toInt() / t
        val y = size.toInt() % t

        totalT += x + if (y == 0) 0 else 1
    }

    println(totalT)
    println("${n / p} ${n % p}")
}