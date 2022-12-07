package days

import util.readInput
import java.util.*

fun main() {

  val input = readInput("day5")

  fun initialStacks():Array<LinkedList<Char>> {

    val stacks = Array(10) { LinkedList<Char>() }

    val stacksLines = input.take(8)

    for (line in stacksLines)
      line.chunked(4).forEachIndexed { index, chunk ->
        chunk.getOrNull(1)?.let { crate ->
          if (crate.isLetter()) stacks[index + 1].add(crate)
        }
      }

    return stacks
  }

  fun part1(): String {

    val stacks = initialStacks()

    input.drop(10).map {
      it.replace("[^-?0-9]+".toRegex(), " ").trim().split(" ").let { l ->
        for (i in 1..l[0].toInt()) stacks[l[2].toInt()].addFirst(stacks[l[1].toInt()].remove())
      }
    }

    return stacks.fold("") { top, stack -> top + if(stack.isNotEmpty()) stack[0] else "" }
  }


  fun part2(): String {

    val stacks = initialStacks()

    input.drop(10).map {
      it.replace("[^-?0-9]+".toRegex(), " ").trim().split(" ").let { l ->
        val crane = stacks[l[1].toInt()].take(l[0].toInt())
        crane.forEach{stacks[l[1].toInt()].removeFirst()}
        crane.reversed().map { crate ->
          stacks[l[2].toInt()].addFirst(crate)
        }
      }
    }

    return stacks.fold("") { top, stack -> top + if(stack.isNotEmpty()) stack[0] else "" }
  }

  println(part1())
  println(part2())
}