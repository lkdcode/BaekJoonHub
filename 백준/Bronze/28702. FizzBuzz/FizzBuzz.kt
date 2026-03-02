import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    fizzBuzz()
}

fun fizzBuzz() {
    val first = br.readLine()
    val second = br.readLine()
    val third = br.readLine()

    val firstNumberOrNull = first.toIntOrNull()
    val secondNumberOrNull = second.toIntOrNull()
    val thirdNumberOrNull = third.toIntOrNull()
    var result = 1
    if (firstNumberOrNull != null) {
        result = firstNumberOrNull + 3
    }

    if (secondNumberOrNull != null) {
        result = secondNumberOrNull + 2
    }

    if (thirdNumberOrNull != null) {
        result = thirdNumberOrNull + 1
    }

    if (result % 15 == 0) {
        println("FizzBuzz")
    } else if (result % 3 == 0) {
        println("Fizz")
    } else if (result % 5 == 0) {
        println("Buzz")
    } else {
        println(result)
    }
}