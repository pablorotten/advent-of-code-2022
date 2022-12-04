package days

import util.readInput

val points = mapOf("A" to 1, "B" to 2, "C" to 3, "X" to 1, "Y" to 2, "Z" to 3)
fun main() {
  val input = readInput("day2")
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
  println("totalPoints:$totalPoints")
}