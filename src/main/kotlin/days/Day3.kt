package days

import util.readInput

fun main() {
  val input = readInput("day3")
  var priorities = 0

  input.map { line ->
    val repeatedItem = line.substring(0, line.length / 2).toList()
      .intersect(line.substring(line.length / 2, line.length).toList())

    val priority =
      if (repeatedItem.isNotEmpty())
        Character.getNumericValue(repeatedItem.first()) +
          if (repeatedItem.first().isLowerCase()) -9
          else 17
      else 0

    priorities = priorities + priority
  }
  println(priorities)
}