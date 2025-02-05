fun main() {

    //using the safe call operator
    var beverage = readLine()?.replaceFirstChar { it.uppercase() }
// beverage = null
    println(beverage)

    // option 1 for dealing with null
    var beverage2 = readLine()?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar{it.uppercase()}
        } else {
            "Buttered Ale"
        }
    }

    println(beverage2)

    // option 2 for dealing with null

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }


}

