package days

import util.readInput

fun main() {
  val input = readInput("day3")
  var priorities = 0

  input.map { line ->
    val repeatedItem = line.substring(0, line.length / 2).toList()
      .intersect(line.substring(line.length / 2, line.length).toList())

    val priority =
      if (repeatedItem.isNotEmpty())
        Character.getNumericValue(repeatedItem.first()) +
          if (repeatedItem.first().isLowerCase()) -9
          else 17
      else 0

    priorities = priorities + priority
  }
  println(priorities)
}


//fun main() {
//  val input = File("src/main/resources", "day3.txt").readLines()
//  val ans = input.chunked(3).map { s ->
//    val s1 = s[0].toSet()
//    val s2 = s[1].toSet()
//    val s3 = s[2].toSet()
//    val c = (s1 intersect s2 intersect  s3).single()
//    val p = if (c in 'a'..'z') c - 'a' + 1 else c - 'A' + 27
//    p
//  }.sum()
//  println(ans)
//}