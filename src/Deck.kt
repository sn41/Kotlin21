private val suit: Array<String?> = arrayOf<String?>("крести", "треф", "буби", "пики")

private val card: Array<String?> =
    arrayOf<String?>("шесть", "семь", "восемь", "девять", "десять", "король", "дама", "валет", "туз")

private val points: IntArray = intArrayOf(6, 7, 8, 9, 10, 4, 3, 2, 1)

fun getPoint(id: Int) = points[id % 9]


class Deck() {
    private val exists = BooleanArray(36) {
        true
    }

//    init {
//        for (i in exists.indices) {
//            exists[i] = true;
//        }
//    }

    fun getId(): Int {
        while (true) {
            val i: Int = (0..35).random()
            if (this.exists[i]) {
                this.exists[i] = false
                return i
            }
        }
    }

    fun getName(id: Int): String {
        val point: Int = getPoint(id)

        val indexCard = id % 9
        val cardName: String? = card[indexCard]

        val pointName: String = getPointName(point)

        val indexSuit = id / 9
        val suit: String = suit[indexSuit]!!

        val name = "$point $pointName, $cardName, $suit"

        return name
    }


    private fun getPointName(point: Int) = when (point) {
        0 -> "очко"
        in 1..<4 -> "очка"
        else -> "очков"
    }
}



