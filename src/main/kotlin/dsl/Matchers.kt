package dsl

infix fun <T> T.shouldBe(expected: T) {
    if (this != expected) {
        throw AssertionError("Expected <$expected>, but was <$this>")
    }
    println("Assertion passed: <$this> == <$expected>")
}

infix fun String.shouldContain(substring: String) {
    if (!this.contains(substring)) {
        throw AssertionError("Expected <$this> contains <$substring>")
    }
    println("Assertion passed: <$this> contains <$substring>")
}
