import kotlin.math.abs

var input:ArrayList<Int> = arrayListOf()

fun main(){
    println("Numarul de puncte ce formeaza poligonul: ")
    var n= readLine()?.toInt()

    //Am citit linii atat timp cat nu s-au citit toate cele n puncte

    if (n != null) {
        while(n.toInt() > 0) {

            //Am creat liste pentru fiecare rand citit din consola pentru a le putea parcurge pe rand

            var s = readLine()?.split(" ")
            if (s != null) {
                for(i in s){

                    //Am parcurs fiecare lista pentru a crea lista cu datele de input

                    input.add(i.toInt())
                    if(i.toInt() == 1){
                        n -= 1;
                    }
                }
            }
        }

    }
    var pairs = input.zipWithNext()
    var perimetru = 0
    for((a,b) in pairs){
        if(abs(a-b) > 0){
            perimetru = perimetru + 1     // Am verificat
        }
    }

    //Am verificat exceptia dintre primul si ultimul element din lista

    if(abs(pairs[0].first-pairs[pairs.lastIndex].second) == 1){
        perimetru += 1
    }


    println("Perimetrul este $perimetru")
}