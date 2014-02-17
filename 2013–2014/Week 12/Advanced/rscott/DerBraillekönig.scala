import scala.io.Source

object DerBraillekönig {
	
	val C_MAJOR = Set[String]()
	val G_MAJOR = Set("F#")
	val D_MAJOR = G_MAJOR + "C#"
	val A_MAJOR = D_MAJOR + "G#"
	val E_MAJOR = A_MAJOR + "D#"
	val B_MAJOR = E_MAJOR + "A#"
	val FSHARP_MAJOR = B_MAJOR + "E#"
	val CSHARP_MAJOR = FSHARP_MAJOR + "B#"
	val F_MAJOR = Set("Bb")
	val Bb_MAJOR = F_MAJOR + "Eb"
	val Eb_MAJOR = Bb_MAJOR + "Ab"
	val Ab_MAJOR = Eb_MAJOR + "Db"
	val Db_MAJOR = Ab_MAJOR + "Gb"
	val Gb_MAJOR = Db_MAJOR + "Cb"
	val Cb_MAJOR = Gb_MAJOR + "Fb"
	
	def readNotes(str: String): Set[String] = {
		val notes = str.split("w|h|q|e|s").tail
		
		notes.foldLeft(Set[String]())((set, note) => note(0) match {
			case 'r' => set
			case _ => if (note.length() == 1) set else set + note
		})
	}
	
	def signature(notes: Set[String]): String = notes match {
		case `C_MAJOR` => "C major"
		case `G_MAJOR` => "G major"
		case `D_MAJOR` => "D major"
		case `A_MAJOR` => "A major"
		case `E_MAJOR` => "E major"
		case `B_MAJOR` => "B major"
		case `FSHARP_MAJOR` => "F# major"
		case `CSHARP_MAJOR` => "C# major"
		case `F_MAJOR` => "F major"
		case `Bb_MAJOR` => "Bb major"
		case `Eb_MAJOR` => "Eb major"
		case `Ab_MAJOR` => "Ab major"
		case `Db_MAJOR` => "Db major"
		case `Gb_MAJOR` => "Gb major"
		case `Cb_MAJOR` => "Cb major"
		case _ => sys.error("wat")
	}
	
	def output: String => String = signature _ compose readNotes
	
	def main(args: Array[String]) {
		for (line <- Source.stdin.getLines) {
			println(output(line))
		}
	}

}