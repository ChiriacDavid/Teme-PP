import java.io.File

var text = ""

fun main(){
    val offset = 3     // Valoarea de offset pentru cifrul de criptare, functioneaza si cu negativ
    File("D:\\PP tema 12\\src\\Text.txt").forEachLine {
        var s = it.split(" ")
        for(a in s){
            var temp = a
            if(a.length >= 4 && a.length <= 7){
                temp = ""
                for(i in a){                                    //Pentru exceptiile care vor aparea la salturile de la a la z si invers
                    if(i<='[' && i+offset >='[')
                        temp = temp + (i + offset - 26)
                    else if(i>='@' && i+offset<='@')
                        temp = temp + (i + offset + 26)
                    else if(i<='{' && i+offset>='{')
                        temp = temp + (i + offset - 26)
                    else if(i>='`' && i + offset <= '`')
                        temp = temp + (i + offset + 26)
                    else
                        temp = temp + (i + offset)
                }
            }
            text=text+temp+" "
        }
        text=text+'\n'
    }
    println(text)
}