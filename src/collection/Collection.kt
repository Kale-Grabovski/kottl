package collection

import java.util.*

fun main(args: Array<String>) {
    val arr1 = arrayOfNulls<String>(2)
    arr1[0] = "1"
    arr1[1] = "2"
    println(arr1[1]) // 2

    // Array of Int objects, not int primitives
    val arr2 = arrayOf(1, 2, 3)
    println(arr2[1]) // 2

    // But this is array of int primitives
    val z = intArrayOf(4, 5, 6)
    for (i in z) {
        print(i) // 4 5 6
    }

    // same thit
    z.forEach { i -> print(i) }
    println()

    // indexed
    z.forEachIndexed { index, element ->
        println("$index : $element") // 0 : 4, 1 : 5, 2 : 6
    }

    val arr3 = Array(5) {it.toString() + "s"}
    println(Arrays.toString(arr3)) // [0s, 1s, 2s, 3s, 4s]


    // Lists
    val fruits = mutableListOf<String>("Apple")
    fruits.add("Orange")
    fruits.add(1, "Banana")
    println(fruits)  // [Apple, Banana, Orange]
    fruits.add("Guava")
    println(fruits)  // [Apple, Banana, Orange, Guava]
    fruits.remove("Guava")
    fruits.removeAt(2)
    println(fruits.first() == "Strawberries")
    println(fruits.last() == "Banana")
    println(fruits) // [Apple, Banana]

    // Sets - doesn't allow duplicates
    val nums = mutableSetOf("one", "two")
    nums.add("two") // this shit is ignored
    nums.add("two") // this too
    nums.add("three")
    println(nums) // [one, two, three]

    val numbers = (1..10).toMutableSet()
    println(numbers) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    numbers.add(777) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 777]
    numbers.removeIf { i -> i % 2 == 0 }
    println(numbers) // [1, 3, 5, 7, 9, 777]

    // Maps
    val dict = hashMapOf("foo" to 1)
    dict["bar"] = 2
    val snapshot: MutableMap<String, Int> = dict // now dict and snapshot point to one memory cell
    snapshot["baz"] = 3
    println(snapshot) // {bar=2, baz=3, foo=1}
    println(dict) // {bar=2, baz=3, foo=1} too
    println(snapshot["bar"]) // 2

    // Iters
    val basket = listOf("apple", "banana", "orange")
    val iter = basket.iterator()
    while (iter.hasNext()) {
        println(iter.next())
    }
    // same
    for (i in basket) {
        println(i)
    }
    // same, but in vogue
    fruits.forEach { println(it) }

    // maps iter
    dict.forEach { t, u -> println("$t | $u") }

    // Filter/Map
    val ints = (1..10).toList()
    // Shit method
    val evenInts2 = mutableListOf<Int>()
    for (i in ints) {
        if (i % 2 == 0) {
            evenInts2.add(i)
        }
    }
    // Not shit method
    val evenInts = ints.filter { it % 2 == 0 }
    println(evenInts) // [2, 4, 6, 8, 10]
    val filterMappedShit = ints.filter { it % 2 == 0}.map { it * it}
    println(filterMappedShit) // [4, 16, 36, 64, 100]
    println(filterMappedShit.sum()) // 220 - sum of shit numbers above
}
