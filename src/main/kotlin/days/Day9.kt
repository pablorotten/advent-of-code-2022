package days

import util.readInput
fun main() {

  val input = readInput("day9test")

  fun ropeMap(lastPosition: Pair<Int, Int>, currentMap: Array<IntArray>, movements: List<String>): Array<IntArray> {
    println(lastPosition.toString() + " " + movements.firstOrNull()?.toString())
    val (x, y) = lastPosition
    return if (movements.isEmpty())
      currentMap
    else
      movements.first().let { movement ->
        Pair(movement[0], movement[2].digitToInt()).let { (direction, m) ->
          when (direction) {
            'U' -> {
              println('U' )
              for (i in y..(y + m)) currentMap[x][i] = 1
              ropeMap(Pair(x, y + m), currentMap, movements.drop(1))
            }
            'D' -> {
              println('D' )
              for (i in y downTo (y - m)) currentMap[x][i] = 1
              ropeMap(Pair(x, y - m), currentMap, movements.drop(1))
            }
            'R' -> {
              println('R' )
              for (i in x .. x + m) currentMap[i][y] = 1
              ropeMap(Pair(x + m, y), currentMap, movements.drop(1))
            }
            else -> {
              println('L' )
              for (i in x downTo x - m) currentMap[i][y] = 1
              ropeMap(Pair(x - m, y), currentMap, movements.drop(1))
            }
          }
        }
      }
  }

  ropeMap(Pair(0,0), Array(6) { kotlin.IntArray(5)}, input).forEach { println(it.toList()) }
}