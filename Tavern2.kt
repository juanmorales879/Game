import kotlin.math.roundToInt

const val TAVERN_NAME1 = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
var gallonsAvailable = 5
var pintGallons = 0.125


fun main(args: Array<String>) {

    placeOrder("elixir,Shirley's Temple,4.12,12")
}
fun performPurchase(price:Double, pintSold:Int):Boolean {

    val totalPurse = playerGold + (playerSilver / 100.0)

    if (totalPurse < price){
        println("You dont have enough Gold Madrigal!")
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
private fun placeOrder(menuData: String):Boolean
{
    val (type, name, price,pintsSold) = menuData.split(',')

    if (!performPurchase(price.toDouble(),pintsSold.toInt())){
        return false
    }
    val indexOfApostrophe = TAVERN_NAME1.indexOf('\'')
    val tavernMaster = TAVERN_NAME1.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val message = "Madrigal buys a $name ($type) for $price."
    println(message)
    performPurchase(price.toDouble(),pintsSold.toInt())

    val phrase = if (name == "Dragon's Breath")
    {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else
    {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
    return true
}