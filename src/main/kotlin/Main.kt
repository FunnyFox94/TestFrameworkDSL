import dsl.TestSuite

fun main() {
    val suite = TestSuite("Sample tests") {
        testCase("Test 1") {
            println("Running Test 1...")
        }
        testCase("Test 2") {
            println("Running Test 1...")
            throw IllegalArgumentException("Something went wrong")
        }
        testCase("Test 3") {
            println("Running Test 3...")
        }
        testCase("Test 4") {
            println("Running Test 4...")
        }
        testCase("Test 5") {
            println("Running Test 5...")
            throw IllegalArgumentException("Something went wrong")
        }
    }

    suite.runAll()
}
