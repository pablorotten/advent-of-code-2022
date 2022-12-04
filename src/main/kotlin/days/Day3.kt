package days

import util.readInput
import kotlin.math.min

fun main() {
  val input = readInput("day3")

  fun calculateItemPriority(item: Char): Int {
    println("repeated:$item")
    return Character.getNumericValue(item) +
        if (item.isLowerCase()) -9
        else 17
  }

  fun part1(): Int {
    var priorities = 0

    input.map { line ->
      val repeatedItem = line.substring(0, line.length / 2).toSet()
        .intersect(line.substring(line.length / 2, line.length).toSet())

      val priority =
        if (repeatedItem.isNotEmpty())
          calculateItemPriority(repeatedItem.first())
        else 0

      priorities += priority
    }
    return priorities
  }

  fun part2(): Int {
    fun findAndEvaluateBadges(rucksacks: List<String>, currentPriority: Int = 0): Int {
      return if (rucksacks.isEmpty())
        currentPriority
      else
        rucksacks.take(3).let { group ->
          findAndEvaluateBadges(
            rucksacks.drop(min(3, rucksacks.size)),
            currentPriority + calculateItemPriority(group.reduce { repeated, next ->
              repeated.toSet().intersect(next.toSet()).joinToString(",")
            }[0])
          )
        }
    }

    return findAndEvaluateBadges(input)

  }

  println(part1())
  println(part2())


}