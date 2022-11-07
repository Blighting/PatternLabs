package pizza

abstract class Pizza(
    val isOpen: Boolean,
    val isSpicy: Boolean,
    val ingredients: Ingredients
)

data class Ingredients(
    val cheese: Boolean = true,
    val meat: Boolean = true,
    val mushrooms: Boolean = true
)

object Margarita :
    Pizza(isOpen = true, isSpicy = false, ingredients = Ingredients(mushrooms = false, meat = false))

object Romana :
    Pizza(isOpen = true, isSpicy = false, ingredients = Ingredients())

object Calzone :
    Pizza(isOpen = false, isSpicy = true, ingredients = Ingredients(mushrooms = false))

class MyCustomPizza(isOpen: Boolean, isSpicy: Boolean, ingredients: Ingredients) : Pizza(
    isOpen, isSpicy, ingredients
)

object Pizzeria {
    fun createPizza(
        isOpen: Boolean = true,
        isSpicy: Boolean = false,
        ingredients: Ingredients = Ingredients(mushrooms = false, meat = false)
    ): Pizza {
        if (isOpen && !isSpicy && ingredients ==
            Ingredients(mushrooms = false, meat = false)
        ) return Margarita
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