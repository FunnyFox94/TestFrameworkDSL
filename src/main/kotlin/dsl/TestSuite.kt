package dsl

class TestSuite(
    val name: String,
    private val testCases: MutableList<TestCase> = mutableListOf()
) {
    fun testCase(name: String, execute: () -> Unit) {
        testCases.add(TestCase(name, execute))
    }

    fun runAll() {
        println("Running testsuite $name")
        val results = testCases.map { it.run() }
        val passed = results.count { it }
        val failed = results.size - passed
        println("Test suite '$name' succeed: $passed, failed: $failed")
    }
}