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

fun main (args: Array<String>) {
    val t = User("a", "b", 1907)
    println(t)

    val userFromEmail = Partner.newUserWithEmail("john@mail.com")
    val userFromUUID = Partner.newUserFromUUID(UUID.randomUUID())
    println("$userFromEmail $userFromUUID")
}
