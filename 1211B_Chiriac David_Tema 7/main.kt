import java.io.File
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

var path="D:\\PP tema 7\\src\\Text.txt"

fun extragere(){
    var text:ArrayList<String> = arrayListOf()
    File(path).forEachLine {

        if(it.contains("Start-Date:")){
            text.add(it)
        }
        if(it.contains("Commandline:")){
            text.add(it)
        }
    }
    var x = DateTimeFormatter
        .ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now())
    var t =text.chunked(2)
    for((a,b) in t) {
        if(a.contains("Start-Date:")){
            println("\nStart-Date: $x\n$b\n")
        }
        else
            println("\n$a\n$b\n")
    }
}

fun main(){
    extragere()
}