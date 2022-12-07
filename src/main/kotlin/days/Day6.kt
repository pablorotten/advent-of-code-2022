package days

import util.readInput
fun main() {

  val input = readInput("day6")

  fun detector(datastream: List<Char>, chunkSize: Int): Int {
    for (index in 1 .. datastream.size) {
      val marker = datastream.subList(index - 1, index + chunkSize - 1)
      if (marker.distinct().size == chunkSize)
        return index + chunkSize - 1
    }

    return -1
  }

  fun part1(): Int = detector(input[0].toList(), 4)
  fun part2(): Int = detector(input[0].toList(), 14)

  println(part1())
  println(part2())
}