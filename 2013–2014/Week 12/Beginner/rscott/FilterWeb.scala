import scala.io.Source
import scala.annotation.tailrec

object Balancer {
	
	@tailrec
	def balanced[T <: Char](unclosed: Int = 0, trav: Traversable[T]): Boolean = {
		if (unclosed < 0) {
			false
		} else {
			trav match {
				case Nil => if (unclosed == 0) true else false
				case '(' +: rest => balanced(unclosed + 1, rest)
				case ')' +: rest => balanced(unclosed - 1, rest)
				case _ +: rest => balanced(unclosed, rest)
			}
		}
	}
	
	def main(args: Array[String]) {
		for (line <- Source.stdin.getLines) {
			if (balanced(trav = line)) {
				println("balanced")
			} else {
				println("unbalanced")
			}
		}
	}

}