package com.example.mykotlin

fun main () {
    val listOfItems = listOf("Kay", "Son Goku", "Super Mario", "Pikachu")
    val listOfNumbers = listOf(88, 99, 100)
    val finder = Finder(list = listOfNumbers)
    finder.findItem(element = 884){
        println("Found $it")
    }
}


// The is that this class will enclose a function that will be able to find an item from a list that we provide to it.
class Finder<T>(private val list: List<T>) {

    fun findItem(
        element: T,
        foundITem: (element: T?) -> Unit
    ) {
        val itemListFound = list.filter {
            it == element
        }
        if (itemListFound.isNullOrEmpty()) foundITem(null)
        else foundITem(itemListFound.first())
    }
}