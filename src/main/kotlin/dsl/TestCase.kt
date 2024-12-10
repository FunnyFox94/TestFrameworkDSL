package dsl

import kotlinx.coroutines.runBlocking

class TestCase(
    val name: String,
    val execute: suspend () -> Unit
) {
    fun run(): Boolean {
        return try {
            runBlocking { execute() }
            Logger.success("Test '$name', passed")
            true
        } catch (e: AssertionError) {
            Logger.error("Test '$name' failed: ${e.message}")
            false
        } catch (e: Exception) {
            Logger.error("Unexpected error in test '$name': ${e.message}")
            false
        }
    }
}