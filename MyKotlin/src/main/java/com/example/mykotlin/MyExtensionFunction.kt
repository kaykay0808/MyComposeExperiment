package com.example.mykotlin


fun main () {
    println("Hello Kay!".append(" You´re awesome as fuck"))
    println("this is fun".removeFirstAndLastChars())
}

fun String.append(toAppend: String) :String {
    return this.plus(toAppend)
}

fun String.removeFirstAndLastChars() : String {
    return this.substring(1, this.length -1)
}