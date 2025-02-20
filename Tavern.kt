
const val TAVERN_NAME = "Taernyl's Folly"

fun main() {

    //using the safe call operator
    var beverage = readLine()?.replaceFirstChar { it.uppercase() }
    // beverage = null
    //println(beverage)

    // option 1 for dealing with null
    var beverage2 = readLine()?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar{it.uppercase()}
        } else {
            "Buttered Ale"
        }
    }

    val beverageServed: String = beverage ?: "Buttered Ale"

    //println(beverage2)

    // option 2 for dealing with null, testing 2

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }

    placeOrder1()
    menu("shandy,Dragon's Breath,5.91")
}

private fun placeOrder1() {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
}

private fun menu (menuItem:String){
    //val data = menuItem.split(',')
    //val type = data[0]
    //val name = data[1]
    //val price = data[2]
    //Kotlin allows for deestructuring
    val (type,name,price) = menuItem.split(',')
    val message = "Madrigal buys $name ($type) for $price"
    println(message)
    val phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims ${toSpeak("Ah, delicious $name!")}"
    } else{
        "Thanks for $name"
    }
    println(phrase)

}


private fun toSpeak(phrase: String) = phrase.replace(Regex( "[aeiouAEIOU]")) {
    when (it.value) {
        "a","A" -> "4"
        "e","E" -> "3"
        "i","I" -> "1"
        "o","O" -> "0"
        "u","U" -> "|_|"
        else -> it.value
    }
}


