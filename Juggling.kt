

fun main(){

    var swordJuggling:Int? = null

    val isProficient = (1..3).shuffled().last() == 3

    if (isProficient){
        swordJuggling = 2
    }

    try {
        proficiencyCheck(swordJuggling)
        swordJuggling = swordJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle $swordJuggling swords!!")


}

fun proficiencyCheck (swords:Int?){
    swords?: throw UnskilledSwordJugglerException()
    //checkNotNull(swordsJuggling, { "Player cannot juggle swords" })
}

fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 3, { "Juggle at least 3 swords to be exciting." })
// Juggle
}

class UnskilledSwordJugglerException():
    IllegalStateException("Player hasnt learned to juggle")
