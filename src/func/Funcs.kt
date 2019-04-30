package func

// Extension funcs
fun String.homerify() = "$this -- woohoo!"
fun String.chanthofy() = "Chan, $this , tho"
fun String.terminatorify() = "$this -- I'll be back"

// Infix funcs
class Person(val name : String) {
    // Infix func accept only one arg
    infix fun say(message: String) = println("$name is saying $message")
}

// + operator overloading
class Employee(var name: String) {
    infix operator  fun plus(emp: Employee) : Employee {
        this.name += " ${emp.name}"
        return this
    }
}

// Daemond problem resolved by overriding foo at Child class
interface A {
    fun foo() {
        println("A:foo")
    }
}
interface B {
    fun foo() {
        println("B:foo")
    }
}
class Child : A, B {
    override fun foo () {
        println("Child:foo")
    }
}

// Interfaces with default implementations
interface Printable {
    fun print(doc:String) = println("printing $doc by printer")
}
interface Fax {
    fun print(doc: String) = println("printing $doc by fax")
}
class MultiFunction : Printable, Fax {
    override fun print(doc:String)  {
        super<Fax>.print(doc)
        super<Printable>.print(doc)
        println("shit")
    }
}

fun main (args: Array<String>) {
    // Extended String class methods
    println("Chmo".homerify())
    println("Chmo".chanthofy())
    println("Chmo".terminatorify())

    // infix shit
    Person("Ken") say "nah" // Ken is saying nah

    // Operator overloading
    val e1 = Employee("piece of")
    val e2 = Employee("shit")
    val e3 = e1 plus e2
    println(e3.name) // piece of shit

    // Daemond
    val shit = Child()
    shit.foo() // Child:foo

    // Interfaces shit
    val shi = MultiFunction()
    shi.print("fuck")
}
