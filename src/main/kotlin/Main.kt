import dsl.TestSuite
import dsl.shouldBe
import dsl.shouldContain
import kotlinx.coroutines.delay

fun main() {
    val suite = TestSuite("Async tests") {
        testCase("Test 1") {
            delay(1000)
            val result = 5 + 5
            result shouldBe 10
        }
        testCase("Test 2") {
            delay(1000)
            val result = 5 + 5
            result shouldBe 11
        }
        testCase("Test 3") {
            delay(500)
            val greeting = "Hello kitty"
            greeting shouldContain "kitty"
        }
        testCase("Test 4") {
            delay(500)
            val greeting = "Hello kitty"
            greeting shouldContain "goodbye"
        }
    }

    suite.runAll()
}
