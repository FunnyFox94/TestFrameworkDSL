package dsl

object Logger {
    fun info(message: String) = println("INFO: $message")
    fun success(message: String) = println("SUCCESS: $message")
    fun error(message: String) = println("ERROR: $message")
}