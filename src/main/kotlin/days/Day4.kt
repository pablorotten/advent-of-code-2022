package days

import util.readInput
import kotlin.math.min

fun main() {
  val input = readInput("day4")

  var overlapping = 0

  input.map { line ->
    line.split(",").let { sections ->
      sections[0].split("-").let { section1 ->
        val s1 = (section1[0].toInt()..section1[1].toInt())
        sections[1].split("-").let { section2 ->
          val s2 = (section2[0].toInt()..section2[1].toInt())
          if(s1.intersect(s2).size == min(s1.count(), s2.count()))
            overlapping = overlapping + 1
        }
      }
    }
  }

  println(overlapping)
}