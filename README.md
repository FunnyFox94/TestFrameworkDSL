## TestFrameworkDSL

A lightweight testing framework with a domain-specific language (DSL) for writing and executing tests. It supports asynchronous test execution, independent test isolation, and provides clean logging for test results.
___

### Features

✅ DSL for describing test cases and suites in a natural, readable format.

✅ Support for asynchronous tests using suspend functions.

✅ Independent test execution (errors in one test do not interrupt others).

✅ Detailed logging of test results (passed/failed).

✅ Easy-to-extend matchers for assertions.
___

## Getting Started

Prerequisites
- Kotlin 1.9 or higher.
- Gradle as the build tool.
___
## Usage
#### Basic Test Example

Create a test suite with several test cases using the DSL:

```kotlin
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
            delay(500)
            val result = 5 + 5
            result shouldBe 11
        }
    }
    suite.runAll()
}
```
#### Output Example

```
INFO: Running testsuite: Sample Tests
SUCCESS: Test 'Test 1' passed.
SUCCESS: Test 'Test 2' passed.
INFO: Testsuite 'Sample Tests' finished: 2 passed, 0 failed.
```
___
Contributing

Contributions are welcome! Please fork the repository, create a branch for your feature or fix, and submit a pull request.
___
License

This project is licensed under the MIT License. See the LICENSE file for details.