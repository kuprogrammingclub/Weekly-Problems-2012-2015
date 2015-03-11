object Kadane {

  def kadane(seq: IndexedSeq[Int]): (Int, Int, Int) = {
    var maxSum      = -9999999
    var maxStartInd = 0
    var maxEndInd   = 0
    var curMaxSum   = 0
    var curStartInd = 0
    val n = seq.size

    for (curEndInd <- 0 to n-1) {
      curMaxSum += seq(curEndInd)

      if (curMaxSum > maxSum) {
        maxSum      = curMaxSum
        maxStartInd = curStartInd
        maxEndInd   = curEndInd
      }

      if (curMaxSum < 0) {
        curMaxSum   = 0
        curStartInd = curEndInd + 1
      }
    }

    (maxSum, maxStartInd, maxEndInd)
  }

  def pprSeq(seq: IndexedSeq[Int]): Unit = seq match {
    case Seq() => Console.print("[]")
    case seq_  => Console.print("[" + seq_(0))
                      pprSeq_(seq_.tail)

    def pprSeq_(seq: IndexedSeq[Int]): Unit = seq match {
      case Seq() => Console.print(']')
      case seq__  => Console.print(", " + seq__(0))
                    pprSeq_(seq__.tail)
    }
  }

  def main(args: Array[String]): Unit = {
    val seq = IndexedSeq(-2, 1, -3, 4, -1, 2, 1, -5, 4)
//    val seq = IndexedSeq(-2, -5, 6, -2, -3, 1, 5, -6)
//    val seq = IndexedSeq(-2, -1, -1)
//    val seq = IndexedSeq[Int]()

    val (sum, startInd, endInd) = kadane(seq)
    val subSeq = seq.take(endInd+1).drop(startInd)

    Console.println(startInd + ", " + endInd)
    Console.print("Sublist: ")
    pprSeq(seq)
    Console.println(", sum: " + sum)
  }
}
