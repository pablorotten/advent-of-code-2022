package days

import util.readInput

typealias Visitor<T> = (TreeNode<T>) -> Unit
//TODO: Remove side effects and more functional!
class TreeNode<T>(var value: T, val parent: TreeNode<T>?) {
  private val node: MutableList<TreeNode<T>> = mutableListOf()

  fun add(child: TreeNode<T>): TreeNode<T> {
    node.add(child)
    return child
  }

  fun forEachDepthFirst(visit: Visitor<T>) {
    visit(this)
    node.forEach {
      it.forEachDepthFirst(visit)
    }
  }

}

fun browse(commands: List<String>): TreeNode<Int> {

  val directory = TreeNode(0, null)

  var node = commands.drop(1).fold(directory) { currentNode, str ->
    when {
      str == """$ ls""" ->
        currentNode

      str == """$ cd ..""" -> {
        currentNode.parent!!.value += currentNode.value
        currentNode.parent!!
      }

      str.startsWith("""$ cd """) ->
        currentNode.add(TreeNode(0, currentNode))

      str.split(" ")[0].toIntOrNull() !== null ->
        str.split(" ")[0].toInt().let {
          currentNode.value += it
          currentNode
        }

      else -> {
        currentNode
      }
    }
  }

  while (node.parent != null) {
    node.parent!!.value += node.value
    node = node.parent!!
  }

  return node
}

fun main() {

  val input = readInput("day7")

  fun part1(): Int {
    val directory = browse(input)
    var total = 0
    directory.forEachDepthFirst { if(it.value <= 100000) total += it.value }

    return total
  }


  fun part2(): Int {
    val directory = browse(input)
    val neededSpace = 30000000
    val availableSpace = 70000000 - directory.value
    val spaceToFree = neededSpace - availableSpace

    var minSpaceToFree = directory.value
    directory.forEachDepthFirst { if(it.value in  spaceToFree .. minSpaceToFree ) minSpaceToFree = it.value }

    return minSpaceToFree
  }

  println(part1())
  println(part2())
}
