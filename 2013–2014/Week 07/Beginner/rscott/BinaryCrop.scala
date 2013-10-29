import scala.collection.immutable.IndexedSeq

object BinaryCrop {
	
	// Represents the boundaries of a box
	type EdgeCoords = (Int, Int, Int, Int)
	// Represents a smallest and largest number (i.e., x-coordinates)
	type MinMax = (Int, Int)
	
	val noEdgeCoords = (-1,-1,-1,-1)
	val noMinMax = (-1,-1)
	val matrix = IndexedSeq(
			"00000000000000000000000000000000",
			"00000000000000000000000000000000",
			"00000110011100000000011001110000",
			"00000011110100000000001111010000",
			"00000110011100000000011001110000",
			"00000110111000000000011011100000",
			"00000000001100000000000000110000",
			"00001010000100000000101000010000",
			"00000000000000000000000000000000",
			"00000000000000000000000000000000",
			"00000000000000001000000000000000",
			"00000000000000000000000000000000",
			"00000000000000000000000000000000",
			"00000110011100000000011001110000",
			"00000011110100000000001111010000",
			"00000110011100000000011001110000",
			"00000110111000000000011011100000",
			"00000000001100000000000000110000",
			"00001010000100000000101000010000",
			"00000000000000000000000000000000",
			"00000000000000000000000000000000",
			"00000000000000000000000000000000"
	)
	
	val badMatrix = IndexedSeq(
			"0000000000",
			"0000000000",
			"0000000000",
			"0000000000",
			"0000000000",
			"0000000000"
	)
	
	/** NOTE: This method assumes left-to-right traversal */
	private def remaxify(c: Char, x: Int, mm: MinMax): MinMax = c match {
		case '1' => mm match { // If a 1 is found...
			case `noMinMax` => (x, x) // If there's no min/max yet, create them
			case (left, _) => (left, x) // Otherwise, adjust the max
		}
		case _ => mm // If a 1 isn't found, do nothing
	}
	
	/** NOTE: This method assumes top-to-bottom traversal */
	private def recoordinate(mm: MinMax, y: Int, ec: EdgeCoords): EdgeCoords = mm match {
		case `noMinMax` => ec // If no 1's were found, do nothing
		case _ => ec match { // If a 1 was found...
			case `noEdgeCoords` => (y, mm._1, mm._2, y) // If there's no edge coordinates yet, create them
			case (top, left, right, bottom) => (top, Math.min(left,mm._1), Math.max(right,mm._2), y) // Otherwise, adjust the x-coordinates and bottom
		}
	}
	
	def main(args: Array[String]) {
		val testMatrix = matrix
		//val testMatrix = badMatrix
		val (top, left, right, bottom) = (0 to testMatrix.length - 1).foldLeft(noEdgeCoords)((edgeCoords, y) => { // For each row...
			val line = testMatrix(y) // ...get the row...
			val minMaxX = (0 to line.length - 1).foldLeft(noMinMax)((minMax, x) => remaxify(line(x), x, minMax)) // ...find the leftmost and rightmost 1's (if any)...
			recoordinate(minMaxX, y, edgeCoords) // ...and then adjust the "cropped" edge coordinates (if necessary)
		})
		
		if ((top, left, right, bottom) != noEdgeCoords) {
			(top to bottom) foreach(y => {
				(left to right) foreach(x => print(testMatrix(y)(x)))
				println
			})
		} else {
			println("Your matrix sucks.")
		}
	}

}