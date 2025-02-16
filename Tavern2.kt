import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME1 = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
var gallonsAvailable = 5
var pintGallons = 0.125
//val patronList: List<String> = listOf("Eli","Sophie","Murdoc")
val patronList: MutableList<String> = mutableListOf("Eli","Sophie","Mordoc")
val menuList = File("out/data/Menu.txt")
    .readText()
    .split("\n")
val readOnlyPatronList = patronList.toList()


// patronList[4]
//patronList.getOrElse(4) {Unknown patron}
// val fifthPatron = patronList.getOrNull(4) ?: "Unknown Patron"


fun main(args: Array<String>) {

    //patronList.add(0, "Alex")
    //patronList[1] = "Alexis"

    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards. ")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")
        placeOrder(patron, menuList.shuffled().first())
    }




}
fun performPurchase(price:Double, pintSold:Int):Boolean {

    val totalPurse = playerGold + (playerSilver / 100.0)

    if (totalPurse < price){
        println("You dont have enough Gold!")
        return false
    }
    displayBalance()
    println("Your total purse is $totalPurse")
    println("Price of the drink is $price")
    val balance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(balance)}")
    val remainingGold = balance.toInt()
    val remainingSilver = (balance % 1 * 100).roundToInt()
    val remainingGallons = gallonsAvailable - (pintGallons * pintSold)
    val remainingPints = (remainingGallons / pintGallons).toInt()
    println("Pints remaining in cask : $remainingPints")
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
    return true

}
private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}
private fun toDragonSpeak(phrase: String) = phrase.replace(Regex( "[aeiouAEIOU]")) {
    when (it.value) {
        "a","A" -> "4"
        "e","E" -> "3"
        "i","I" -> "1"
        "o","O" -> "0"
        "u","U" -> "|_|"
        else -> it.value
    }
}
private fun placeOrder(patronName:String, menuData: String):Boolean
{
    val ( type, name, price) = menuData.split(',')

    //if (!performPurchase(price.toDouble(),pintsSold.toInt())){
     //   return false
    //}
    val indexOfApostrophe = TAVERN_NAME1.indexOf('\'')
    val tavernMaster = TAVERN_NAME1.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")


    val message = "$patronName buys a $name ($type) for $price."
    println(message)
    //performPurchase(price.toDouble(),pintsSold.toInt())

    val phrase = if (name == "Dragon's Breath")
    {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else
    {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
    return true
}