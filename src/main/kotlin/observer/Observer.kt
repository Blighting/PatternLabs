package observer

interface Observer {
    fun update(news: String)
}

class NewsObserver(private val name: String) : Observer {
    override fun update(news: String) {
        println("$name got some news: $news")
    }
}