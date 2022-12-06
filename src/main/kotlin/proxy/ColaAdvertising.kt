package proxy

interface Advertising {
    fun showAd()
}

class ColaAdvertising : Advertising {
    override fun showAd() {
        println("We have best product!!!")
    }
}

class ColaAdvertisingProxy : Advertising {
    private var count = 0
    private val colaAdvertising = ColaAdvertising()
    override fun showAd() {
        colaAdvertising.showAd()
        count++
    }

    fun countAdShowTimes() = count
}

fun main() {
    val proxy = ColaAdvertisingProxy()
    proxy.showAd()
    proxy.showAd()
    println(proxy.countAdShowTimes())
}