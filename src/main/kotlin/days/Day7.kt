package days

import util.readInput

typealias Visitor<T> = (TreeNode<T>) -> Unit
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

fun main() {

  val input = readInput("day7")

  //level, acum1, acum2

  fun part1(): Int {

    var directory = TreeNode(0, null)

    input.drop(1).fold(directory) { currentNode, str ->
      when {
        str == """$ ls""" ->
          currentNode

        str == """$ cd ..""" -> {
          currentNode.parent!!.value += currentNode.value
          currentNode.parent!!
        }

        str.startsWith("""$ cd """) ->
          currentNode.add(TreeNode(0, currentNode))

        str.split(" ").get(0).toIntOrNull() !== null ->
          str.split(" ").get(0).toInt()?.let {
            currentNode.value += it
            currentNode
          }!!

        else -> {
          currentNode
        }
      }
    }

    var total = 0
    directory.forEachDepthFirst { if(it.value <= 100000) total += it.value }

    return total
  }


  println(part1())

}
