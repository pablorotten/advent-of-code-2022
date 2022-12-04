package days

import util.readInput

fun main() {

  val input = readInput("day1")

  fun part1(): Int {
    var max = 0
    var current = 0

    input.map { line ->
      if (line.isNotEmpty())
        current += line.toInt()
      else {
        if (current > max) max = current
        current = 0
      }
    }
    return max
  }

  fun part2(): Int {
    var max = 0
    var calories = 0
    val elvesCalories = mutableListOf<Int>()

    input.map { line ->
      if (line.isNotEmpty())
        calories += line.toInt()
      else {
        elvesCalories.add(calories)
        calories = 0
      }
    }
    return elvesCalories.sorted().takeLast(3).sum()
  }

  println(part1())
  println(part2())
}
