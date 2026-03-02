import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = br.readLine().toInt()
    val tanghulu = br.readLine().split(" ").map { it.toInt() }

    val tanghuluList = IntArray(10) { 0 }
    var tanghuluTypeCount = 0

    var left = 0
    var right = 0
    var result = 0

    while (right < n) {
        val current = tanghulu[right]

        if (tanghuluList[current] == 0) {
            tanghuluTypeCount++
        }

        tanghuluList[current]++

        while (tanghuluTypeCount > 2) {
            val discard = tanghulu[left]

            tanghuluList[discard]--

            if (tanghuluList[discard] == 0) {
                tanghuluTypeCount--
            }

            left++
        }

        right++
        result = max(result, tanghuluList.sum())
    }

    println(result)
}