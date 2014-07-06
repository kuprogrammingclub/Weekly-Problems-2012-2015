object StringTransposer {

	// Returns a list of numLines input lines
	def getInput(numLines: Int): List[String] = {
		(1 to numLines).map(_ => Console.readLine).toList
	}

	def transpose(words: List[String]): List[String] = {
		// For convenience's sake, we'll use a recursive helper function that treats each string as a list of chars
		// (so from here on out, when I say "string," I really mean "list of chars")
		transposeInternal(words.map(_.toList), words.foldLeft(0)((acc,str) => Math.max(acc, str.length))).map(_.mkString)
	}

	private def transposeInternal(words: List[List[Char]], maxWordLength: Int) : List[List[Char]] = {
		// Count keeps track of how many recursive calls remain
		maxWordLength match {
			case 0 => Nil // If count == 0, then we've transposed everything. Return an empty list.
			case _ => { // Otherwise, we'll do some transposin'
				// Retrieves the first chars from each string in the list and makes a new string from them (headCharString)
				val headCharString = words.foldRight(List[Char]())((string, acc) => {
					if (string.size > 0) {
						string.head :: acc
					} else {
						// If a string is empty, then just add space-filler (a space char) to headCharString
						' ' :: acc
					}
				})
				// Creates a new list of strings by removing the first char from each string in the list.
				val tailStrings = words.foldRight(List[List[Char]]())((string, acc) => {
					if (string.size > 0) {
						string.tail :: acc
					} else {
						// If a string is empty, then just add space-filler (an empty string) to tailStrings
						Nil :: acc
					}
				})
				// Recurse on tailStrings until count == 0
				headCharString :: transposeInternal(tailStrings, maxWordLength - 1)
			}
		}
	}

	def main(args: Array[String]): Unit = {
		val lines = Console.readInt
		val input = getInput(lines)
		val transposedLines = transpose(input)
		transposedLines.foreach(println(_))
	}

}