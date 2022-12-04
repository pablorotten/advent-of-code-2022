package days

import util.readInput

fun main() {
  val input = readInput("day2")
  fun part1(): Int {
    val points = mapOf("A" to 1, "B" to 2, "C" to 3, "X" to 1, "Y" to 2, "Z" to 3)
    var totalPoints = 0

    input.map { line ->
      val player1 = line.getOrElse(0) { ' ' }.toString()
      val player2 = line.getOrElse(2) { ' ' }.toString()

      if (arrayOf("A", "B", "C").contains(player1) && arrayOf("X", "Y", "Z").contains(player2)) {
        val gamePoints = when (player1 to player2) {
          "A" to "Y", "B" to "Z", "C" to "X" -> 6
          else -> if (points[player1] == points[player2]) 3 else 0
        }
        totalPoints += gamePoints + points[player2]!!
      }
    }
    return totalPoints
  }

  // X lose
  // Y draw
  // Z win
  fun part2(): Int {
    val points = mapOf(
      "A" to mapOf("X" to 3, "Y" to 1, "Z" to 2),
      "B" to mapOf("X" to 1, "Y" to 2, "Z" to 3),
      "C" to mapOf("X" to 2, "Y" to 3, "Z" to 1)
    )
    val results = mapOf("X" to 0, "Y" to 3, "Z" to 6)
    var totalPoints = 0

    input.map { line ->
      val player1 = line.getOrElse(0) { ' ' }.toString()
      val result = line.getOrElse(2) { ' ' }.toString()


      val gamePoints = results[result]!! + points[player1]!![result]!!

      totalPoints += gamePoints
    }
    return totalPoints
  }

  println(part1())
  println(part2())
}