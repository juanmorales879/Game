
import java.io.File

fun main (){
    // apply

    val menuFilewoutApply = File("menu-file.txt")
    menuFilewoutApply.setReadable(true)
    menuFilewoutApply.setWritable(true)
    menuFilewoutApply.setExecutable(false)

    val menuFilewApply = File("menu-file.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }

    //let

    val firstItemSquared = listOf(1,2,3).first().let {
        it * it
    }

    fun formatGreeting(vipGuest: String?): String {
        return vipGuest?.let {
            "Welcome, $it. Please, go straight back - your table is ready."
        } ?: "Welcome to the tavern. You'll be seated soon."
    }

    // run

    fun nameIsLong(name: String) = name.length >= 20
    fun playerCreateMessage(nameTooLong: Boolean): String {
        return if (nameTooLong) {
            "Name is too long. Please choose another name."
        } else {
            "Welcome, adventurer"
        }
    }
    "Polarcubis, Supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)

    // takeif

    val fileContents1 = File("myfile.txt")
        .takeIf { it.canRead() && it.canWrite() }
        ?.readText()

    val file = File("myfile.txt")
    val fileContents = if (file.canRead() && file.canWrite()) {
        file.readText()
    } else {
        null
    }

}