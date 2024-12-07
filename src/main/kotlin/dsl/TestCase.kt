package dsl

class TestCase(
    val name: String,
    val execute: () -> Unit
) {
    fun run(): Boolean {
        return try {
            execute()
            println("Test '$name' passed")
            true
        } catch (e: Exception) {
            println("Test '$name' failed: ${e.message}")
            false
        }
    }
}