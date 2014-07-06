object WordGames  {
  val vowels = "aeiou"
  val alpha  = "abcdefghijklmnopqrstuvqxyz"

  def main(args: Array[String]){
    if (args.length >= 1){
      lazy val words = io.Source.fromFile(args.head).getLines.toList
      println("All words with all 5 vowels in ascending order: ")
      allVsInOrder(words).foreach(println(_))
      println("All words with all letters in order longer than six letters: ")
      allCsInOrder(words).foreach(println(_))
    }
    else println("Insufficient args")
  }

  def vowelsInOrder(s: String, vs: String = vowels): Boolean = {
    s match {
      case ""  => vs == ""
      case str => {
        val c = str.head
        val tl = str.tail
        if (!vs.isEmpty && c == vs.head) vowelsInOrder(tl, vs.tail)
        else if(!vowels.contains(c)) vowelsInOrder(tl, vs)
        else false
      }
    }
  }
  def lettersInOrder(s: String, letters: String = alpha): Boolean = {
    s match {
      case "" => true
      case str => 
        if(!letters.isEmpty && letters.contains(s.head)) lettersInOrder(str.tail, letters.dropWhile(_ != str.head))
        else false
    }
  }
  def allVsInOrder(strs: List[String]) = strs.filter(vowelsInOrder(_))
  def allCsInOrder(strs: List[String]) = strs.filter(s => s.length >= 6 && lettersInOrder(s))
  
}
