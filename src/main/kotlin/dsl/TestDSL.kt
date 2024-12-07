package dsl

fun TestSuite(name: String, block: TestSuite.() -> Unit): TestSuite {
    val suite = TestSuite(name)
    suite.block()
    return suite
}