package observer

fun main() {
    val observable = NewsObservable("It works!")
    val observerConcrete = NewsObserver("I am going to be deleted =(")
    observable.registerObserver(observerConcrete)
    observable.notifyObservers()
    repeat(4) {
        observable.registerObserver(NewsObserver("My number is $it"))
    }
    observable.removeObserver(observerConcrete)
    println()
    observable.notifyObservers()
}

/*
    Вывод такой:

    I am going to be deleted =( got some news: It works!

    My number is 0 got some news: It works!
    My number is 1 got some news: It works!
    My number is 2 got some news: It works!
    My number is 3 got some news: It works!

Process finished with exit code 0
 */