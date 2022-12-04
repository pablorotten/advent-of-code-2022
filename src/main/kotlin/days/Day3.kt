package days

import util.readInput

fun main() {
  val input = readInput("day3")
  var priorities = 0

  input.map { line ->
    val repeatedItem = line.substring(0, line.length / 2).toSet()
      .intersect(line.substring(line.length / 2, line.length).toSet())

    val priority =
      if (repeatedItem.isNotEmpty())
        Character.getNumericValue(repeatedItem.first()) +
          if (repeatedItem.first().isLowerCase()) -9
          else 17
      else 0

    priorities += priority
  }
  println(priorities)
}