package basics

import java.io.File
import java.io.FileNotFoundException
import java.io.OutputStream

// Basic shit function
fun sum(a1: Int, a2: Int): Int  {
    return a1 + a2
}

// Shorthand funcs
fun sumShort(a1: Int, a2: Int): Int = a1 + a2

fun main(args: Array<String>) {
    // Calling funcs
    val res: Int = sum(1, 3)
    val res2: Int = sumShort(1, 3)
    println(res + res2)

    // Initializing 10-len array with squares from 1 to 10 as values
    val squares = IntArray(10, {i -> (i + 1) * (i + 1)})
    println(squares)

    // All types could be nullable, and primitives too
    var nullable: String? = null
    println(nullable)
    nullable = "Shit"
    println(nullable)

    // Check if nullable is not null and upper-cased its letters
    val up: String? = nullable?.toUpperCase()
    println(up) // SHIT

    // Chaining of safe operators
    val low = up?.take(1)?.toLowerCase()
    println(low) // s

    val nonNullString = low!! // Converts nullable type to non-nullable
    val upperCase: String = nonNullString.toUpperCase()
    println(upperCase) // S
    println(up?.toUpperCase() ?: "") // Elvis operator O_o

    // Casting
    fun safeCastingWithElvisl(any: Any?): Int = any as? Int ?: 0 // 0
    println(safeCastingWithElvisl(null))

    // If is expression
    val str: String = if (0 < 10) "low" else "greater"
    println(str) // low

    // When as statement
    when(3) {
        1 -> println("Number is 1")
        2,3,4,5 -> println("Number is in range from 2 to 5") // this shit is printed
    }

    // When as expression
    fun checkNumbersExhaustive(num: Int): String {
        return when(num) {
            1 -> "Number is 1"
            2,3,4,5 -> "Number is in range from 2 to 5"
            else -> "shit"
        }
    }
    println(checkNumbersExhaustive(6)) // shit

    // Check type with when
    fun whenAny(any: Any) {
        when (any) {
            is Int -> println("This is an Int type") // this shit
            is Double -> println("This is a Double type")
            is String -> println("This is a String type")
        }
    }
    whenAny(10)

    // "When true"
    fun whenWithoutArgument(a: Int, b: Int) {
        when {
            a * b > 100 -> println("product of a and b is more than 100") // this shit
            a + b > 100 -> println("sum of a and b is more than 100") // but not also this
            a < b -> println("a is less than b")
        }
    }
    whenWithoutArgument(99, 2)

    // Loop from 1 to 10 included 10
    for (i: Int in 0..10) print(i)

    // Print array
    val array = arrayOf(1, 2, 3)
    for (i in array) print (i)

    // From 1 to 5, 5 excluded
    for (i in 1 until 5) println(i)

    // From 5 to 1, 1 included
    for (i in 5 downTo 1) println(i)

    // Is 5 included into 1..10 range
    if (5 in 1..10) println("5 found in range")

    // try-catch
    val file = File("/etc/shit")
    var stream: OutputStream? = null
    try {
        stream = file.outputStream()
    } catch (ex: FileNotFoundException) {
        println("File doesn't exist") // this shit
    } finally {
        stream?.close()
    }

    // Kotlin reloads == operator that calls .equals(). === is used to compare reference equality
    val a = "Kotlin"
    val b = "Kotlin"
    val c = "Java"
    println("Strings a and b are equal in content: ${a == b}") // true
    println("Strings b and c are equal in reference: ${b === c}") // false - different addresses
}
