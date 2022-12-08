package days

import util.readInput

fun main() {

  val input = readInput("day8")

  fun parseForest(
    forestRows: List<IntArray>,
    forestCols: List<IntArray>,
    forest: List<String>
  ): Pair<List<IntArray>, List<IntArray>> {
    return if (forest.isEmpty())
      Pair(forestRows, forestCols)
    else
      forest.first().let { forestLine ->
        parseForest(
          forestRows.plus(forestLine.map { it.digitToInt() }.toIntArray()),
          forestLine.mapIndexed { index, tree ->
            forestCols[index].plus(tree.digitToInt())
          },
          forest.drop(1)
        )
      }
  }

  fun part1(): Int {

    val (rows, cols) = parseForest(List(0) { IntArray(0) }, List(input.first().length) { IntArray(0) }, input)
    var visibleTrees = 0

    for (r in 1..input.size - 2)
      for (c in 1..input.first().length - 2)
        rows[r][c].let { tree ->
          if (
            rows[r].toList().subList(0, c).none { it >= tree } ||
            rows[r].toList().subList(c + 1, rows.size).none { it >= tree } ||
            cols[c].toList().subList(0, r).none { it >= tree } ||
            cols[c].toList().subList(r + 1, cols.size).none { it >= tree }
          ) visibleTrees++
        }

    return visibleTrees + input.size * 2 + input.first().length * 2 - 4
  }

  fun part2(): Int {

    val (rows, cols) = parseForest(List(0) { IntArray(0) }, List(input.first().length) { IntArray(0) }, input)
    var bestScenicScore = 0

    for (r in 1..input.size - 2)
      for (c in 1..input.first().length - 2)
        rows[r][c].let { tree ->
          val scenicScore =
            rows[r].toList().subList(0, c).reversed()
              .let { it.takeWhile { it < tree }.plus(it.dropWhile { it < tree }.firstOrNull()) }.filterNotNull()
              .count() *
                rows[r].toList().subList(c + 1, cols.size)
                  .let { it.takeWhile { it < tree }.plus(it.dropWhile { it < tree }.firstOrNull()) }.filterNotNull()
                  .count() *
                cols[c].toList().subList(0, r).reversed()
                  .let { it.takeWhile { it < tree }.plus(it.dropWhile { it < tree }.firstOrNull()) }.filterNotNull()
                  .count() *
                cols[c].toList().subList(r + 1, rows.size)
                  .let { it.takeWhile { it < tree }.plus(it.dropWhile { it < tree }.firstOrNull()) }.filterNotNull()
                  .count()
          if (scenicScore > bestScenicScore) bestScenicScore = scenicScore
        }

    return bestScenicScore
  }

  println(part1())
  println(part2())
}