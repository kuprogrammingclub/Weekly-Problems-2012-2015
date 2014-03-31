import java.io.File
import java.util.Scanner
import scala.annotation.tailrec

object StoreCredit {
    val INFILE = "A-large-practice.in"

    @tailrec
    def findPriceMatchIndex(price1: Int, priceSum: Int, prices: List[Int], price2Index: Int): Int = prices match {
        case Nil => 0
        case price2 :: rest => {
            if (price1 + price2 == priceSum) {
                price2Index
            } else {
                findPriceMatchIndex(price1, priceSum, rest, price2Index + 1)
            }
        }
    }

    def findPriceMatches(priceSum: Int, prices: List[Int]): (Int, Int) = {
        @tailrec
        def findPriceMatchesHelper(priceSum: Int, prices: List[Int], price1Index: Int): (Int, Int) = prices match {
            case Nil => sys.error("Cannot find price matches")
            case price1 :: rest => {
                if (price1 < priceSum) {
                    val price2Index = findPriceMatchIndex(price1, priceSum, rest, price1Index + 1)
                    if (price2Index != 0) {
                        (price1Index, price2Index)
                    } else {
                        findPriceMatchesHelper(priceSum, rest, price1Index + 1)
                    }
                } else {
                    findPriceMatchesHelper(priceSum, rest, price1Index + 1)
                }
            }
        }

        findPriceMatchesHelper(priceSum, prices, 1)
    }

    def main(args: Array[String]) {
        val in = new Scanner(new File(INFILE))
        1 to in.nextInt() foreach (caseNum => {
            val priceSum = in.nextInt()
            in.nextInt(); in.nextLine() // WE'RE A STRONG, BEAUTIFUL, INDEPENDENT PROGRAM THAT DON'T NEED NO LIST SIZE
            val prices = in.nextLine().split(' ').toList.map(_.toInt)
            val (price1, price2) = findPriceMatches(priceSum, prices)
            Console.println("Case #" + caseNum + ": " + price1 + ' ' + price2)
        })
        in.close()
    }
}