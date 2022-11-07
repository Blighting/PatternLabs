package pizza

abstract class Pizza(
    val isOpen: Boolean, val isSpicy: Boolean, val ingredients: Ingredients
)

data class Ingredients(
    val cheese: Boolean = true, val meat: Boolean = true, val mushrooms: Boolean = true
)

object Margarita : Pizza(isOpen = true, isSpicy = false, ingredients = Ingredients(mushrooms = false, meat = false)) {
    override fun toString(): String = "Margarita!"
}

object Romana : Pizza(isOpen = true, isSpicy = false, ingredients = Ingredients()) {
    override fun toString(): String = "Romana!"
}

object Calzone : Pizza(isOpen = false, isSpicy = true, ingredients = Ingredients(mushrooms = false)) {
    override fun toString(): String = "Calzone!"
}

class MyCustomPizza(isOpen: Boolean, isSpicy: Boolean, ingredients: Ingredients) : Pizza(
    isOpen, isSpicy, ingredients
) {
    override fun toString(): String = "We don't know such pizza, but we will make it!"
}

object Pizzeria {
    fun createPizza(
        isOpen: Boolean = true,
        isSpicy: Boolean = false,
        ingredients: Ingredients = Ingredients(mushrooms = false, meat = false)
    ): Pizza {
        if (isOpen && !isSpicy && ingredients == Ingredients(mushrooms = false, meat = false)) return Margarita
        if (!isOpen && isSpicy && ingredients == Ingredients(mushrooms = false)) return Calzone
        if (isOpen && !isSpicy && ingredients == Ingredients()) return Romana
        return MyCustomPizza(isOpen, isSpicy, ingredients)
    }
}

fun main() {
    println(Pizzeria.createPizza())
    println(Pizzeria.createPizza(isOpen = false, isSpicy = true, ingredients = Ingredients(mushrooms = false)))
    println(Pizzeria.createPizza(isOpen = false, isSpicy = true, ingredients = Ingredients(cheese = false)))
}