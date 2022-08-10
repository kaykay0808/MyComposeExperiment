package com.example.mykotlin

fun main () {

    // From our function
    println("From our function:")
    println(sum(4, 4))

    // From our Lambda
    println("From our Lambda:")
    println(add(12, 12))

    // catAge
    println("Cat age is:")
    println(calculateCatAge(7))
    // Lambda
    println(catAge(7,7))
    name("Kay")

    // Trailing Lambda
    println("Trailing Lambda")
    enhanceMessage(message = "This number ->,"){
        println(it)
        // since it is returning an Int we can use our add lambda
        add(44,44)
    }
}

// Transform this function to a Lambda
fun sum (a: Int, b: Int): Int{
    return a + b
}

// Transforming the function above to a Lambda
//  val lambdaName: Type = { parameterList -> codeBody }
val add: (Int, Int) -> Int = { a, b -> a + b  }

fun calculateCatAge(age: Int): Int = age * 7
val catAge: (Int, Int) -> Int = {catYear, humanYear -> catYear * humanYear}

// not returning anything
val name: (String) -> Unit = { it
    // it is the value we get from our String
    println("Hello my name is $it")
}

// Trailing Lambda
fun enhanceMessage(
    message: String,
    funAsParameter: (String) -> Int
) {
    println("$message ${funAsParameter("My favorite number is: ")}") // when in curley braces we get the result value
}
