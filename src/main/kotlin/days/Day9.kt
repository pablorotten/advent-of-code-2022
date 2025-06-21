package days

import util.readInput

fun main() {

  val input = readInput("day9test")

  fun ropeMap(lastPosition: Pair<Int, Int>, currentMap: Array<CharArray>, movements: List<String>): Array<CharArray> {
    println(lastPosition.toString() + " " + movements.firstOrNull()?.toString())
    val (x, y) = lastPosition
    return if (movements.isEmpty())
      currentMap
    else
      movements.first().let { movement ->
        Pair(movement[0], movement[2].digitToInt()).let { (direction, m) ->
          when (direction) {
            'U' -> {
              println('U')
              //     return stacks.fold("") { top, stack -> top + if(stack.isNotEmpty()) stack[0] else "" }
              val newMap = (y..(y + m)).fold(currentMap) {matrix, i ->
                if (y + i >= matrix.size) {
                  val newRow = (CharArray(currentMap.first().size) { '.' })
                  newRow[y + i] = '#'
                  matrix + newRow
                }
                else
                  matrix
              }

              ropeMap(Pair(x, y + m), newMap, movements.drop(1))
            }

            'D' -> {
              // if new row in the negative Y axis, prepend it and keep yhe 0 in y NEVER NEGATIVES


              println('D')
              for (i in y downTo (y - m)) currentMap[x][i] = 1
              ropeMap(Pair(x, y - m), currentMap, movements.drop(1))
            }

            'R' -> {
              println('R')
              for (i in x..x + m) currentMap[i][y] = 1
              ropeMap(Pair(x + m, y), currentMap, movements.drop(1))
            }

            else -> {
              println('L')
              for (i in x downTo x - m) currentMap[i][y] = 1
              ropeMap(Pair(x - m, y), currentMap, movements.drop(1))
            }
          }
        }
      }
  }

  ropeMap(
    Pair(0, 0),
    Array(1) { CharArray(input.first().length) { '.' } },
    input
  ).forEach { println(it.toList()) }
}