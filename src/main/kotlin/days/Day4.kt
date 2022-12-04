package days

import util.readInput
import kotlin.math.min

fun main() {

  val input = readInput("day4")

  fun part1(): Int {
    fun countRecoursive(countSoFar: Int, linesToRead: List<String>): Int {
      return if (linesToRead.isEmpty()) {
        countSoFar
      } else {
        linesToRead.first().split(",").let { sections ->
          sections[0].split("-").let { section1 ->
            val s1 = (section1[0].toInt()..section1[1].toInt())
            sections[1].split("-").let { section2 ->
              val s2 = (section2[0].toInt()..section2[1].toInt())
              if (s1.intersect(s2).size == min(s1.count(), s2.count()))
                countRecoursive(countSoFar + 1, linesToRead.drop(1))
              else
                countRecoursive(countSoFar, linesToRead.drop(1))
            }
          }
        }
      }
    }

    return countRecoursive(0, input)
  }

  fun part2(): Int {
    fun countRecoursive(countSoFar: Int, linesToRead: List<String>): Int {
      return if (linesToRead.isEmpty()) {
        countSoFar
      } else {
        linesToRead.first().split(",").let { sections ->
          sections[0].split("-").let { section1 ->
            val s1 = (section1[0].toInt()..section1[1].toInt())
            sections[1].split("-").let { section2 ->
              val s2 = (section2[0].toInt()..section2[1].toInt())
              if (s1.intersect(s2).isNotEmpty())
                countRecoursive(countSoFar + 1, linesToRead.drop(1))
              else
                countRecoursive(countSoFar, linesToRead.drop(1))
            }
          }
        }
      }
    }

    return countRecoursive(0, input)
  }

  println(part1())
  println(part2())

}