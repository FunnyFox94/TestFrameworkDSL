package dsl

class TestSuite(
    val name: String,
    private val testCases: MutableList<TestCase> = mutableListOf()
) {
    fun testCase(name: String, execute: suspend () -> Unit) {
        testCases.add(TestCase(name, execute))
    }

    fun runAll() {
        Logger.info("Running testsuite $name")
        val results = testCases.map { it.run() }
        val passed = results.count { it }
        val failed = results.size - passed
        Logger.info("Test suite '$name' succeed: $passed, failed: $failed")
    }
}