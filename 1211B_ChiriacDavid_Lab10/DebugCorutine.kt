import kotlinx.coroutines.*
import kotlinx.coroutines.debug.*

suspend fun computeValue(): String = coroutineScope{
    val one = async{ computeOne() }
    val two = async{ computeTwo() }
    combineResults(one, two)
}

suspend fun combineResults(one: Deferred<String>, two:
Deferred<String>): String = one.await()+two.await()

suspend fun computeOne(): String {
    delay(5000)
    return "4"
}

suspend fun computeTwo(): String {
    delay(5000)
    return "2"
}

fun main()= runBlocking {
    DebugProbes.install()
    val deferred = async{ computeValue() }
    delay(1000)
    DebugProbes.dumpCoroutines()
    println("\nDumping only deferred")
    DebugProbes.printJob(deferred)
}