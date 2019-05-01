package lambda

fun main(args: Array<String>) {
    // Empty lambdas
    val doThis:() -> Unit  = {
        println("shit")
    }
    val doSame = {
        println("fuck")
    }
    fun executor(action:() -> Unit) {
        action()
    }
    executor(doThis) // shit
    executor(doSame) // fuck
    executor() { println("kent") } // kent
    executor { println("cunt") } // cunt

    // With params
    val shit = { msg:String -> println("Hello $msg") }
    fun executor2(display:(msg:String) -> Unit) {
        display("World")
    }
    executor2(shit)

    // Closure
    fun exec(numbers:List<Int>) {
        var sum = 0
        numbers.forEach {
            if (it % 2 == 0) { // it - is a first and only one param of a lambda
                sum += it
            }
        }
        println("Sum of all even numbers = $sum")
    }
    exec(listOf(0..1000).flatten())
}
