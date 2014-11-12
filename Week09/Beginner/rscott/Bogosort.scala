import scala.annotation.tailrec
import scala.collection.mutable.Buffer
import scala.math.Ordering.Implicits._
import scala.util.Random

object Bogosort {
  def fisherYatesShuffle[A](a: Buffer[A]): Buffer[A] = {
    val n = a.size
    for (i <- 0 to (n-1)) {
      // Eww, mutability
      val j = Random.nextInt(i+1)
      val tmp = a(j)
      a(j) = a(i)
      a(i) = tmp
    }

    a
  }

  @tailrec
  def isSorted[A: Ordering](l: Buffer[A]): Boolean = {
    if (l.size > 1) {
      l(0) <= l(1) && isSorted(l.tail)
    } else {
      true
    }
  }

  @tailrec
  def bogosort[A: Ordering](l: Buffer[A]): Buffer[A] = {
    if (isSorted(l)) {
      l
    } else {
      val intermediate = fisherYatesShuffle(l)
      Console.println(intermediate)
      bogosort(intermediate)
    }
  }

  def main(args: Array[String]): Unit = {
    Console.println("Now sorting. Please wait several centuries...")
    val sorted = bogosort((10 to 1 by -1).toBuffer)
    Console.println("Done!")
  }
}
