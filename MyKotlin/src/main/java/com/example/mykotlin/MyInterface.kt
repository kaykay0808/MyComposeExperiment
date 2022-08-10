package com.example.mykotlin

private fun main () {
    val button = Button(label = "Button")
    button.onClick(message = "This is a button")

    val kay = Character(name = "Kay")
    kay.onClick(message = "this is a character")
}

class Button (val label: String): ClickEvent{
    // how to say that this will implement?
    override fun onClick(message: String) {
        println("Clicked by $label and here is a message: $message")
    }
}

class Character(val name: String): ClickEvent {
    override fun onClick(message: String) {
        println("CLicked by $name, and here is a message: $message")
    }
}

// Interface
interface ClickEvent {
    fun onClick(message: String)
}