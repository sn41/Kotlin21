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
                if (sum >= 21) break;
            }else break
        }while (true)
        results[gamer-1] = sum
    }

    val winners = grade(results)
    println("Победители: $winners")
}

fun getCard(deck: Deck, sum: Int): Int {
    //вытащить карту
    val id = deck.getId()
    val name = deck.getName(id)
    val sum2 = sum + getPoint(id)
    println("$name, сумма очков = $sum2")
    // копим очки
    return sum2
}


fun grade(results: IntArray): List<Int> {
    // Ищем максимальное количество очков меньшее 22

    var max = 0
    for (gamerIndex in results.indices) {
        val result = results[gamerIndex]
        if(result in (max + 1)..21) { max = result }
    }

    //Получаем список игроков с такими очками
    // Используем цикл
    val winners = ArrayList<Int>()
    for ((gamerIndex, result) in results.withIndex()) {
        if(result == max) { winners.add(gamerIndex) }
    }

    return winners
}


