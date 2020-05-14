var array: ArrayList<Int> = arrayListOf( 1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8)

fun main() {
    println("Lista initiala: $array")


    array.removeAll { it < 5 }  // Pasul 1: elimin elementele mai mici decat  5
    println("Lista dupa eliminarea elementelor mai mici decat 5:$array")


    val ar = array.chunked(2) //Grupez elementele listei 2 cate 2
    println("Lista dupa gruparea elementelor 2 cate 2:$ar")


    val arMulty:ArrayList<Int> = arrayListOf()
    for((a,b) in ar){
        arMulty.add(a*b)  //Adaug in lista arMulty rezultatul inmultirii
                            // elementelor fiecarei perechi
    }
    println("Lista, dupa multiplicarea numerelor din perechi: $arMulty")


    var result:Int = 0
    for(a in arMulty){
        result = result + a      //Adun in result toate valorile listei
    }
    println("Rezultatul adunarii elementelor: $result")
}