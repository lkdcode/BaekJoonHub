package com.sb.framework

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

var count: Int = 0
var minResult = Int.MAX_VALUE
var maxResult = Int.MIN_VALUE
var operator: IntArray = IntArray(4)
lateinit var numbers: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    count = br.readLine().toInt()
    val inputNumbers = StringTokenizer(br.readLine())
    numbers = IntArray(count)

    for (i in 0 until count) {
        numbers[i] = inputNumbers.nextToken().toInt()
    }

    val numbersTokens = StringTokenizer(br.readLine())
    for (i in 0 until 4) {
        operator[i] = numbersTokens.nextToken().toInt()
    }

    dfs(numbers[0], 1)

    println(maxResult)
    println(minResult)
}

fun dfs(number: Int, nextIndex: Int) {
    if (nextIndex == count) {
        minResult = min(minResult, number)
        maxResult = max(maxResult, number)

        return
    }

    for (i in 0 until 4) {
        if (operator[i] > 0) {
            operator[i]--

            when (i) {
                0 -> dfs(number + numbers[nextIndex], nextIndex + 1)
                1 -> dfs(number - numbers[nextIndex], nextIndex + 1)
                2 -> dfs(number * numbers[nextIndex], nextIndex + 1)
                3 -> dfs(number / numbers[nextIndex], nextIndex + 1)
            }

            operator[i]++
        }
    }
}