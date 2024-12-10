package dsl

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

class TestSuite(
    val name: String,
    private val testCases: MutableList<TestCase> = mutableListOf()
) {
    fun testCase(name: String, execute: suspend () -> Unit) {
        testCases.add(TestCase(name, execute))
    }

    fun runAll() {
        Logger.info("Running testsuite $name")

        runBlocking {
            val results = testCases.map { testCase ->
                async {
                        val result = try {
                        testCase.run()
                    } catch (e: Exception) {
                        Logger.error("Enexpected error in test ${testCase.name}: {${e.message}}")
                        false
                    }
                    Pair(testCase.name, result)
                }
        }.awaitAll()

        val passed = results.count { it.second }
        val failed = results.size - passed
        Logger.info("Test suite '$name' succeed: $passed, failed: $failed")
        }
    }
}