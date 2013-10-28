package com.xnux.sandbox

import scala.collection.SortedMap
import scala.io.Source

object BookReportBot {

	val jabberwockyRegex = "(\\s+)|(--)" // Specialized for Lewis Carroll's DASHing prose (har har har)
	
	/** Splits a string into words, using a regex to indicate separators (e.g., spaces, newlines, dashes, etc.) */
	private def fromFile(path: String): Array[String] = Source.fromFile(path).mkString.split(jabberwockyRegex)
	
	/** Removes leading and trailing punctuation from a word and casts it to lowercase */
	private def sanitize(word: String): String = word.replaceFirst("^[^a-zA-Z]+", "").replaceAll("[^a-zA-Z]+$", "").toLowerCase
	
	/** Finds the number of occurrences of each word in the array and sorts the word frequencies alphabetically.
	 *  NOTE: This casts all words, even proper nouns, to lowercase for simplicity purposes. */
	private def mapWordFreqs(book: Array[String]): SortedMap[String, Int] = book.foldRight(SortedMap[String, Int]())((word,map) => {
		val sWord = sanitize(word)
		if (sWord.isEmpty) map else map.updated(sWord, map.getOrElse(sWord, 0) + 1)
	})
	
	def main(args: Array[String]) {
		mapWordFreqs(fromFile("looking-glass.txt")).foreach(wf => println(wf._1 + ": " + wf._2))
	}
	
}