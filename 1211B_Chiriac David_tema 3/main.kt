import java.io.File

fun spatiiMultiple(path:String){
    var text = File(path).readText()
    while(text.contains("  ") || text.contains("\n ")) {
        text = text.replace("  ", " ")
        text = text.replace("\n ", "\n")
    }
    File(path).writeText(text)
}

fun randNouMultiplu(path:String){
    var text = File(path).readText()
    while(text.contains("\n\n"))
        text = text.replace("\n\n","\n")
    File(path).writeText(text)
}

fun numarPagina(path:String){
    var text = File(path).readText()
    while(text.contains("  +[0-9]+  ".toRegex()))
        text=text.replace("  +[0-9]+  ".toRegex(), " ")
    File(path).writeText(text)
}

fun main(){
    var path = "D:\\PP tema 3\\src\\Text.txt"
    numarPagina(path)
    spatiiMultiple(path)
    randNouMultiplu(path)

}