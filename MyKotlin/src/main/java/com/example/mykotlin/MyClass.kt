package com.example.mykotlin

// Class

private fun main () {

    // Manufacture
    val carOne = Car("Orange", "XXD")
    val carTwo = Car("Red", "model two")
    val speedCarOne = carOne.speed(minSpeed = 100, maxSpeed = 200)

    // car.color = "Blue"
    // car.model = "007"

    println("Car one color is: ${carOne.color}")
    println("Model for car one is: ${carOne.model}")
    println(carOne.drive())
    println(speedCarOne)

    println("")

    println("Car color is: ${carTwo.color}")
    println("Model is: ${carTwo.model}")
    println(carOne.drive())

    // Truck
    println("Truck")
    val truck = Truck("red", "F16")
    truck.drive()
    truck.speed(2, 10)
    //println()
}

// Parent class
open class Car (
    var color: String,
    var model: String
){

    /*init {
        if (color == "Green (Init)") {
            println("Yay Green")
        } else {
            println("$color is not Green (Init)")
        }
    }*/

    // Properties/Attributes was moved to constructor
    //var color: String = color
    //var model: String = model

    // behaviour/functions
    open fun speed (
        minSpeed: Int,
        maxSpeed: Int
    ) {
        println("minimum speed is: $minSpeed and max speed is $maxSpeed")
    }

    open fun drive() {
        println("Drive..... Vrooom like a car")
    }
}

class Truck(color: String, model: String) : Car(color, model) {
    override fun speed(minSpeed: Int, maxSpeed: Int) {
        val fullSpeed = minSpeed * maxSpeed
        println(fullSpeed)
    }

    override fun drive() {
        println("Vrroooom .... Like a Truck")
    }
}
