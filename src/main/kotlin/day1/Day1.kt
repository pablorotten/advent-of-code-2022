package day1

object Day1 {
  @JvmStatic
  fun main(args: Array<String>) {
    val fileContent = this::class.java.getResourceAsStream("/day1/input.txt")

    fileContent.bufferedReader().useLines { lines ->
      var max = 0
      var current = 0
      lines.forEach { line ->
        if(line.isNotEmpty())
          current = current + line.toInt()
        else {
          if(current > max) max = current
          current = 0
        }

      }

      println("max $max")
    }
  }
}