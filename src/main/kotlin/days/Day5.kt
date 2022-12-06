package days

import util.readInput
import java.util.*

fun main() {

  val input = readInput("day5")

  fun part1(): String {
    val stacks = mapOf(
      1 to LinkedList<Char>(),
      2 to LinkedList<Char>(),
      3 to LinkedList<Char>(),
      4 to LinkedList<Char>(),
      5 to LinkedList<Char>(),
      6 to LinkedList<Char>(),
      7 to LinkedList<Char>(),
      8 to LinkedList<Char>(),
      9 to LinkedList<Char>()
    )

    val stacksLines = input.take(8)

    for(line in stacksLines)
      line.chunked(4).forEachIndexed { index, chunk ->
        chunk.getOrNull(1)?.let { crate ->
          if(crate.isLetter()) stacks[index+1]?.add(crate)
        }
    }

    input.drop(10).map {line ->
      line.replace("[^-?0-9]+".toRegex(), " ").trim().split(" ").let { l ->
        for (i in 1..l[0].toInt()) {
          stacks[l[2].toInt()]!!.addFirst(stacks[l[1].toInt()]!!.remove())
        }
      }
    }

    return stacks.values.fold("") {top, stack -> top + stack[0] }
  }


  println(part1())
}