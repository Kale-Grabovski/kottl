package oop

import java.util.*

// Secondary constructor calls primary constructor
// Only one primary constructor is allowed, but secondary ones are unlimited
class User(firstName: String, lastName: String) {
    // No properties =(
    constructor(firstName: String, lastName: String, birthYear: Int): this(firstName, lastName) {}
}

// Factory method implemented with companion object
class Partner private constructor(val userId: String) {
    companion object {
        fun newUserWithEmail(email: String): Partner
        {
            return Partner(email)
        }

        fun newUserFromUUID(uuid: UUID): Partner {
            return Partner(uuid.toString())
        }
    }
}

// Sealed class used as abstract class and can not be initialized
sealed class SuperHero

class Hulk: SuperHero() {
    fun smashOpponent() {

    }
}
class SuperMan : SuperHero() {
    fun flyToKrypton() {

    }
}
class SpiderMan : SuperHero() {
    fun useSpiderSense() {

    }
}
fun actOnHero(hero: SuperHero) {
    when (hero) {
        is Hulk -> {
            hero.smashOpponent()
        }
        is SuperMan -> {
            hero.flyToKrypton()
        }
        is SpiderMan -> {
            hero.useSpiderSense()
        }
    }
}

// Primary ctor
class Person (_name: String) {
    var name: String
    init {
        name = _name
    }
}
// same shit
class Person2 (_name: String) {
    var name: String = _name
}
// same shit but simplified more
class Person22(val name: String)

// Secondary ctors
class Employee  {
    var name:String = "" // mutable
    var empid:String = "" // mutable
    constructor(_name: String) : this(_name, "1001")
    constructor(_name:String, _id: String) {
        name = _name
        empid = _id
    }
}
// this shit is more idiomatic
class Employee2 (_name:String, _empid:String = "1001")  {
    val name = _name // immutable
    val empid = _empid // immutable
}

// Inheritance without open doesn't work
open class Person3(_name:String) {
    val name = _name
    // methods are final by default too
    open fun talk() {
        println("${this.javaClass.simpleName} talking")
    }
}
open class Employee3(_name:String, _empid:String = "1001") : Person3(_name) {
    val empid = _empid
    override fun talk() { // override keyword is required
        super.talk() // call parent shit
        println("Hello")
    }
    // overrides Any.toString() method. also prohibits inherits toString because from now on it's final
    final override fun toString():String{
        return "name: $name | id: $empid"
    }
}
class Programmer(_name:String) : Employee3(_name) {
    override fun talk() {
        super.talk()
        println("Programmer overriding talk()")
    }
}

// Custom getter/setter
class Employee666 {
    var name: String = ""
    get() {
        log("Getting lastname")
        return field
    }
    set(value) {
        log("Setting value of lastname")
        field = value
    }
}
fun log(msg:String) {
    println(msg)
}

// Data classes are useful because we don't need to override toString(), hashCode() and equals() methods
// as in Java
data class Kent(val name:String)

// Singleton. Analog to Java's static call. Ctors are disabled inside this shit.
object Util {
    var name = "Shit"

    init {
        println("Initializing Util")
    }
    fun foo() = println(name)
}

fun main (args: Array<String>) {
    val t = User("a", "b", 1907)
    println(t)

    val userFromEmail = Partner.newUserWithEmail("john@mail.com")
    val userFromUUID = Partner.newUserFromUUID(UUID.randomUUID())
    println("$userFromEmail $userFromUUID")

    actOnHero(SpiderMan())

    // Properties
    val emp = Employee666()
    emp.name = "John Doe"
    println(emp.name)

    // Data classes
    val e1 = Kent("John Doe")
    val e2 = Kent("John Doe")
    println(e1)
    println(e1 == e2) // true

    // Call singleton
    Util.name = "Bar"
    Util.foo() // Bar
}
