import java.util.*
import kotlin.Comparator


/**
 * comparator vs comparable interfaces
 * toProperCase Methode
 * replace
 */
var List: ArrayList<Obj> = ArrayList()

fun main(args: Array<String>) {

    addList()
    println(toProperCase("    hamza slama  eniso"))
    println(toProperCaseWithSpace("    hamza    slama    eniso"))
    val indice = readLine()!!.toString().toInt()
    printListObjectSorted(indice)


}


fun set() {
    var s = "hamza slama "
    println(s.toSet())
    var set = s.toSortedSet()
    val Valurs = HashSet<Int>()
    Valurs.add(7)
    Valurs.add(70)
    Valurs.add(70)
    Valurs.add(71)
    Valurs.add(71)
    for (i in Valurs) {
        println(i)
    }
    for (i in set) {
//        print(" ${set.count()}")
        print(" ${i}")


    }
}

fun toProperCase(str: String): String {

    var sB: StringBuilder? = StringBuilder()
    sB!!.append(str[0].toUpperCase().toString())
    var tttt = str.toCharArray()
    var le = str.length
    var test = false
    for (i in 1..le - 1) {
        var ss = ""

        if (tttt[i] == ' ' && (i <= le - 2)) {
            ss = str[i + 1].toUpperCase().toString()
            test = true
            sB!!.append(ss)
        } else {
            if (test) {
                test = false
            } else
                sB!!.append(str[i])
        }
    }
    return sB.toString().replace(" ", "")

}

fun toProperCaseWithSpace(str: String): String {

    var sB: StringBuilder? = StringBuilder()
    sB!!.append(str[0].toUpperCase().toString())
    var tttt = str.toCharArray()
    var le = str.length
    var test = false
    for (i in 1..le - 1) {
        var ss = ""

        if (tttt[i] == ' ' && (i <= le - 2)) {
            ss = str[i + 1].toUpperCase().toString()
            test = true
            sB!!.append(ss)
        } else {
            if (test) {
                test = false
            } else
                sB!!.append(str[i])
        }
    }
    var str= sB.toString()
    var sB2: StringBuilder? = StringBuilder()

    var i = 0
    while (i< str.length-1) {
        while (str[i] == ' ' && str[i + 1] == ' ') {
            i++

        }
        sB2!!.append(str[i])
        i++
        if ( i == str.length-1)sB2.append(str[i])

    }
    var rtstring = sB2.toString()
    if (rtstring[0] == ' ')rtstring = rtstring.subSequence(1,rtstring.lastIndex+1) as String
    return rtstring

}

class Obj {
    var name: String? = null
    var firstName: String? = null
    var Age: Int? = null

    constructor(name: String, firstName: String, Age: Int) {

        this.Age = Age
        this.name = toProperCase(name)
        this.firstName = toProperCase(firstName)
    }
}

/**
 * o1 , o2
 * return o1.compareTo(o2)
 * ordre corissant
 */
class Comp : Comparator<Obj> {
    override fun compare(o1: Obj?, o2: Obj?): Int {
        return o1!!.Age!!.compareTo(o2!!.Age!!)
    }
}


fun printer(List: ArrayList<Obj>) {
    List.forEach { it ->
        print("Nom   : ${it.name} , Prenom : ${it.firstName}  Age ${it.Age}")
        println("\n-------------")
    }
    println("End Of Printer ! \n ")
}


fun printListObjectSorted(indice: Int) {


    when (indice) {

        1 -> {
            // println(obj.Prenom)
            println("########### Sorted By The Name ##################")
            Collections.sort(List, object : Comparator<Obj> {
                override fun compare(o1: Obj?, o2: Obj?): Int {
                    return o2!!.name!!.compareTo(o1!!.name!!)
                }
            })
            printer(List)

        }
        2 -> {
            /**
             * o1 , o2
             * return o1.compareTo(o2)
             * ordre corissant
             */
            var comp = Comp()
            Collections.sort(List, comp)
            println("###########Sorted By The Age #########")
            printer(List)

        }
        3 -> printer(List)
        4-> set()
    }
}

fun addList() {

    List.add(Obj("  hamza Ben Mohamed ", "Slama La9ab ", 15))
    List.add(Obj("bilel", "slama", 10))
    List.add(Obj("islem", "slama", 13))
    List.add(Obj("mohamed", "slama", 12))
    List.add(Obj("ahmed", "slama", 13))

    List.add(Obj(" zouhair", "slama", 15))
}