package days

object Day3 {

//  Lowercase item types a through z have priorities 1 through 26.
//  Uppercase item types A through Z have priorities 27 through 52.
  @JvmStatic
  fun main(args: Array<String>) {
    val input = this::class.java.getResourceAsStream("/day3.txt")
    var priorities = 0

    input.bufferedReader().useLines { lines ->
      lines.forEach { line ->
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
    }
    println(priorities)
  }
}