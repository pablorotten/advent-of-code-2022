package sandbox

fun main() {

//    val x1 = Array(1) { arrayOf(11, 21, 31) }
//    val x2 = x1.plus(Array(1) { arrayOf(12, 22, 32) })
//    x2.map { println(it.toList()) }
//
//    val forestRows = listOf(listOf(1, 1), listOf(2, 2), listOf(3, 3))
//    println(forestRows)
//
//    println(forestRows.map { it.plus(4) })
//
//    for ( (i, j) in (0..6).zip(0..6 step 2)){
//        println("values are: $i, $j")
//    }
//
//
//    println(listOf(1,2,3,4,5,6,7).subList(0,1))
//    println(listOf(1,2,3,4,5,6,7).subList(2,7))
//
//    for (i in (-5 .. 6))
//        println(i)
//

    val test = List(1) { IntArray(10) { 1 } }
    println(test[0][0])
    val test2 = test.plus( IntArray(10) { 2 })
    println(test2[0][0])
    val test3 = List(1) { IntArray(10) { -1 } } + test2
    println(test3[0][0])
    test3.iterator().forEach{ println(it.toList()) }

}