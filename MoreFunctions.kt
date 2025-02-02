import org.w3c.dom.html.HTMLOptGroupElement

fun main() {
    val numLetters = "Mississippi".count()
    println(numLetters)

    val numLetter = "Mississippi".count({ letter ->
        letter == 's'
    })

    // this function accepts to arguments and return a string
    val greeting : (String) -> String = { argument->
        val year = 2024
        "Welcome to anonymous function ($year, $argument)"
    }
    val greeting2 : (String, Int) -> String = { argument, number->
        val year = 2024
        "Welcome to anonymous function ($year, $argument, $number)"
    }
    val greeting3  = { argument:String , number:Int ->
        val year = 2024
        "Welcome to anonymous function ($year, $argument, $number)"
    }

    val itKeyword : (String) -> String = {
        val year = 2024
        "Welcome to anonymous function ($year, $it)"
    }

    val numLetterIt = "Mississippi".count{ it == 's' }

    // Lambdas

//    val greetingFunction = {
//        playerName : String, numBuilding:Int ->
//        val year = 2024
//        println("Adding $numBuilding")
//        "Welcome to SimTown, $playerName (COPYRIGHT $year)"
//    }

    runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    closure()
}

inline fun runSimulation (playerName:String, costPrinter : (Int) -> Unit, greetingFunction: (String,Int) -> String){
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName,numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

fun closure(){
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))

}
fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}



