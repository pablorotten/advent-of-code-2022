package days

import util.readInput
fun main() {

  val input = readInput("day6")

  fun part1(): Int {
    val datastream = input[0].toList()

    for (index in 1 .. datastream.size) {
      val marker = datastream.subList(index - 1, index + 3)
      if (marker.distinct().size == 4)
        return index + 3
    }

    return -1
  }

  println(part1())
}