import scala.io.Source

object NameRanker {

	val OFFSET = 64 // The value of 'A' represented as an integer in Scala, minus 1

	// A simple-to-understand sorting algorithm. Could be quicker with lists
	def quickSort(array: Array[String]): Array[String] = {
		if (array.isEmpty)  {
			Array[String]() // The empty array
		} else {
			val head = array.head
			val tail = array.tail
			val smallList = quickSort(tail.filter(_ <= head))
			val bigList = quickSort(tail.filter(_ > head))
			smallList ++ Array[String](head) ++ bigList
		}
	}

	def main(args: Array[String]): Unit = {
		val lines = Source.fromFile("names.txt").mkString.split(",") // Create array of names by splitting the commas
		val sortedLines = quickSort(lines)
		val points = sortedLines.zipWithIndex.foldLeft(0)((totalPoints, nameAndIndex) => {
			val name = nameAndIndex._1
			val index = nameAndIndex._2 + 1 // Project Euler uses 1-indexing (LIKE LUA AMIRITE), not 0-indexing like zipWithIndex does
			totalPoints + index * name.foldLeft(0)((namePoints, char) => {
				if (char.isLetter) {
					namePoints + char.toUpper.toInt - OFFSET
				} else {
					namePoints + 0 // Ignore non-letter characters (e.g., quotation marks)
				}
			})
		})
		println(points)
	}

}