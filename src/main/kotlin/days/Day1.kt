package days

import util.readInput

fun main() {
  val input = readInput("day1")
  var max = 0
  var current = 0

  input.map { line ->
    if (line.isNotEmpty())
      current = current + line.toInt()
    else {
      if (current > max) max = current
      current = 0
    }

  }

  println("max $max")
}
