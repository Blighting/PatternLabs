package wrapper

import java.util.*
import java.util.function.Consumer
import java.util.function.IntFunction
import java.util.stream.Stream

class CollectionWrapper<T>(private val collection: Collection<T>) : Collection<T> {
    override val size: Int
        get() = collection.size

    override fun isEmpty(): Boolean {
        logMethod("isEmpty")
        return collection.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        logMethod("iterator")
        return collection.iterator()
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        logMethod("containsAll")
        return collection.containsAll(elements)
    }

    override fun contains(element: T): Boolean {
        logMethod("contains")
        return collection.contains(element)
    }

    override fun forEach(action: Consumer<in T>?) {
        logMethod("for each")
        return collection.forEach(action)
    }

    override fun parallelStream(): Stream<T> {
        logMethod("parallel stream")
        return collection.parallelStream()
    }

    override fun spliterator(): Spliterator<T> {
        logMethod("split iterator")
        return collection.spliterator()
    }

    override fun stream(): Stream<T> {
        logMethod("stream")
        return collection.stream()
    }

    override fun <T : Any?> toArray(generator: IntFunction<Array<T>>?): Array<T> {
        logMethod("to array")
        return collection.toArray(generator)
    }

    private fun logMethod(methodName: String) {
        println(methodName)
        println(collection.hashCode())
    }
}