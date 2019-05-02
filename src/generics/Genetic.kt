package generics

fun <T>shit(a: T): String {
    return "Fuck you $a"
}

fun <T> fooBar(arg:T) : T {
    var retval: T = 0 as T
    when (arg) {
        is String -> {
            retval = "Shit" as T
        }
        is Number -> {
            retval = 100 as T
        }
    }

    return retval
}

// Generic ext function
fun <T> List<T>.getIt(index:Int): T {
    return this[index]
}

// With Number constraint. Means it will only work with Ints, Floats and Doubles
class Shit<T:Number>(private val x: T) {
    fun getShit(): T {
        return x
    }
}

// Variance shit
class Group<out T> // Without out this shit does not work
open class Employee(val name:String) {
    override fun toString(): String {
        return name
    }
}
class Programmer(name:String) : Employee(name)

// Contravariant Group<Employee88> is now subtype of Group<Programmer2>
class Group2<in T>
open class Employee88(val name:String) {
    override fun toString(): String {
        return name
    }
}
class Programmer2(name:String) : Employee88(name)

fun main () {
    println(shit(666))
    println(shit(666.777))

    println(fooBar(666)) // 100
    println(fooBar("fuck")) // Shit

    val shit = listOf(1, 5, 6)
    println(shit.getIt(2)) // 6

    println(Shit(666).getShit()) // Ok - 666
    println(Shit(666.33).getShit()) // Ok - 666.33
    //println(Shit("Shit").getShit()) // Not Ok - Strings are not permitted

    val a: Group<Employee> = Group<Programmer>()
    val a2:Group2<Programmer2> = Group2<Employee88>()

    // Subclass/Subtype shit
    var j: Programmer? = Programmer("Ted") // assign non-null to nullable is ok shit
    j = null
    //var i:Programmer = j // assign j (which is null) to non-nullable is bullshit
}
