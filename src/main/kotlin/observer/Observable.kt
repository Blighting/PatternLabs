package observer

interface Observable {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

class NewsObservable(
    private val news: String
) : Observable {
    private val observers = mutableListOf<Observer>()
    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(news) }
    }

}