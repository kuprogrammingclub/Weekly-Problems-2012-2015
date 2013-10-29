import scala.collection.GenTraversableOnce
import scala.collection.SortedMap
import scala.io.Source
import scala.util.matching.Regex.MatchIterator

object BookReportBot {

	/** 
	 *  I AM OZYMANDIAS, KING OF REGEXES
	 *  LOOK UPON MY EXPRESSIONS, YE HACKERS, AND DESPAIR
	 */
	val jabberwockyRegex = """(\s+)|(--)""".r // Specialized for Lewis Carroll's DASHing prose (har har har)
	val leadPuncts = """^[^a-zA-Z]+""".r
	val trailPuncts = "[^a-zA-Z]+$".r // Dolla dolla bill, y'all
	
	/** Splits a string into words, using a regex to indicate separators (e.g., spaces, newlines, dashes, etc.) */
	private def fromFile(path: String): Array[String] = jabberwockyRegex split Source.fromFile(path).mkString
	
	/** Removes leading and trailing punctuation from a word and casts it to lowercase */
	private def sanitize(word: CharSequence): String = trailPuncts.replaceAllIn(leadPuncts.replaceFirstIn(word, ""), "").toLowerCase
	
	/** Finds the number of occurrences of each word in the book and sorts the word frequencies alphabetically.
	 *  NOTE: This casts all words, even proper nouns, to lowercase for simplicity purposes. */
	private def mapWordFreqs(book: GenTraversableOnce[String]): SortedMap[String, Int] = book.foldRight(SortedMap[String, Int]())((word,map) => {
		val sWord = sanitize(word)
		if (sWord.isEmpty) map else map.updated(sWord, map.getOrElse(sWord, 0) + 1)
	})
	
	def main(args: Array[String]) {
		mapWordFreqs(fromFile("looking-glass.txt")).foreach(wf => println(wf._1 + ": " + wf._2))
	}
	
}
