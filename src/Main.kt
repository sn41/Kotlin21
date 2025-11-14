import java.util.*

fun main() {

    val gamerCount = 2;
    val results = IntArray(gamerCount) { 0 }

    val scanner = Scanner(System.`in`)

    val deck = Deck()

    for (gamer in 1..gamerCount) {
        var sum = 0

        //вытягиваем карту первый раз
        sum = getCard(deck, sum)
        //вытягиваем карту второй раз
        sum = getCard(deck, sum)

        do {
            //Играем дальше?
            println("Играем? У - да, N - нет")
            val s: String = scanner.nextLine()
            val s1 = s.lowercase().trim { it <= ' ' }[0]

            if (s1 == 'y') {
                //вытягиваем новую карту
                sum = getCard(deck, sum)
                if (sum > 21) {
                    println("Вы проиграли!!");
                    break;
                } else if (sum == 21) {
                    println("Вы выиграли!!");
                    break
                }
            }
        }while (true)

        results[gamer-1] = sum
    }

    grade(results)

}

fun getCard(deck: Deck, sum: Int): Int {
    //вытащить карту
    val id = deck.getId()
    val name = deck.getName(id)
    println(sum.toString() + "\t" + name)
    // копим очки
    return getPoint(id)
}


fun grade(results: IntArray): String {
    return ""
}


